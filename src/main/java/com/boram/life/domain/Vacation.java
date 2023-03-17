package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter @Setter
public class Vacation {

    // 휴가 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "vacation_no")
    private Long vacationNo;

    // 휴가자 (회원)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member vacationMember;

    // 휴가기준
    @ManyToOne
    @JoinColumn(name = "vacation_criteria_no")
    private VacationCriteria vacationCriteria;

    // 사용한 휴가일 (일수)
    @Column(name = "vacation_use_date")
    private Long vacationUseDate;

    // 휴가 시작일자
    @Column(name = "vacation_start_date")
    private Date vacationStartDate;

    // 휴가 종료일자
    @Column(name = "vacation_end_date")
    private Date vacationEndDate;



}
