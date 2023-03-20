package com.boram.life.aprvlDocuments.controller;

import com.boram.life.aprvlDocuments.dto.DraftDTO;
import com.boram.life.aprvlDocuments.service.AprvlDocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aprvlDocuments")
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
        return "/content/aprvlDocuments/draft";
    }

    // 진행문서함 -결재
    @GetMapping("approval")
    public String findAllByApprovalMember(Model model,
                               @ModelAttribute("memberName") String memberName) {
        System.out.println("model ========================== " + model);
        List<DraftDTO> drafts = draftService.findAllByApprovalMember(memberName);
        System.out.println("drafts =>>>>>>>>>>>>>>>>>>> " + drafts);
        model.addAttribute("draftList", drafts);
        return "/content/aprvlDocuments/approval";
    }

    @GetMapping("/{documentNo}")
    public String showSelectedDraft(@PathVariable Long documentNo, Model model) {
        DraftDTO draftDTO = draftService.getSelectedDraft(documentNo);
        model.addAttribute("draftDTO", draftDTO);
        return "/content/aprvlDocuments/DocumentIng";
    }


    @PostMapping("/{documentNo}")
    public String saveSelectedDraft(@PathVariable Long documentNo, @ModelAttribute DraftDTO draftDTO) {
        // 받은 form 데이터를 바탕으로 db에 저장
        draftService.saveSelectedDraft(documentNo, draftDTO);
        // db에 저장된 documentStatus 업데이트
        draftService.updateDocumentStatus(documentNo, 2L);
        // 다음 페이지로 이동
        return "redirect:/aprvlDocuments/draft";
    }
}

