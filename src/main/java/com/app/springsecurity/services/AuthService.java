package com.app.springsecurity.services;

import com.app.springsecurity.dtos.NewUserDto;
import com.app.springsecurity.entities.Role;
import com.app.springsecurity.entities.User;
import com.app.springsecurity.enums.RoleList;
import com.app.springsecurity.jwt.JwtUtil;
import com.app.springsecurity.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    public AuthService(UserService userService, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }
    //autenticar usuario
    public String authenticate(String username, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtil.generateToken(authResult);
    }
    //registrar usuario
    public void registerUser(NewUserDto newUserDto) {
        if (userService.existsByUserName(newUserDto.getUserName())) {
            throw new IllegalArgumentException("El nombre de usuario ya existe");
        }

        //Validar el rol proporcionado
        RoleList roleName;
        try {
            roleName = RoleList.valueOf(newUserDto.getRole().toUpperCase()); // Convertir a mayúsculas para evitar errores de formato
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Rol inválido: " + newUserDto.getRole());
        }

        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        User user = new User(newUserDto.getUserName(), passwordEncoder.encode(newUserDto.getPassword()), role);
        userService.save(user);
    }
}