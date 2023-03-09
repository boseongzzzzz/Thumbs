package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
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
}
