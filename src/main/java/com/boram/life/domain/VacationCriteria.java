package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name="vacation_criteria")
public class VacationCriteria {

    // 휴가기준 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "vacation_criteria_no")
    private Long vacationCriteriaNo;

    // 휴가기준 계급
    @Column(name = "vacation_by_grade")
    private Long vacationByGrade;

    // 휴가기준 계급별 일수
    @Column(name = "vacation_day")
    private Long vacationDate;

}
