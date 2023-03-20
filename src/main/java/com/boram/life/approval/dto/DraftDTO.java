package com.boram.life.approval.dto;

import com.boram.life.domain.Documents;
import com.boram.life.domain.Reject;
import lombok.*;

import java.util.Date;

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
    private Long documentStatus;
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
    private String signatureUuidName;
    private String receipt;
    private String receipt2;

    public DraftDTO(Long documentNo, String formName, Long documentStatus, String documentTitle, String attachmentUuidName, Date documentDraftDate) {
        this.documentNo = documentNo;
        this.formName = formName;
        this.documentStatus = documentStatus;
        this.documentTitle = documentTitle;
        this.documentDraftDate = documentDraftDate;
        this.attachmentUuidName = attachmentUuidName;
    }

    public DraftDTO(Long documentNo, String documentTitle, String documentDetails, String approvalMember1, String documentReceivers, String documentReferrers, String signatureUuidName) {
        this.documentNo = documentNo;
        this.documentTitle = documentTitle;
        this.documentDetails = documentDetails;
        this.approvalMember1 = approvalMember1;
        this.documentReceivers = documentReceivers;
        this.documentReferrers = documentReferrers;
        this.signatureUuidName = signatureUuidName;
    }

    public DraftDTO(Long documentNo, String formName, Long documentStatus, String documentTitle, String approvalMember1, String attachmentUuidName, Date documentDraftDate) {
        this.documentNo = documentNo;
        this.formName = formName;
        this.documentStatus = documentStatus;
        this.documentTitle = documentTitle;
        this.documentDraftDate = documentDraftDate;
        this.approvalMember1 = approvalMember1;
        this.attachmentUuidName = attachmentUuidName;
    }

    public DraftDTO(Long documentNo, String documentTitle, Date documentFinalApprove, String attachmentUuidName, String formName) {
        this.documentNo = documentNo;
        this.documentTitle = documentTitle;
        this.documentFinalApprove = documentFinalApprove;
        this.attachmentUuidName = attachmentUuidName;
        this.formName = formName;
    }
}
