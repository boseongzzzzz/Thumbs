package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Documents {
    @Id @GeneratedValue
    @Column(name = "documents_id")
    private Long documentsId;

    @Column(name = "documents_name")
    private String documentsName;

    @Column(name = "documents_type")
    private String documentsType;
}
