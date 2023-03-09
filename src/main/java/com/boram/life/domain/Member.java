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
    private String pw;
    @Column(name = "member_address")
    private String address;
    @Column(name = "member_gender")
    private String gender;
    @Column(name = "member_reg_no")
    private String regNo;
    @Column(name = "member_email")
    private String email;
    @Column(name = "member_name")
    private String name;
    @Column(name = "member_introduction")
    private String introduction;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_num")
    private Authority authority;
}
