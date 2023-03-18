package com.boram.life.admin.dto;

import com.boram.life.domain.Authority;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EssentialMemberInfoDTO {

    private Long memberNo;

    private Long memberId;

    private String memberPw;

    private String memberName;

    private String memberGender;

    private String memberRegNo;

    private Authority authority;

    private Long memberStatus;

    private Date joinDate;

    private Date resignDate;

}
