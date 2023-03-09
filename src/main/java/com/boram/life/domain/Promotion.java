package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Promotion {
    @Id @GeneratedValue
    @Column(name = "promotion_id")
    private Long promotionId;
    @Column(name = "promotion_position")
    private String promotionPosition;
    @Column(name = "promotion_standard")
    private String promotionStandard;
}
