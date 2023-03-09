package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class VacationHistory {
    @Id @GeneratedValue
    @Column(name = "Vacation_history_id")
    private Long vacationHistoryId;
    @Column(name = "Vacation_history_use_date")
    private Long vacationHistoryUseDate;
    @Column(name = "Vacation_history_start_date")
    private Long vacationHistoryStartDate;
    @Column(name = "Vacation_history_end_date")
    private Long vacationHistoryEndDate;
    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

}
