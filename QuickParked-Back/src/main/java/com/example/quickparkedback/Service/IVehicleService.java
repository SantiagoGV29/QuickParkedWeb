package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVehicleService {

    Vehicle insertVehicle(Vehicle vehicle);
    List<Vehicle> getVehicles();
    Vehicle getVehiclebyId(Integer id);
    Boolean delete(Integer id);

}
