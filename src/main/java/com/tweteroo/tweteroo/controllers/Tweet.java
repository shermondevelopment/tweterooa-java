package com.tweteroo.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweet")
public class Tweet {

  @Autowired
  private TweetService service;

  @PostMapping("/add")
  public void create(@RequestBody @Valid TweetDTO req) {
    service.create(req);
    ResponseEntity.ok("OK");
  }

}
