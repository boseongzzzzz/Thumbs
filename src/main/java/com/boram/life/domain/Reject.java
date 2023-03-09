package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Reject {
    @Id @GeneratedValue
    @Column(name = "reject_id")
    private Long rejectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member rejectMember;

    @Column(name = "reject_details")
    private String rejectDetails;

    @OneToOne(mappedBy = "DraftReject")
    private Draft rejectDraft;
}
