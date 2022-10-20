package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class VehicleServiceImp implements IVehicleService {
    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public Vehicle insertVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehiclebyPlate(String plate) {
        return vehicleRepository.findByLicenceplate(plate);
    }

    @Override
    public void delete(Long id) {
        this.vehicleRepository.deleteById(id);
    }
}
