package com.boram.life.gian.dto;

import com.boram.life.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GianDTO {

    private Long documentNo;

    private Form form;

    private Member approvalMember1;

    private String approvalMember2;

    private String approvalMember3;

    private String documentTitle;

    private String documentDetails;

    private String documentStatus;

    private Date documentDraftDate;

    private Date documentApprovalDate;

    private Reject documentReject;

    private String attachmentsUrl;


}

