package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVehicleService {

    Vehicle insertVehicle(Vehicle vehicle);
    List<Vehicle> getVehicles();
    Vehicle getVehiclebyPlate(String plate);
    void delete(Long id);

    void update(Vehicle v);
    //Boolean updateVehicle(Vehicle vehicle);

}
