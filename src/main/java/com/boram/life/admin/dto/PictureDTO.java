package com.boram.life.admin.dto;

import com.boram.life.domain.Member;
import com.boram.life.domain.Picture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PictureDTO {

    private Picture picture;

    private Member member;

    private String pictureUrl;

}
