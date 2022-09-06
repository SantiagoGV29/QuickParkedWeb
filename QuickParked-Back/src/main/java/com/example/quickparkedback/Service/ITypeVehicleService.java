package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Typevehicle;

public interface ITypeVehicleService {
    Typevehicle insertType(Typevehicle type);
    Boolean deleteType(Integer id);
}
