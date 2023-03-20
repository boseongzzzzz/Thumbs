package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="department")
public class Department {

    // 부서 번호 (SEQ)
    @Id @GeneratedValue
    @Column(name = "dept_no")
    private Long deptNo;

    // 부서 이름
    @Column(name = "dept_name")
    private String deptName;

    // 상위(참조) 부서 (: null일 시 스스로 상위부서가 되고, 숫자가 들어오면 해당 숫자를 deptNo로 가지는 부서의 하위부서로 편성됨)
    @Column(name = "dept_reference")
    private Long deptRef;

}
