package com.example.quickparkedback.Security.Repository;

import com.example.quickparkedback.Security.Model.authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthoritiesRepository extends JpaRepository<authorities,String> {
}
