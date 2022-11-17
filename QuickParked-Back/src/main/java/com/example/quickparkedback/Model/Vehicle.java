package com.example.quickparkedback.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String licenceplate;
    @OneToOne
    @JoinColumn(name = "Slotparkingid")
    private Slotparking slotparking;
    @OneToOne
    @JoinColumn(name = "Typevehicleid")
    private Typevehicle typevehicle;

    public Vehicle(String plate, Slotparking slotparking, Typevehicle typevehicle) {
        this.licenceplate=plate;
        this.slotparking = slotparking;
        this.typevehicle=typevehicle;
    }
}
