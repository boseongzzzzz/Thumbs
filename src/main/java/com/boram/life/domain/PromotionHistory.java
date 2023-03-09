package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class PromotionHistory {
    @Id @GeneratedValue
    @Column(name = "promotion_history_id")
    private Long  promotionHistoryId;
    @Column(name = "promotion_history_date")
    private Date  promotionHistoryDate;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;
    @ManyToOne
    @JoinColumn(name = "draft_id")
    private Draft draft;
}
