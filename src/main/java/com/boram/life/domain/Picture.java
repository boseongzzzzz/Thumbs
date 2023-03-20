package com.boram.life.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="picture")
public class Picture {


    // 사진 번호 (SEQ)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_no")
    private Long pictureNo;

    // 사진 본명
    @Column(name = "picture_origin_name")
    private String pictureOriginName;

    // 사진 UUID명
    @Column(name = "picture_uuid_name")
    private String pictureUuidName;

    // 사진 저장경로
    @Column(name = "picture_save_path")
    private String pictureSavePath;

    // 사진 유효(=삭제되지 않음) 여부
    @Column(name = "picture_is_valid")
    private boolean isValid;

    // 사진이 딸린 회원
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member pictureMember;

}
