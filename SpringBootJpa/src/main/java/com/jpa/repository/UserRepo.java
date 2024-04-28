package com.jpa.repository;

import com.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepo extends CrudRepository<User,Integer> {

    public List<User> findByName(String name);
}
