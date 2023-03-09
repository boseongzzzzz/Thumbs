package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class ViolationHistory {
    @Id @GeneratedValue
    @Column(name = "violation_history_id")
    private Long  violationHistoryId;
    @Column(name = "violation_history_date")
    private Date violationHistoryDate;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "violation_id")
    private Violation violation;
    @ManyToOne
    @JoinColumn(name = "draft_id")
    private Draft draft;
}
