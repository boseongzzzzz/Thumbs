package com.boram.life.api.fileUpload;

import com.boram.life.admin.dto.PictureDTO;
import com.boram.life.gian.repository.AttachmentRepository;
import com.boram.life.domain.Documents;
import com.boram.life.domain.Member;
import com.boram.life.gian.dto.GianDTO;
import com.boram.life.gian.repository.GianRepository;
import com.boram.life.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadService {

    private static final Logger log = LoggerFactory.getLogger(FileUploadService.class);

    private final FileUploadUtil fileUploadUtil;

    private final MemberRepository memberRepository;

    private final AttachmentRepository attachmentRepository;

    private final GianRepository gianRepository;

    private final ModelMapper modelMapper;

    // 문서 첨부파일 처리 경로
    @Value("src/main/resources/static/attachments")
    private String ATTACHMENT_FILE_DIR;
    @Value("http://localhost:8080/attachments")
    private String ATTACHMENT_FILE_URL;

    // 멤버 사진파일 처리 경로
    @Value("src/main/resources/static/pictures")
    private String PICTURE_FILE_DIR;
    @Value("http://localhost:8080/pictures")
    private String PICTURE_FILE_URL;

    // 멤버 사인파일 처리 경로
    @Value("src/main/resources/static/pictures")
    private String SIGNATURE_FILE_DIR;
    @Value("http://localhost:8080/pictures")
    private String SIGNATURE_FILE_URL;

    @Autowired
    public FileUploadService (FileUploadUtil fileUploadUtil, MemberRepository memberRepository,
                              AttachmentRepository attachmentRepository, GianRepository gianRepository, ModelMapper modelMapper){
        this.fileUploadUtil = fileUploadUtil;
        this.memberRepository = memberRepository;
        this.attachmentRepository = attachmentRepository;
        this.gianRepository = gianRepository;
        this.modelMapper = modelMapper;
    }

    // 문서 첨부파일 처리
    @Transactional
    public Object uploadAttachment(GianDTO gianDTO, MultipartFile attachment){

        // 1. 첨부파일 처리 준비
        String fileName = UUID.randomUUID().toString().replace("-","");
        String replaceFileName = null;
        int result = 0;


        // 2. FileUploadUtil api 활용, 첨부파일 처리
        try {

            replaceFileName = fileUploadUtil.saveFile(ATTACHMENT_FILE_DIR, fileName, attachment);

            gianDTO.setAttachmentsUrl(replaceFileName);

            log.info("[FileUploadService] 첨부파일명 : " + replaceFileName);

            Documents newGian = modelMapper.map(gianDTO, Documents.class);

            gianRepository.save(newGian);

            result = 1;

        } catch (IOException e) {
            fileUploadUtil.deleteFile(ATTACHMENT_FILE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }

        return (result > 0) ? result : "첨부파일 처리가 실패했습니다!";

    }


    // 멤버 사진파일 처리
    @Transactional
    public Object uploadPicture(PictureDTO pictureDTO, MultipartFile picture){

        // 1. 사진파일 처리 준비
        log.info("[FileUploadService] 사진 파일 처리 시작 ===============================");
        log.info("[FileUploadService] 사진 DTO 정보 : " + pictureDTO);
        log.info("[FileUploadService] 파일 정보 : " + picture);
        String fileName = UUID.randomUUID().toString().replace("-","");
        log.info("[FileUploadService] 파일 가공 => UUID name : " + fileName);
        String replaceFileName = null;
        int result = 0;


        // 2. FileUploadUtil api 활용, 첨부파일 처리
        try {

            log.info("[FileUploadService] 사진 파일 저장 시작 ===============================");
            replaceFileName = fileUploadUtil.saveFile(PICTURE_FILE_DIR, fileName, picture);

            pictureDTO.setPictureUrl(replaceFileName);

            log.info("[GianService] 첨부파일명 : " + replaceFileName);

            Member member = modelMapper.map(pictureDTO, Member.class);

            memberRepository.save(member);

            result = 1;

        } catch (IOException e) {
            fileUploadUtil.deleteFile(PICTURE_FILE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }

        return (result > 0) ? result : "첨부파일 처리가 실패했습니다!";

    }

}
