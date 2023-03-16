package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_pw")
    private String memberPw;

    @Column(name = "member_address")
    private String memberAddress;

    @Column(name = "member_gender")
    private String memberGender;

    @Column(name = "member_reg_no")
    private String memberRegNo;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_introduction")
    private String memberIntroduction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_num")
    private Authority authority;
}
