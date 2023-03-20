package com.boram.life.approval.controller;

import com.boram.life.approval.dto.DraftDTO;
import com.boram.life.approval.service.AprvlDocsService;
import com.boram.life.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/approval")
public class AprvlDocsController {

    private final AprvlDocsService draftService;

    @Autowired
    public AprvlDocsController(AprvlDocsService draftService) {
        this.draftService = draftService;
    }

    // 진행문서함 -기안
    @GetMapping("draft")
    public String findAllByDraftStatusAndMemberName(Model model,
                               @ModelAttribute("memberName") String memberName) {
        System.out.println("model ========================== " + model);
        List<DraftDTO> drafts = draftService.findAllByDraftStatusAndMemberName(memberName);
        System.out.println("drafts =>>>>>>>>>>>>>>>>>>> " + drafts);
        model.addAttribute("draftList", drafts);
        return "/content/approval/draft";
    }

    // 진행문서함 -결재
    @GetMapping("approval")
    public String findAllByApprovalMember(Model model,
                               @ModelAttribute("memberName") String memberName) {
        System.out.println("model ========================== " + model);
        List<DraftDTO> drafts = draftService.findAllByApprovalMember(memberName);
        System.out.println("drafts =>>>>>>>>>>>>>>>>>>> " + drafts);
        model.addAttribute("draftList", drafts);
        return "/content/approval/approval";
    }

    // 진행문서함 -참조


    // 완료문서함 - 기안 완료


    @GetMapping("/{documentNo}")
    public String showSelectedDraft(@PathVariable Long documentNo, Model model) {
        DraftDTO draftDTO = draftService.getSelectedDraft(documentNo);
        // approvalMember1의 positionDepartment 값을 receipt 필드에 할당
//        Position position = draftDTO.getDocument().getApprovalMember1().getPositionMember().getPositionDepartment();
//        draftDTO.setReceipt(position.getDeptName());

        // documentNo 값을 receipt2 필드에 할당
        draftDTO.setReceipt2(String.valueOf(documentNo));

        model.addAttribute("draftDTO", draftDTO);
        return "/content/approval/DocumentIng";
    }


    @PostMapping("/{documentNo}")
    public String saveSelectedDraft(@PathVariable Long documentNo, @ModelAttribute DraftDTO draftDTO) {
        // 받은 form 데이터를 바탕으로 db에 저장
        draftService.saveSelectedDraft(documentNo, draftDTO);
        // db에 저장된 documentStatus 업데이트
        draftService.updateDocumentStatus(documentNo, 2L);
        // 다음 페이지로 이동
        return "redirect:/approval/draft";
    }
}

