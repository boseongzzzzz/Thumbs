package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter
public class Member {

    /* 회원가입 및 로그인 정보 */

    // 회원 번호 (SEQ), 회원 DB상 입력순번
    @GeneratedValue
    @Column(name = "member_no")
    private Long memberNo;

    // 회원 아이디 (사번으로 부여된 아이디, 사번을 SEQ로 할 수 없어서 새로 만듦)
    @Id
    @Column(name = "member_id")
    private Long memberId;

    // 회원 비밀번호
    @Column(name = "member_pw")
    private String memberPw;



    /* 필수 기본정보, 관리자가 관리자 페이지에서 수정해야 하는 정보 */

    // 회원 이름 : 개명 시, 관리자가 관리자 페이지에서 수정
    @Column(name = "member_name")
    private String memberName;

    // 회원 성별 : 성전환 시, 관리자가 관리자 페이지에서 수정
    @Column(name = "member_gender")
    private String memberGender;

    // 회원 주민등록번호
    @Column(name = "member_reg_no")
    private String memberRegNo;

    // 회원 권한 : 권한 변경 시, 관리자가 관리자 페이지에서 수정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_num")
    private Authority authority;



    /* 부가 정보, 개별 회원이 마이페이지에서 수정 가능한 정보 */

    // 회원 이메일
    @Column(name = "member_email")
    private String memberEmail;

    // 회원 주소
    @Column(name = "member_address")
    private String memberAddress;

    // 회원 소개
    @Column(name = "member_introduction")
    private String memberIntroduction;

}
