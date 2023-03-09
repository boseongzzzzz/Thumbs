package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter @Setter
public class Vacation {
    @Id @GeneratedValue
    @Column(name = "vacation_id")
    private Long vacationId;
    @Column(name = "vacation_standard")
    private String vacationStandard;
    @Column(name = "vacation_Date")
    private Date vacationDate;

}
