package com.example.quickparkedback.Security.Repository;

import com.example.quickparkedback.Model.Vehicle;
import com.example.quickparkedback.Security.Model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository <users,String> {
}
