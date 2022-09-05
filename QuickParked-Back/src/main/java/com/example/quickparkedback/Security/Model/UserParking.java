package com.example.quickparkedback.Security.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "UserParking")
public class UserParking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (length = 50)
    private String userName;
    @Column (length = 50)
    private String passWord;
}
