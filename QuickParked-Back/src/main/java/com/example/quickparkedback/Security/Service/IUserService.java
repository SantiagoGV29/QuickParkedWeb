package com.example.quickparkedback.Security.Service;

import com.example.quickparkedback.Security.Model.UserParking;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService {
    Optional <UserParking> existUserParking (String userName);
}
