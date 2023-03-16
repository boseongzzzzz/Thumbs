package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter

public class Draft {
    @Id @GeneratedValue
    @Column(name = "draft_id")
    private Long draftId;
    @Column(name = "draft_title")
    private String draftTitle;
    @Column(name = "draft_details")
    private String draftDetails;
    @Column(name = "draft_date")
    private Date draftDate;
    @Column(name = "draft_status")
    private int draftStatus;
    @Column(name = "draft_final_approve")
    private Date draftFinalApprove;
    @OneToOne(fetch = FetchType.LAZY)
    private Reject DraftReject;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documents_id")
    private Documents document;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member draftMember1;
    @Column(name = "draft_Member2")
    private String draftMember2;
    @Column(name = "draft_member3")
    private String draftMember3;
    @OneToMany(mappedBy = "attachmentId")
    private List<Attachments> attachmentsList = new ArrayList<>();

    @Override
    public String toString() {
        return "Draft{" +
                "draftId=" + draftId +
                ", draftTitle='" + draftTitle + '\'' +
                ", draftDetails='" + draftDetails + '\'' +
                ", draftDate=" + draftDate +
                ", draftStatus=" + draftStatus +
                ", draftFinalApprove=" + draftFinalApprove +
                ", DraftReject=" + DraftReject +
                ", document=" + document +
                ", draftMember1=" + draftMember1 +
                ", draftMember2='" + draftMember2 + '\'' +
                ", draftMember3='" + draftMember3 + '\'' +
                '}';
    }
}
