package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="promotion_criteria")
public class PromotionCriteria {

    // 진급기준 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "promotion_criteria_no")
    private Long promotionCriteriaNo;

    // 진급기준 계급
    @Column(name = "promotion_grade")
    private Long promotionGrade;

    // 진급기준 계급 상세
    @Column(name = "promotion_grade_detail")
    private String promotionGradeDetail;

}
