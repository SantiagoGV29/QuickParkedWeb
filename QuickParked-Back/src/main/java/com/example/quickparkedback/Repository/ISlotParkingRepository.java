package com.example.quickparkedback.Repository;

import com.example.quickparkedback.Model.Slotparking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISlotParkingRepository extends JpaRepository<Slotparking,Integer> {
}
