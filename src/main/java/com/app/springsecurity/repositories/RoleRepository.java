package com.app.springsecurity.repositories;

import com.app.springsecurity.entities.Role;
import com.app.springsecurity.enums.RoleList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleList name);
}