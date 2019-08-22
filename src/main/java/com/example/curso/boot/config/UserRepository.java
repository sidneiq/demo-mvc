package com.example.curso.boot.config;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curso.boot.domain.User;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByLogin(String login);
}
