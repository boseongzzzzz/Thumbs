package com.boram.life.approval.controller;

import com.boram.life.admin.controller.AdminController;
import com.boram.life.approval.dto.DraftDTO;
import com.boram.life.approval.dto.ApprovalDTO;
import com.boram.life.approval.service.ApprovalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;
    private final Logger log = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    // 진행문서함 -기안
    @GetMapping("/draft")
    public String findAllByDraftStatusAndMemberName(Model model, Authentication authentication)
//                               @PathVariable("memberName") String memberName)
                               {
        long userId = Long.parseLong(authentication.getName());
        String loginUserName = approvalService.selectUserTag(userId);
        model.addAttribute("memberName", loginUserName);
        System.out.println("memberName ========================== " + loginUserName);
        List<DraftDTO> drafts = approvalService.findAllByDraftStatusAndMemberName(loginUserName);
        System.out.println("drafts =>>>>>>>>>>>>>>>>>>> " + drafts);
        model.addAttribute("draftList", drafts);
        return "content/approval/draft";
    }

    // 리스트에서 클릭한 문서 상세페이지 이동(읽기전용)
    @GetMapping("/ApprovalLine1/{documentNo}")
    public String getApprovalLine(@PathVariable Long documentNo, Model model) {
        // 문서를 읽기 전용으로 가져오는 코드 작성
        DraftDTO draftDTO = approvalService.getDocumentById(documentNo);
        // 문서를 모델에 추가하여 ApprovalLine1.html에 전달
        model.addAttribute("draftDTO", draftDTO);

        return "/content/approval/ApprovalLine1";
    }

    // 진행문서함 -결재
    @GetMapping("approval")
    public String findAllByApprovalMember(Model model,
                               @ModelAttribute("memberName") String memberName) {
        System.out.println("model ========================== " + model);
        List<DraftDTO> drafts = approvalService.findAllByApprovalMember(memberName);
        System.out.println("drafts =>>>>>>>>>>>>>>>>>>> " + drafts);
        model.addAttribute("draftList", drafts);
        return "content/approval/approval";
    }

    // 진행문서함 -참조


    // 완료문서함 - 기안 완료


    @GetMapping("/documentIng/{documentNo}")
    public String showSelectedDraft(@PathVariable Long documentNo, Model model) {
        log.info("documentIng 호출됨>>>>>>>>>>>>>>>>>>>>");
        ApprovalDTO approvalDTO = approvalService.getSelectedDraft(documentNo);
        log.info("approvalDTO >>>>>>>>>>>>>>>>>>>>>" + approvalDTO);
//        Arrays.stream(approvalDTO.getClass().getDeclaredFields())
//                .forEach(field -> {
//                    field.setAccessible(true);
//                    try {
//                        Object value = field.get(approvalDTO);
//                        if (value == null) {
//                            field.set(approvalDTO, "　");
//                        }
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                });
//        log.info("가공된 approvalDTO>>>>>>>>>>>>>>>>>>"+ approvalDTO);
        model.addAttribute("approvalDTO", approvalDTO);
        return "content/approval/DocumentIng";
    }

    @PostMapping("/documentIng/save/{documentNo}")
    public String saveSelectedDraft(@PathVariable Long documentNo, @ModelAttribute DraftDTO draftDTO) {
        // 받은 form 데이터를 바탕으로 db에 저장
        approvalService.saveSelectedDraft(documentNo, draftDTO);
        // db에 저장된 documentStatus 업데이트
        approvalService.updateDocumentStatus(documentNo, 2L);
        // 다음 페이지로 이동
        return "redirect:/content/approval/draft";
    }
}

