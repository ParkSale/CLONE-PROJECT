package com.selldok.toy.company.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
/**
 * @author Gogisung
 */
@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 임베디드 타입 포함
    private Address address;

    private String email;
    private String myPhone;

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private Company company;

    @Enumerated(EnumType.STRING)
    private MemberStatus status; // member의 상태 : 일반 or 회사마스터 Normal, Master

}
