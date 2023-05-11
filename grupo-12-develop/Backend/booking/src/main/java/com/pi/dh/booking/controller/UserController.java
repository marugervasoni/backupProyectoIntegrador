package com.pi.dh.booking.controller;

import com.pi.dh.booking.configuration.JWTAuthorizationFilter;
import com.pi.dh.booking.configuration.WebSecurityConfig;
import com.pi.dh.booking.dto.ResponseDTO;
import com.pi.dh.booking.dto.UserDTO;
import com.pi.dh.booking.model.UserEntity;
import com.pi.dh.booking.service.interfaces.IUserService;
import com.pi.dh.booking.util.Constant;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.Endpoints.USER)
public class UserController {

    private IUserService userService;
    private WebSecurityConfig webSecurityConfig;

    public UserController(IUserService userService, WebSecurityConfig webSecurityConfig){
        this.userService = userService;
        this.webSecurityConfig = webSecurityConfig;
    }

    @PostMapping(value=Constant.Endpoints.CREATE_USER, produces="application/json")
    public ResponseDTO<String> createUser(@RequestBody UserDTO userDTO){

        String message = userService.createUser(userDTO);

        return new ResponseDTO<>(HttpStatus.CREATED.value(), message);
    }
}
