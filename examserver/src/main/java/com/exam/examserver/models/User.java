package com.exam.examserver.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "userschema")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastname;

    private String password;

    private String profile;

    private String role="Student";
}
