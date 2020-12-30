package com.selldok.toy.salary.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Salary {

    @Id
    private Long id;

    private Occupation occupation;

    @Embedded
    private SalaryInfo salaryInfo;

}
