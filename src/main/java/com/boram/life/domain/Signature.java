package com.boram.life.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Signature {


    // 서명 번호 (SEQ)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "signature_no")
    private Long signatureNo;

    // 서명 본명
    @Column(name = "signature_origin_name")
    private String signatureOriginName;

    // 서명 UUID명
    @Column(name = "signature_uuid_name")
    private String signatureUuidName;

    // 서명 저장경로
    @Column(name = "signature_save_path")
    private String signatureSavePath;

    // 서명 유효(=삭제되지 않음) 여부
    @Column(name = "signature_is_valid")
    private boolean isValid;

    // 서명이 딸린 회원
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member signatureMember;

}
