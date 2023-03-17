package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Reject {

    // 반려 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "reject_no")
    private Long rejectNo;

    // 반려자 (= 문서를 반려한 회원)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member rejectMember;

    // 반려 대상 문서
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_no")
    private Documents rejectDocument;

    // 반려 상세 (내용)
    @Column(name = "reject_details")
    private String rejectDetails;

}
