package com.example.curso.boot.service.em;

import java.util.List;

import com.example.curso.boot.domain.User;


public interface UserService {

	void salvar(User user);

	void editar(User user);

	void excluir(Long id);

	User buscarPorId(Long id);

	List<User> buscarTodos();
	
	boolean userTemRoles(Long id);
	
	List<User> buscarPorNome(String nome);
}
