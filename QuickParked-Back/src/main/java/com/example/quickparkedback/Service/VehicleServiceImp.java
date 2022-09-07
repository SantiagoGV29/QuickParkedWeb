package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Vehicle getVehiclebyId(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Long id) {
        try {
            Vehicle dot = vehicleRepository.findById(id).orElse(null);
            Date checkin = dot.getSlotparking().getCheckin();
            Date checkout = new Date();
            long diff =  checkout.getTime() - checkin.getTime();
            TimeUnit tm = TimeUnit.MINUTES;
            diff = tm.convert(diff,TimeUnit.MILLISECONDS);
            Double precio = (double) (diff * dot.getTypevehicle().getRate());
            vehicleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
