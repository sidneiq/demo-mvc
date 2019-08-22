package com.example.curso.boot.service.em;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.curso.boot.dao.em.UserDao;
import com.example.curso.boot.domain.User;

@Service 
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public void salvar(User user) {
		dao.save(user);		
	}

	@Override
	public void editar(User user) {
		dao.update(user);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override 
	@Transactional(readOnly = true)
	public User buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override 
	@Transactional(readOnly = true)
	public List<User> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean userTemRoles(Long id) {
		if (buscarPorId(id).getRoles().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public List<User> buscarPorNome(String nome) {
		return dao.findByNome(nome);
	}



}
