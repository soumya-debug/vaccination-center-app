package com.example.vaccinationcenter.repository;

import com.example.vaccinationcenter.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  public User findByEmail(String email);
}
