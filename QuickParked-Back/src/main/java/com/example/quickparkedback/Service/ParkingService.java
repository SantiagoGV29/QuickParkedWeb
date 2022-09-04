package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Repository.ParkingRepository;
import org.apache.catalina.startup.ClassLoaderFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class ParkingService {
    private ParkingRepository parkingRepository;
        public ArrayList<Vehicle> GetVehicles(){
            return (ArrayList<Vehicle>) parkingRepository.findAll();
        }
        public Vehicle GetVehicleByplate(String plate){
            return parkingRepository.findById(plate).orElse(null);
        }
        public Vehicle InsertVehicle(Vehicle vehicle){
            return parkingRepository.save(vehicle);
        }
        public Boolean MakePayment(String plate){
            try {
                parkingRepository.deleteById(plate);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
}
