package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class PunishmentHistory {
    @Id @GeneratedValue
    @Column(name = "punishment_history_id")
    private Long  punishmentHistoryId;
    @Column(name = "punishment_history_date")
    private Date punishmentHistoryDate;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "punishment_id")
    private Punishment punishment;
    @ManyToOne
    @JoinColumn(name = "draft_id")
    private Draft draft;
}
