package com.tweteroo.tweteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.TweetModel;

import java.util.List;

public interface TweetRepository extends JpaRepository<TweetModel, Long> {
  List<TweetModel> findAllByUsernameOrderByIdDesc(String username);
}
