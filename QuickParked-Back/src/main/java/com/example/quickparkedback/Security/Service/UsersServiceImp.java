package com.example.quickparkedback.Security.Service;

import com.example.quickparkedback.Security.Model.users;
import com.example.quickparkedback.Security.Repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImp implements IUsersService{
    @Autowired
    private IUsersRepository usersRepository;

    @Override
    public users addUser(users us) {
        return usersRepository.save(us);
    }
}
