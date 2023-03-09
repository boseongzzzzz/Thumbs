package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Violation {
    @Id @GeneratedValue
    @Column(name = "violation_id")
    private Long ViolationId;
    @Column(name = "violation_type")
    private Long ViolationType;
}
