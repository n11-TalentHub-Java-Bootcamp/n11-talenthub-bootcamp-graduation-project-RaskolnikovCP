package com.ozansaribal.n11bootcamp.graduation_project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ozansaribal.n11bootcamp.graduation_project.Enums.EnumCreditResultType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CREDIT_APPLICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class CreditApplication implements BaseEntity {


    @SequenceGenerator(name="generator", sequenceName = "application_id_seq")
    @Id
    @GeneratedValue(generator = "generator",strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double creditLimit;

    private String telephoneNumber;

    private EnumCreditResultType creditResultType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_MEMBER", foreignKey = @ForeignKey(name = "FK_CREDIT_APPLICATION_MEMBER_ID"))
    private Member member;



}
