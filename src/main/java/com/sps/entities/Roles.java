package com.sps.entities;

import jakarta.persistence.*;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    @Column(nullable = false,unique = true)
    private String roleName;
}
