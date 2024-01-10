package com.vollmed.project.controllers;


import com.vollmed.project.entities.records.RequestUser;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {


    @Autowired
    private AuthenticationManager manager;


    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid RequestUser data){

        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());

        var authenticaon = manager.authenticate(token);

        return ResponseEntity.ok().build();

    }

}
