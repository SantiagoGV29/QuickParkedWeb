package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Typevehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITypeVehicleService {
    Typevehicle insertType(Typevehicle type);
    Boolean deleteType(Long id);

    List <Typevehicle> getTypeVehicles ();
}
