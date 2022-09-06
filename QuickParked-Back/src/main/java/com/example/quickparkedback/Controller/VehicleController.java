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
    @Autowired
    private ITypeVehicleService typeVehicleService;
    @Autowired
    private ISlotParkingService slotParkingService;

    ArrayList<Vehicle> arr = new ArrayList<>();
    public VehicleController() {
        Slotparking slot = new Slotparking(1, "hola");
        Typevehicle type = new Typevehicle(1, TypeCar.Automovil);
        Vehicle ve = new Vehicle(1,"ABC345",slot,type);
        arr.add(ve);
    }

    @GetMapping("/Vehicles")
    public ArrayList<Vehicle> GetVehicles() {
        return arr;
       // return (ArrayList<Vehicle>) this.vehicleService.getVehicles();
    }

    @RequestMapping(value = "/Vehicle/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public Vehicle GetVehicleByplate(@PathVariable("id") Integer id) {
        return this.vehicleService.getVehiclebyId(id);
    }

    @RequestMapping(value = "/Insert",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"}
    )
    public Vehicle InsertVehicle(@RequestBody Vehicle vehicle) {
        this.slotParkingService.insertSlot(vehicle.getSlotparking());
        this.typeVehicleService.insertType(vehicle.getTypevehicle());
        return this.vehicleService.insertVehicle(vehicle);
    }

    @DeleteMapping("/Delete/{id}")
    public Boolean PayVehicle(@PathVariable("id") Integer id){
        return this.vehicleService.delete(id);
    }
}
