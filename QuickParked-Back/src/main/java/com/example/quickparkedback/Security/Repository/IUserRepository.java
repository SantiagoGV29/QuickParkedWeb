package com.example.quickparkedback.Security.Repository;

import com.example.quickparkedback.Security.Model.UserParking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUserRepository extends JpaRepository<UserParking, Long> {
    Optional<UserParking> findByUserName (String userName);
}
