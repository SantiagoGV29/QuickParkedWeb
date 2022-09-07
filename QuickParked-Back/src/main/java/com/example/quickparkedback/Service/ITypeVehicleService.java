package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Typevehicle;
import org.springframework.stereotype.Service;

@Service
public interface ITypeVehicleService {
    Typevehicle insertType(Typevehicle type);
    Boolean deleteType(Integer id);
}
