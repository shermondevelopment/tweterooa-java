package com.tweteroo.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.UserDTO;
import com.tweteroo.tweteroo.services.UserServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class Auth {

  @Autowired
  private UserServices service;

  @PostMapping("/sign-up")
  public ResponseEntity<String> create(@RequestBody @Valid UserDTO req) {
    service.create(req);
    return ResponseEntity.ok(null);
  }

}
