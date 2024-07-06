package com.ps.demo2.model;

import com.ps.demo2.enums.UserRole;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
// import psycode.diwan.shared.auth.enums.UserRolePos;

@Entity
@Table(name = "roles")
@Setter
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserRole name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}