package com.ozansaribal.n11bootcamp.graduation_project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Member implements BaseEntity {


    @SequenceGenerator(name="generator", sequenceName = "member_id_seq")
    @Id
    @GeneratedValue(generator = "generator",strategy = GenerationType.SEQUENCE)
    private Long id;

    private String personalNumber;
    private String firstName;
    private String lastName;
    private Double monthlyIncome;
    private String telephoneNumber;

    private LocalDate birthDate;

    private Double depositAmount;
    private Double creditScore;

}