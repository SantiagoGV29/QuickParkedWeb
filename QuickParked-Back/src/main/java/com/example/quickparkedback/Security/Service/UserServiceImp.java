package com.example.quickparkedback.Security.Service;

import com.example.quickparkedback.Security.Model.UserParking;
import com.example.quickparkedback.Security.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<UserParking> existUserParking(String userName) {
        return userRepository.findByUserName(userName);
    }
}
