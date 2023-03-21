package com.boram.life.approval.dto;

import com.boram.life.domain.Member;
import com.boram.life.domain.Reject;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApprovalDTO {
    private Long documentNo;
    private String documentTitle;
    private String documentDetails;
    private Date documentDraftDate;
    private Long documentStatus;
    private Date documentFinalApprove;
    private Reject documentReject;
    private Member approvalMember1;
    private String approvalMember2;
    private String approvalMember3;
    private String attachmentUuidName;
    private String formName;
    private String documentReceivers;
    private String documentReferrers;
    private String signatureUuidName;

    public ApprovalDTO(Long documentNo, String documentTitle, String documentDetails, Date documentDraftDate, Member approvalMember1, String approvalMember2, String approvalMember3, String documentReceivers, String documentReferrers) {
        this.documentNo = documentNo;
        this.documentTitle = documentTitle;
        this.documentDetails = documentDetails;
        this.documentDraftDate = documentDraftDate;
        this.approvalMember1 = approvalMember1;
        this.approvalMember2 = approvalMember2;
        this.approvalMember3 = approvalMember3;
        this.documentReceivers = documentReceivers;
        this.documentReferrers = documentReferrers;
    }
}

