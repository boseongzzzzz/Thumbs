package com.boram.life.gian.service;

import com.boram.life.api.FileUploadUtil;
import com.boram.life.domain.Draft;
import com.boram.life.gian.dto.GianDTO;
import com.boram.life.gian.repository.GianRepository;
import com.boram.life.gian.repository.PositionRepository;
import com.boram.life.member.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.util.UUID;


@Service
public class GianService {

    private static final Logger log = LoggerFactory.getLogger(GianService.class);

    private final GianRepository gianRepository;
    private final MemberRepository memberRepository;

    private final PositionRepository positionRepository;

    private final ModelMapper modelMapper;

    @Value("src/main/resources/static/attachments")
    private String FILE_DIR;
    @Value("http://localhost:8080/attachments")
    private String FILE_URL;

    @Autowired
    public GianService(GianRepository gianRepository, MemberRepository memberRepository, PositionRepository positionRepository, ModelMapper modelMapper) {
        this.gianRepository = gianRepository;
        this.memberRepository = memberRepository;
        this.positionRepository = positionRepository;
        this.modelMapper = modelMapper;
    }

    // 사용자가 입력한 기안 폼을 바탕으로 데이터를 DB에 생성하고, 해당 결과를 돌려준다.
    @Transactional
    public Object registGian(Authentication authentication, GianDTO gianDTO, MultipartFile gianAttachments) {

        log.info("[GianService] registGian 메소드 시작 : 입력한 기안 폼을 DB에 등록하는 프로세스 시작");
        log.info("[GianService] GianDTO (사용자가 입력한 폼 내용) : " + gianDTO);

        gianDTO.setDraftMember1(memberRepository.findMember(Long.valueOf(authentication.getName())));

        // 1. 필수요소 체크 및 처리
        if (gianDTO.getDraftTitle()==null){
            return "제목을 입력해주세요!";

//        } else if (gianDTO.getDraftDetails()==null) {
//            return "내용을 입력해주세요!"; <- 내용이 배열로 들어오는 것도 있고 해서 일단 주석화.

        } else if (gianDTO.getDraftMember1()==null) {
            return "기안자가 지정되지 않았습니다! (로그인을 확인해보세요)";

        } else if (gianDTO.getDraftMember2()==null) {
            return "중간 결재자가 지정되지 않았습니다!";

        } else if (gianDTO.getDraftMember3()==null) {
            return "최종 결재자가 지정되지 않았습니다!";

        } else if (gianDTO.getDocument().getDocumentsId()==1){
            // 문서 형식에 따른 처리 1
            // 문서형식1은 아마 보직(position)

        } else if (gianDTO.getDocument().getDocumentsId()==2){
            // 문서 형식에 따른 처리 2
            // 문서형식2는 아마 진급(promotion)

        } else if (gianDTO.getDocument().getDocumentsId()==3){
            // 문서 형식에 따른 처리 3
            // 문서형식3은 아마 징계(punishment)
        }

        // 2. 첨부파일 처리 준비
        String fileName = UUID.randomUUID().toString().replace("-","");
        String replaceFileName = null;
        int result = 0;


        // 3. FileUploadUtil api 활용, 첨부파일 처리
        try {

            replaceFileName = FileUploadUtil.saveFile(FILE_DIR, fileName, gianAttachments);

            gianDTO.setAttachmentsUrl(replaceFileName);

            log.info("[GianService] 첨부파일명 : " + replaceFileName);

            Draft newGian = modelMapper.map(gianDTO, Draft.class);

            gianRepository.save(newGian);

            result = 1;

        } catch (IOException e) {
            FileUploadUtil.deleteFile(FILE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }

        return (result > 0) ? result : "첨부파일 처리가 실패했습니다!";

    }

    // 로그인한 유저 정보로 1결재자(=기안자)의 정보를 가져와 리턴하는 메소드 ("부서"+"직책"+"이름")
    public String selectUserTag(long userId) {

        //멤버의 '부서'를 가져오는 메소드
        String position = positionRepository.getReferenceById(Integer.valueOf((int)userId)).getPositionDepartment().getDeptName();

        //멤버의 '직책'를 가져오는 메소드
        String grade = positionRepository.getReferenceById(Integer.valueOf((int)userId)).getPositionRank();

        // 멤버의 '이름'을 가져오는 메소드 (* 현재 사용하지 않음)
        String name = memberRepository.findMember(userId).getMemberName();

        return position + " " + grade + " " + name;
    }
}
