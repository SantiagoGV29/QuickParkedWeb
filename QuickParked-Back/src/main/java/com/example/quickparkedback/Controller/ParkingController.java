package com.example.quickparkedback.Controller;

import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ParkingController {
    @Autowired
    private final ParkingService parkingService;

    // Constructor
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/Parking/Vehicles")
    public ArrayList<Vehicle> GetVehicles() {
        return this.parkingService.GetVehicles();
    }

    @RequestMapping(value = "/Parking/Vehicle/{plate}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public Vehicle GetVehicleByplate(@PathVariable("plate") String plate) {
        return this.parkingService.GetVehicleByplate(plate);
    }

    @RequestMapping(value = "/Parking/Insert",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"}
    )
    public Vehicle InsertVehicle(@RequestBody Vehicle vehicle) {
        return this.parkingService.InsertVehicle(vehicle);
    }

    @DeleteMapping("/Parking/Delete/{plate}")
    public Boolean PayVehicle(@PathVariable("plate") String plate){
        return this.parkingService.MakePayment(plate);
    }
}
