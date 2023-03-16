package com.boram.life.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Attachments {
    @Id @GeneratedValue
    @Column(name = "attachment_id")
    private Long attachmentId;
    @Column(name = "attachment_origin_name")
    private String attachmentOriginName;
    @Column(name = "attachment_uuid_name")
    private String attachmentUuidName;
    @Column(name = "attachment_save_path")
    private String attachmentSavePath;
//    @ManyToOne
//    @JoinColumn(name = "draft_id")
//    private Draft draft;

//    public Attachments(String attachmentUuidName) {
//        this.attachmentUuidName = attachmentUuidName;
//    }
}
