package com.boram.life.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    public Member(Long memberId, String memberPw){
        this.memberId = memberId;
        this.memberPw = memberPw;
    }
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

    // 회원 상태
    // 1:신규, 2:근무, 3:휴직(유급), 4:휴직(무급), 5:정직(봉급:2/3), 6:퇴사, 7:은퇴(정년)
    @Column(name = "member_status")
    private Long memberStatus;

    // 입사일 : 회사 밖에서 사람이 들어온 날 (회사 내부에서 사람이 도는 '배정'과는 별개)
    @Column(name = "join_date")
    private Date joinDate;

    // 퇴사일 : 회사 밖으로 사람이 나간 날  (정직, 휴직 등 회사 내부인인 상황이 유지되는 징계와는 별개)
    @Column(name = "resign_date")
    private Date resignDate;

    /* 추가 정보, 개별 회원이 마이페이지에서 수정 가능한 정보 */

    // 회원 사진
    @OneToOne(mappedBy = "pictureMember")
    private Picture memberPicture;

    // 회원 서명
    @OneToOne(mappedBy = "signatureMember")
    private Signature memberSignature;

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
