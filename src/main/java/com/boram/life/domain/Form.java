package com.boram.life.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Form {

    // 문서형식 번호
    @Id @GeneratedValue
    @Column(name = "form_no")
    private Long formNo;

    // 문서형식 이름
    @Column(name = "form_name")
    private String formName;

    // 상위(참조) 문서형식 (: null일 시 스스로 상위문서가 되고, 숫자가 들어오면 해당 숫자를 formNo로 가지는 부서의 하위문서로 편성됨)
    // * '징계'폼을 위해 존재하는 컬럼이고, 징계의 하위형식인 '견책', '강등', '감봉', '해임'을 설정하기 위함임.
    @Column(name = "form_reference")
    private String formRef;
}
