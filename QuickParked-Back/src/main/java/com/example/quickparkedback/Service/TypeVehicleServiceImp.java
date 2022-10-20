package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Typevehicle;
import com.example.quickparkedback.Repository.ITypeVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeVehicleServiceImp implements ITypeVehicleService {
    @Autowired
    private ITypeVehicleRepository iTypeVehicleRepository;

    @Override
    public Typevehicle insertType(Typevehicle type) {
        return iTypeVehicleRepository.save(type);
    }

    @Override
    public Boolean deleteType(Long id) {
        try{
            iTypeVehicleRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Typevehicle> getTypeVehicles() {
        return iTypeVehicleRepository.findAll();
    }
}
