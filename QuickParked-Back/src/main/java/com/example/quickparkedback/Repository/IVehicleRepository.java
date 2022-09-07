package com.example.quickparkedback.Repository;

import com.example.quickparkedback.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository extends JpaRepository <Vehicle,Long> {
    Vehicle findByLicenceplate (String licencePlate);
}
