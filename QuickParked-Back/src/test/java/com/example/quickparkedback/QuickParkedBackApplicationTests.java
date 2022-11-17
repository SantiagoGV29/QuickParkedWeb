package com.example.quickparkedback;

import com.example.quickparkedback.Controller.RestControllerVehicle;
import com.example.quickparkedback.Model.Slotparking;
import com.example.quickparkedback.Model.Typevehicle;
import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Service.ISlotParkingService;
import com.example.quickparkedback.Service.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(RestControllerVehicle.class)
class QuickParkedBackApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Qualifier("vehicleServiceImp")
    @MockBean
    private IVehicleService vehicleService;

    @Qualifier("slotParkingServiceImp")
    @MockBean
    private ISlotParkingService slotParkingService;

    @Test
    void testListVehicles() throws Exception {
        String url = "/parking/vehicles";
        List <Vehicle> listVehicles = new ArrayList<>();
        listVehicles.add(new Vehicle(1L, "ABC222", new Slotparking(1L, new Date()), new Typevehicle(1L, "Automovil", 40)));
        listVehicles.add(new Vehicle(2L, "ABC221", new Slotparking(2L, new Date()), new Typevehicle(2L, "Moto", 50)));
        listVehicles.add(new Vehicle(3L, "ABC223", new Slotparking(3L, new Date()), new Typevehicle(3L, "Furgon", 120)));
        listVehicles.add(new Vehicle(4L, "ABC224", new Slotparking(4L, new Date()), new Typevehicle(4L, "Furgon", 120)));
        Mockito.when(this.vehicleService.getVehicles()).thenReturn(listVehicles);

        MvcResult mvsResult = mockMvc.perform(MockMvcRequestBuilders.get(url)).andExpect(status().isOk()).andReturn();
        String acualJson = mvsResult.getResponse().getContentAsString();
        System.out.println(acualJson);

        String expectedJson = objectMapper.writeValueAsString(listVehicles);

        assertThat(acualJson).isEqualToIgnoringWhitespace(expectedJson);


    }

}