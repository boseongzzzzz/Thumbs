package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Punishment {
    @Id @GeneratedValue
    @Column(name = "punishment_id")
    private Long punishmentId;
    @Column(name = "punishment_type")
    private Long punishmentType;
}
