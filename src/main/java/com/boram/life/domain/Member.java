package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long MemberId;
    @Column(name = "member_pw")
    private String MemberPw;
    @Column(name = "member_address")
    private String MemberAddress;
    @Column(name = "member_gender")
    private String MemberGender;
    @Column(name = "member_reg_no")
    private String MemberRegNo;
    @Column(name = "member_email")
    private String MemberEmail;
    @Column(name = "member_name")
    private String MemberName;
    @Column(name = "member_introduction")
    private String MemberIntroduction;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_num")
    private Authority authority;
}
