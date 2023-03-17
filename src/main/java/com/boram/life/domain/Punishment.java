package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Punishment {

    // 징계 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "punishment_no")
    private Long  punishmentNo;

    // 징계 종류
    @ManyToOne
    @JoinColumn(name = "punishment_type_no")
    private PunishmentType punishmentType;

    // 징계 대상자 (회원)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member punishmentMember;

    // 징계 일자
    @Column(name = "punishment_date")
    private Date punishmentDate;

    // 징계 근거 (= 징계 명령 문서)
    @ManyToOne
    @JoinColumn(name = "document_no")
    private Documents document;

}
