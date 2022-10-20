package com.example.quickparkedback.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Registerpay {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String vehicleplate;
    private Double price;
}
