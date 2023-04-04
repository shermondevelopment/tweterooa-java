package com.tweteroo.tweteroo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.dtos.TweetDTO;
import com.tweteroo.tweteroo.repository.TweetRepository;
import com.tweteroo.tweteroo.models.TweetModel;
import java.util.List;

@Service()
public class TweetService {
  @Autowired
  private TweetRepository repository;

  public void create(TweetDTO tweetDTO) {
    this.repository.save(new TweetModel(tweetDTO));
  }

  public Page<TweetModel> ListAllService(int page) {
    System.out.printf("%s - %s", "shermon", page);
    int size = 5;
    Pageable filters = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
    Page<TweetModel> tweetsPage = repository.findAll(filters);
    return tweetsPage;
  }

  public List<TweetModel> ListAllByUserName(String username) {
    return repository.findAllByUsernameOrderByIdDesc(username);
  }

}
