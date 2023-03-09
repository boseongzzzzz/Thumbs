package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Board {
    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long boardId;
    @Column(name = "board_type")
    private int boardTitle;
    @Column(name = "board_body")
    private String boardBody;
    @Column(name = "board_count")
    private Long boardCount;
    @Column(name = "board_create_date")
    private Date boardCreateDate;
    @Column(name = "board_modified_date")
    private Date boardModifiedDate;
    @Column(name = "board_status")
    private String boardSatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToMany
    @JoinColumn(name = "attachment_id")
    private List<Attachments> attachments;
}
