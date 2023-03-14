package com.boram.life.draft.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentsDTO {

    private Long attachmentId;

    private String attachmentOriginName;

    private String attachmentUuidName;

    private String attachmentSavePath;
}
