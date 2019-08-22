package com.example.curso.boot.dao.em;

import java.util.List;

import com.example.curso.boot.domain.User;

public interface UserDao {

    void save(User user );

    void update(User user);

    void delete(Long id);

    User findById(Long id);

    List<User> findAll();

	List<User> findByNome(String nome);
}