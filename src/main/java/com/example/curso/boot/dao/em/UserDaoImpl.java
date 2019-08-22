package com.example.curso.boot.dao.em;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.curso.boot.domain.User;

@Repository
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {

	@Override
	public List<User> findByNome(String nome) {
		return createQuery("select f from User f where f.nome like concat('%',?1,'%') ", nome);
	}


} 