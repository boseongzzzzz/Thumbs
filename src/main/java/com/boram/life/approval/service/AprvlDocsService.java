package com.boram.life.approval.service;

import com.boram.life.domain.Documents;
import com.boram.life.approval.dto.DraftDTO;
import com.boram.life.approval.repository.DraftRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AprvlDocsService {
    private final DraftRepository draftRepository;
    private final ModelMapper modelMapper;

    public AprvlDocsService(DraftRepository draftRepository) {
        this.draftRepository = draftRepository;
        this.modelMapper = new ModelMapper();
    }

    // 진행문서함 -기안
    public List<DraftDTO> findAllByDraftStatusAndMemberName(@ModelAttribute("memberName") String memberName) {
        List<DraftDTO> drafts = draftRepository.findAllByDraftStatusAndMemberName(memberName);
        System.out.println("drafts =0000000000000 " + drafts);
        return drafts.stream().map(draft -> modelMapper.map(draft, DraftDTO.class)).collect(Collectors.toList());
    }

    // 진행문서함 -결재
    public List<DraftDTO> findAllByApprovalMember(@ModelAttribute("memberName") String memberName) {
        List<DraftDTO> drafts = draftRepository.findAllByApprovalMember(memberName);
        System.out.println("drafts =0000000000000 " + drafts);
        return drafts.stream().map(draft -> modelMapper.map(draft, DraftDTO.class)).collect(Collectors.toList());
    }

    public DraftDTO getSelectedDraft(Long documentNo) {
        Documents document = draftRepository.findByDocumentNo(documentNo);
        return modelMapper.map(document, DraftDTO.class);
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
}



