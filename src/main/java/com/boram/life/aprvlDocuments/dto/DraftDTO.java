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
    private Long draftId;
    private String draftTitle;
    private String draftDetails;
    private Date draftDate;
    private String draftStatus;
    private Date draftFinalApprove;
    private Reject DraftReject;
    private Documents document;
    private String memberName;
    private String draftMember2;
    private String draftMember3;
    private String attachmentUuidName;

    public DraftDTO(Long draftId, String draftTitle, String memberName, String attachmentUuidName, Date draftDate) {
        this.draftId = draftId;
        this.draftTitle = draftTitle;
        this.draftDate = draftDate;
        this.memberName = memberName;
        this.attachmentUuidName = attachmentUuidName;
    }
}


