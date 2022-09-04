package com.example.quickparkedback.Repository;

import com.example.quickparkedback.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Vehicle,String> {

}
