package com.tweteroo.tweteroo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.dtos.UserDTO;
import com.tweteroo.tweteroo.models.User;
import com.tweteroo.tweteroo.repository.UserRepository;

@Service
public class UserServices {

  @Autowired
  private UserRepository repository;

  public void create(UserDTO userDTO) {
    User registredUser = repository.findByUsername(userDTO.username());

    if (registredUser == null) {
      repository.save(new User(userDTO));
    } else {
      repository.findById(registredUser.getId()).map(user -> {
        user.setAvatar(userDTO.avatar());
        user.setUsername(userDTO.username());

        return repository.save(user);
      });
    }
  }

}
