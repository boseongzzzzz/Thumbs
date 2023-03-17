package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class GradeAndRankVariance {

    /* 계급(Grade) 과 호봉(Rank) 변동(Variance)
       계급(Grade) 과 호봉(Rank) 은 '진급(Promotion)'명령(문서)에 의해 상승하고, '징계(Punishment)' 명령(문서)에 의해 하락함.
       두가지 모두를 반영하기 위해 Entity 수정
     */

    // 변동 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "variance_no")
    private Long varianceNo;

    // 변동 대상자 (회원)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member varianceMember;

    // 변동 계급(Grade)
    // 1. 진급 명령 시 상승함
    // 2. 강등 징계 시 하락함
    @Column(name = "variance_grade")
    private Long varianceGrade;

    // 변동 호봉(Rank)
    // 1. 매년 1월 1일 당해년도 징계자 제외, 모든 사원 상승함
    // 2. 감봉 징계 시 하락함
    @Column(name = "variance_rank")
    private Long varianceRank;

    // 진급 기준 : 진급 시만 해당
    @ManyToOne
    @JoinColumn(name = "promotion_criteria_no")
    private PromotionCriteria promotionCriteria;

    // 변동 일자
    @Column(name = "variance_date")
    private Date  varianceDate;

    // 변동 근거 (= 진급 명령 문서)
    @ManyToOne
    @JoinColumn(name = "document_no")
    private Documents document;

}
