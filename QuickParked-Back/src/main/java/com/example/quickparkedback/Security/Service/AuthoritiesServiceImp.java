package com.example.quickparkedback.Security.Service;

import com.example.quickparkedback.Security.Model.authorities;
import com.example.quickparkedback.Security.Repository.IAuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesServiceImp implements IAuthoritiesService{
    @Autowired
    private IAuthoritiesRepository authoritiesRepository;

    @Override
    public authorities addAuthorities(authorities auth) {
        return authoritiesRepository.save(auth);
    }
}
