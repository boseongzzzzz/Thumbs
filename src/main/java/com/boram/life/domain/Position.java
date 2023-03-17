package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Position {

    // 배정 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "position_no")
    private Long positionNo;

    // 배정 대상자 (회원)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member positionMember;

    // 배정 부서
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department positionDepartment;

    // 배정 직책
    @Column(name = "position_duty")
    private String positionDuty;

    // 배정 (시작) 일자
    @Column(name = "position_deploy_date")
    private Date positionDeployDate;

    // 배정 종료 일자
    // 1. 일반적으로 다음 배정(보직) 명령 시, 다음 배정 일자의 전날이 배정 종료일이 됨
    // 2. '해임' 혹은 '파면' 징계 시, 다음 배정일 없이 징계 일자 부로 배정 종료됨
    @Column(name = "position_expire_date")
    private Date positionExpireDate;

    // 배정 근거 (= 배정 명령 문서)
    @ManyToOne
    @JoinColumn(name = "document_no")
    private Documents document;


}
