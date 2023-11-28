package com.excelar.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelar.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
