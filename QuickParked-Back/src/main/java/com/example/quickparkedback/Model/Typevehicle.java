package com.example.quickparkedback.Model;

import com.example.quickparkedback.Model.Enums.TypeCar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Typevehicle {
    @Id
    private Integer id;
    private String typevehicle;
    private Integer rate;
}
