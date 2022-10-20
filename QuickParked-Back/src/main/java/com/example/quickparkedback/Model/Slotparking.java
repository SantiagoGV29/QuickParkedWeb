package com.example.quickparkedback.Model;

import lombok.*;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Slotparking {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String checkin;
}
