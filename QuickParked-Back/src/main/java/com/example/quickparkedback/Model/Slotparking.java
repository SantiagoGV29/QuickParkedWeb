package com.example.quickparkedback.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slotparking {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private String checkin;
}
