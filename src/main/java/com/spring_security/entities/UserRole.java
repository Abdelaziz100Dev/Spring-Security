package com.spring_security.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ROLES")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    private String name;

}