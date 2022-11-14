package com.example.quickparkedback.Controller;

import com.example.quickparkedback.Model.Registerpay;
import com.example.quickparkedback.Model.Typevehicle;
import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Service.IRegisterPayService;
import com.example.quickparkedback.Service.ISlotParkingService;
import com.example.quickparkedback.Service.ITypeVehicleService;
import com.example.quickparkedback.Service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/parking")
public class RestControllerVehicle {
    @Qualifier("vehicleServiceImp")
    @Autowired
    private IVehicleService vehicleService;
    @Qualifier("typeVehicleServiceImp")
    @Autowired
    private ITypeVehicleService typeVehicleService;
    @Qualifier("slotParkingServiceImp")
    @Autowired
    private ISlotParkingService slotParkingService;

    @Qualifier("registerPayServiceImp")
    @Autowired
    private IRegisterPayService registerPayService;

    @GetMapping("/TypeVehicles")
    public ArrayList<Typevehicle> getTypeVehicles (){
        return (ArrayList<Typevehicle>) this.typeVehicleService.getTypeVehicles();
    }

    @GetMapping("/vehicles")
    public ArrayList<Vehicle> GetVehicles() {
       return (ArrayList<Vehicle>) this.vehicleService.getVehicles();
    }

    @RequestMapping(value = "/vehicle/{plate}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public Vehicle GetVehicleByplate(@PathVariable("plate") String plate) {
        return this.vehicleService.getVehiclebyPlate(plate);
    }

    @RequestMapping(value = "/insert",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Vehicle InsertVehicle(@RequestBody Vehicle vehicle) {
        this.slotParkingService.insertSlot(vehicle.getSlotparking());
        return this.vehicleService.insertVehicle(vehicle);
    }


    @RequestMapping(value = "/pay/{plate}/{value}/{service}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Double PayVehicle(@PathVariable("plate") String plate, @PathVariable("service") Double valueService, @PathVariable("value") Double value){
        Vehicle vehicle = this.vehicleService.getVehiclebyPlate(plate);
        Double change = valueService - value;
        Registerpay registerPay = new Registerpay(null, plate, change);
        this.registerPayService.insertRegister(registerPay);
        this.vehicleService.delete(vehicle.getId());
        this.slotParkingService.DeleteSlot(vehicle.getSlotparking().getId());
        return change;
    }

    @GetMapping("/pay/{plate}")
    public Double getPrice (@PathVariable("plate") String plate) throws ParseException {
        Vehicle veh = this.vehicleService.getVehiclebyPlate(plate);
        Calendar date =  Calendar.getInstance();
        assert veh != null;
        Calendar checkIn = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String checkOutString = sdf.format(date.getTime());
        Calendar checkOut = Calendar.getInstance();
        checkOut.setTime(sdf.parse(checkOutString));
        checkIn.setTime(sdf.parse(veh.getSlotparking().getCheckin()));
        long checkInMillis =  checkIn.getTimeInMillis()/60000;
        long checkOutMillis =  checkOut.getTimeInMillis()/60000;
        long minutes = (checkOutMillis - checkInMillis);
        return (double) (minutes * veh.getTypevehicle().getRate());
    }

    @RequestMapping(value = "/modify/{plate}",
            method = RequestMethod.PUT ,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Boolean modify(@PathVariable("plate") String plate, @RequestBody Vehicle vehicle) {
        Vehicle v = this.vehicleService.getVehiclebyPlate(plate);
        //Aqui se busca con la placa no actualizada el vehículo.
        //Luego se actualiza con los nuevos valores.
        v.setLicenceplate(vehicle.getLicenceplate());
        v.setTypevehicle(vehicle.getTypevehicle());
        this.vehicleService.update(v);
        //this.slotParkingService.insertSlot(vehicle.getSlotparking());
        return true;
    }

}
