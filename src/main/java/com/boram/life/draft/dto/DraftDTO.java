package com.boram.life.draft.dto;

import com.boram.life.domain.Draft;
import lombok.*;

import java.util.Date;

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
    private String draftReject;
    private String document;
    private String draftMember1;
    private String draftMember2;
    private String draftMember3;
    private AttachmentsDTO attachments;

}
