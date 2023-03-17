package com.boram.life.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Attachments {


    // 첨부파일 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "attachment_no")
    private Long attachmentNo;

    // 첨부파일 본명
    @Column(name = "attachment_origin_name")
    private String attachmentOriginName;

    // 첨부파일 UUID명
    @Column(name = "attachment_uuid_name")
    private String attachmentUuidName;

    // 첨부파일 저장경로
    @Column(name = "attachment_save_path")
    private String attachmentSavePath;

    // 첨부파일이 딸린 문서
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_no")
    private Documents documentAttached;

}
