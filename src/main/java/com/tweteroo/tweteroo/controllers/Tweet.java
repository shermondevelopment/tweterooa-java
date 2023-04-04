package com.tweteroo.tweteroo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.models.TweetModel;
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

  @GetMapping
  public ResponseEntity<Page<TweetModel>> listAll(@RequestParam(defaultValue = "0") int page) {
    Page<TweetModel> tweets = this.service.ListAllService(page);
    System.out.println(tweets);
    return ResponseEntity.ok().body(tweets);
  }

  @GetMapping("/{username}")
  public ResponseEntity<List<TweetModel>> getTweetsByUser(@PathVariable String username) {
    List<TweetModel> tweets = service.ListAllByUserName(username);
    return ResponseEntity.ok().body(tweets);
  }

}
