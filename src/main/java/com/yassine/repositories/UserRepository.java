package com.yassine.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yassine.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
