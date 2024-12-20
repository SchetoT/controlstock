package com.app.springsecurity.entities;

import com.app.springsecurity.enums.RoleList;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleList name;

    public Role(RoleList name) {
        this.name = name;
    }
    public Role() {
    }
    public Role(Integer id, RoleList name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleList getName() {
        return name;
    }

    public void setName(RoleList name) {
        this.name = name;
    }
}