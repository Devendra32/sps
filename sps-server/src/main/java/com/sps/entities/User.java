package com.sps.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 10,nullable = false)
    private String mobile;
    @Column
    private String address;
    @Column(length = 50)
    private String role = "user";
    @Column(nullable = false)
    private boolean status=true;
}
