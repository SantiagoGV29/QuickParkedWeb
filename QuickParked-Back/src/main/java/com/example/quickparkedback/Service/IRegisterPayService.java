package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Registerpay;
import org.springframework.stereotype.Service;

@Service
public interface IRegisterPayService {
    Registerpay insertRegister (Registerpay registerPay);
}
