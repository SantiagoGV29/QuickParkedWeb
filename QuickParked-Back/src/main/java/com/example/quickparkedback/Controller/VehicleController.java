package com.example.quickparkedback.Controller;

import com.example.quickparkedback.Model.Enums.TypeCar;
import com.example.quickparkedback.Model.Slotparking;
import com.example.quickparkedback.Model.Typevehicle;
import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Service.ISlotParkingService;
import com.example.quickparkedback.Service.ITypeVehicleService;
import com.example.quickparkedback.Service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/parking")
public class VehicleController {
    @Qualifier("vehicleServiceImp")
    @Autowired
    private IVehicleService vehicleService;

    @Qualifier("typeVehicleImpService")
    @Autowired
    private ITypeVehicleService typeVehicleService;
    @Qualifier("slotParkingImpService")
    @Autowired
    private ISlotParkingService slotParkingService;

    @GetMapping("/vehicles")
    public ArrayList<Vehicle> GetVehicles() {
       return (ArrayList<Vehicle>) this.vehicleService.getVehicles();
    }

    @RequestMapping(value = "/vehicle/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public Vehicle GetVehicleByplate(@PathVariable("id") Integer id) {
        return this.vehicleService.getVehiclebyId(id);
    }

    @RequestMapping(value = "/insert",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"}
    )
    public Vehicle InsertVehicle(@RequestBody Vehicle vehicle) {
        this.slotParkingService.insertSlot(vehicle.getSlotparking());
        return this.vehicleService.insertVehicle(vehicle);
    }

    @DeleteMapping("/Delete/{id}")
    public Boolean PayVehicle(@PathVariable("id") Integer id){
        return this.vehicleService.delete(id);
    }
}
