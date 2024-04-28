package com.jpa.repository;

import com.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepo extends CrudRepository<User,Integer> {

    public List<User> findByName(String name);
    public List<User> findByNameAndCity(String name, String city);
    public List<User> findByNameStartingWith(String prefix);

    @Query("select u from User u")
    public List<User> getAllUsers();

    @Query("select u from User u where u.name =:n")
    public List<User> getUserByName(@Param("n") String name);

    @Query("select u from User u where u.name =:n and u.city =:c")
    public List<User> getUserByNameAndCity(@Param("n") String name, @Param("c") String city);

}
