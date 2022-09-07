package com.example.quickparkedback.Repository;

import com.example.quickparkedback.Model.Typevehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeVehicleRepository extends JpaRepository<Typevehicle,Integer> {
}
