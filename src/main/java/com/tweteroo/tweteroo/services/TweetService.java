package com.tweteroo.tweteroo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.repository.TweetRepository;
import com.tweteroo.tweteroo.models.TweetModel;

@Service()
public class TweetService {
  @Autowired
  private TweetRepository repository;

  public void create(TweetDTO tweetDTO) {
    this.repository.save(new TweetModel(tweetDTO));
  }

}
