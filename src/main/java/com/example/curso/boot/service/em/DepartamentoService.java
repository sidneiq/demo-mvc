package com.example.curso.boot.service.em;

import java.util.List;

import com.example.curso.boot.domain.Departamento;

public interface DepartamentoService {

	void salvar(Departamento departamento);

	void editar(Departamento departamento);

	void excluir(Long id);

	Departamento buscarPorId(Long id);

	List<Departamento> buscarTodos();
	
	boolean depertamentoTemCargos(Long id);
} 
