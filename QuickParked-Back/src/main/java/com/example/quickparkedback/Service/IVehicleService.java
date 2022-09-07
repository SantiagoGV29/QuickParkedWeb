package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVehicleService {

    Vehicle insertVehicle(Vehicle vehicle);
    List<Vehicle> getVehicles();
    Vehicle getVehiclebyId(Long id);
    Boolean delete(Long id);

}
