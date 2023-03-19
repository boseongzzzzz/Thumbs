package com.boram.life.aprvlDocuments.dto;

import com.boram.life.domain.Attachments;
import com.boram.life.domain.Documents;
import com.boram.life.domain.Member;
import com.boram.life.domain.Reject;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DraftDTO {
    private Long documentNo;
    private String documentTitle;
    private String documentDetails;
    private Date documentDraftDate;
    private String documentStatus;
    private Date documentFinalApprove;
    private Reject documentReject;
    private Documents document;
    private String approvalMember1;
    private String approvalMember2;
    private String approvalMember3;
    private String attachmentUuidName;
    private String formName;
    private String documentReceivers;
    private String documentReferrers;

    public DraftDTO(Long documentNo, String formName, String documentTitle, String approvalMember1, String attachmentUuidName, Date documentDraftDate) {
        this.documentNo = documentNo;
        this.formName = formName;
        this.documentTitle = documentTitle;
        this.documentDraftDate = documentDraftDate;
        this.approvalMember1 = approvalMember1;
        this.attachmentUuidName = attachmentUuidName;
    }

    public DraftDTO(Long documentNo, String documentTitle, String documentDetails, String approvalMember1, String documentReceivers, String documentReferrers) {
        this.documentNo = documentNo;
        this.documentTitle = documentTitle;
        this.documentDetails = documentDetails;
        this.approvalMember1 = approvalMember1;
        this.documentReceivers = documentReceivers;
        this.documentReferrers = documentReferrers;
    }
}


