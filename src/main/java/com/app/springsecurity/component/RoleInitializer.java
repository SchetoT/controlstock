package com.app.springsecurity.component;

import com.app.springsecurity.entities.Role;
import com.app.springsecurity.enums.RoleList;
import com.app.springsecurity.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(null, RoleList.ROLE_USER));
            roleRepository.save(new Role(null, RoleList.ROLE_ADMIN));
        }
    }
}