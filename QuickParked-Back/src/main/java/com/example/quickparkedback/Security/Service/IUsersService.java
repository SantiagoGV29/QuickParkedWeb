package com.example.quickparkedback.Security.Service;

import com.example.quickparkedback.Security.Model.authorities;
import com.example.quickparkedback.Security.Model.users;
import org.springframework.stereotype.Service;

@Service
public interface IUsersService {
    users addUser (users us);
}
