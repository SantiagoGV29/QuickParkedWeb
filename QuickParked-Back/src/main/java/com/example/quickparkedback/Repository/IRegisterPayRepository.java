package com.example.quickparkedback.Repository;

import com.example.quickparkedback.Model.Registerpay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterPayRepository extends JpaRepository<Registerpay,Long> {
}
