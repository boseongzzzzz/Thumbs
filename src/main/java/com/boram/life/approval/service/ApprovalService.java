package com.boram.life.approval.service;

import com.boram.life.admin.controller.AdminController;
import com.boram.life.approval.dto.ApprovalDTO;
import com.boram.life.domain.Documents;
import com.boram.life.approval.dto.DraftDTO;
import com.boram.life.approval.repository.DraftRepository;
import com.boram.life.gian.repository.PositionRepository;
import com.boram.life.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApprovalService {
    private final DraftRepository draftRepository;
    private final ModelMapper modelMapper;
    private final PositionRepository positionRepository;
    private final MemberRepository memberRepository;
    private final Logger log = LoggerFactory.getLogger(AdminController.class);
    public ApprovalService(DraftRepository draftRepository, PositionRepository positionRepository, MemberRepository memberRepository) {
        this.positionRepository = positionRepository;
        this.memberRepository = memberRepository;
        this.draftRepository = draftRepository;
        this.modelMapper = new ModelMapper();
    }

    // 진행문서함 -기안
    public List<DraftDTO> findAllByDraftStatusAndMemberName(@ModelAttribute("memberName") String memberName) {
        List<DraftDTO> drafts = draftRepository.findAllByDraftStatusAndMemberName(memberName);
        System.out.println("drafts =0000000000000 " + drafts);
        return drafts;//drafts.stream().map(draft -> modelMapper.map(draft, DraftDTO.class)).collect(Collectors.toList());
    }

    // 진행문서함 -결재
    public List<DraftDTO> findAllByApprovalMember(@ModelAttribute("memberName") String memberName) {
        List<DraftDTO> drafts = draftRepository.findAllByApprovalMember(memberName);
        System.out.println("drafts =0000000000000 " + drafts);
        return drafts.stream().map(draft -> modelMapper.map(draft, DraftDTO.class)).collect(Collectors.toList());
    }

    public DraftDTO getDocumentById(Long documentNo) {
        Documents document = draftRepository.findById(documentNo).orElse(null);
        return modelMapper.map(document, DraftDTO.class);
    }

    // 진행문서함 -참조

    public ApprovalDTO getSelectedDraft(Long documentNo) {
        log.info("ApprovalDTO >>>>>>>>>>>>>>>>>>>>>");
        Documents document = draftRepository.findByDocumentNo(documentNo);
        log.info("document >>>>>>>>>>>>>>>>>>>>>" + document);
        return modelMapper.map(document, ApprovalDTO.class);
    }

    public void saveSelectedDraft(Long documentNo, DraftDTO draftDTO) {
        Documents document = draftRepository.findByDocumentNo(documentNo);
        // db에 저장
        document.setDocumentTitle(draftDTO.getDocumentTitle());
        document.setDocumentDetails(draftDTO.getDocumentDetails());
        document.setDocumentReceivers(draftDTO.getDocumentReceivers());
        document.setDocumentReferrers(draftDTO.getDocumentReferrers());
        draftRepository.save(document);
    }

    public void updateDocumentStatus(Long documentNo, Long status) {
        Documents document = draftRepository.findByDocumentNo(documentNo);
        document.setDocumentStatus(status);
        draftRepository.save(document);
    }

    // 로그인한 유저 정보로 1결재자(=기안자)의 정보를 가져와 리턴하는 메소드 ("부서"+"직책"+"이름")
    public String selectUserTag(long userId) {

//        //멤버의 '부서'를 가져오는 메소드
//        String position = positionRepository.getReferenceById(Integer.valueOf((int)userId)).getPositionDepartment().getDeptName();
//
//        //멤버의 '직책'를 가져오는 메소드
//        String grade = positionRepository.getReferenceById(Integer.valueOf((int)userId)).getPositionDuty();

        // 멤버의 '이름'을 가져오는 메소드 (* 현재 사용하지 않음)
        String name = memberRepository.findByMemberId(String.valueOf(userId)).get().getMemberName();

        return name;
    }
}



