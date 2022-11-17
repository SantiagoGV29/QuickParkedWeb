package com.example.quickparkedback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.example.quickparkedback.Model.Slotparking;
import com.example.quickparkedback.Model.Typevehicle;
import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Service.IRegisterPayService;
import com.example.quickparkedback.Service.ISlotParkingService;
import com.example.quickparkedback.Service.ITypeVehicleService;
import com.example.quickparkedback.Service.IVehicleService;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;


import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestControllerVehicleIntegrationTest {

    @Qualifier("vehicleServiceImp")
    @Autowired
    private IVehicleService vehicleService;

    @Qualifier("slotParkingServiceImp")
    @Autowired
    private ISlotParkingService slotParkingService;


    private String AUTH="Basic am9objoxMjM0NQ==";
    private String tempToken;

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate rest;

    void init(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Slotparking slot = new Slotparking();
        slot.setCheckin(dtf.format(now));
        Typevehicle type = new Typevehicle(1L, "Automovil", 40);
        type.setTypevehicle("Automovil");
        type.setId(1L);
        type.setRate(40);
        Vehicle tesla= new Vehicle();
        tesla.setTypevehicle(type);
        tesla.setSlotparking(slot);
        tesla.setLicenceplate("PPP222");
        tesla.setId(50L);
        this.slotParkingService.insertSlot(tesla.getSlotparking());
        this.vehicleService.insertVehicle(tesla);
    }

    @Test
    @BeforeEach
    void getToken() throws URISyntaxException, ParseException {
        init();
        final String baseUrl = "http://localhost:"+port+"/parking/token";
        //
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",AUTH);//ADMIN
        //
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> result = this.rest.exchange(baseUrl, HttpMethod.GET, requestEntity, String.class);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(result.getBody());
        JSONObject json= (JSONObject)obj;
        String token=json.get("token").toString();
        tempToken="Bearer "+token;
        System.out.println("Token: {"+token+"}");
        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void getVehicles(){
        final String baseUrl = "http://localhost:"+port+"/parking/vehicles";
        //
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",tempToken);//ADMIN
        //
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> result = this.rest.exchange(baseUrl, HttpMethod.GET, requestEntity, String.class);
        System.out.println(result.getBody());
        assertEquals(200, result.getStatusCodeValue());
    }
}
