package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "authority")
public class Authority {

    // 권한 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "auth_no")
    private Long authNo;

    // 권한 이름
    @Column(name = "auth_name")
    private String authName;

    // 권한 내용(어떤 권한인지 묘사)
    @Column(name = "auth_content")
    private String authContent;
}
