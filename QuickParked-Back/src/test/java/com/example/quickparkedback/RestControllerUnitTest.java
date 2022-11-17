package com.example.quickparkedback;

import com.example.quickparkedback.Model.Slotparking;
import com.example.quickparkedback.Model.Typevehicle;
import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Service.IRegisterPayService;
import com.example.quickparkedback.Service.ISlotParkingService;
import com.example.quickparkedback.Service.ITypeVehicleService;
import com.example.quickparkedback.Service.IVehicleService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class RestControllerUnitTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;

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

    @BeforeEach
    void init() throws Exception {
        String url = "/parking/vehicles";

       vehicleService.insertVehicle(new Vehicle(1L, "ABC222", new Slotparking(1L, new Date()), new Typevehicle(1L, "Automovil", 40)));
       vehicleService.insertVehicle(new Vehicle(2L, "RNS764", new Slotparking(2L, new Date()), new Typevehicle(2L, "Automovil", 40)));
    }

    @Test
    void traer() throws Exception {
        MockHttpServletRequestBuilder request = post("/parking/vehicles").contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        assertEquals("200", result.getResponse().getStatus());
    }






}
