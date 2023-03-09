package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Position {
    @Id @GeneratedValue
    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "position_date")
    private Date positionDate;
    @Column(name = "position_expired_date")
    private Date positionExpiredDate;
    @Column(name = "position_rank")
    private String positionRank;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member positionMember;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department positionDepartment;
}
