package com.boram.life.admin.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdditionalMemberInfoDTO {

    private Long memberId;

    private String memberEmail;

    private String memberAddress;

    private String memberIntroduction;


}
