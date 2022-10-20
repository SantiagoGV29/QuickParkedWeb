package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Registerpay;
import com.example.quickparkedback.Repository.IRegisterPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterPayServiceImp implements IRegisterPayService{
    @Autowired
    private IRegisterPayRepository registerPayRepository;
    @Override
    public Registerpay insertRegister(Registerpay registerPay) {
        return registerPayRepository.save(registerPay);
    }
}
