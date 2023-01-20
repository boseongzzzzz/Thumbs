package com.boram.life.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private int emp_num;
    private String emp_pwd;
    private String emp_name;

}
