package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="punishment_type")
public class PunishmentType {

    // 징계종류 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "punishment_type_no")
    private Long punishmentTypeNo;

    // 징계종류 이름
    @Column(name = "punishment_type_name")
    private Long punishmentTypeName;

}
