package com.boram.life.aprvlDocuments.dto;

import com.boram.life.domain.Documents;
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

    private Documents attachedToDocument;
}
