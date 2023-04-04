package com.tweteroo.tweteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.TweetModel;

public interface TweetRepository extends JpaRepository<TweetModel, Long> {

}
