package com.example.curso.boot.service.em;

import java.time.LocalDate;
import java.util.List;

import com.example.curso.boot.domain.Funcionario;

public interface FuncionarioService {

	void salvar(Funcionario funcionario);

	void editar(Funcionario funcionario);

	void excluir(Long id);

	Funcionario buscarPorId(Long id);

	List<Funcionario> buscarTodos();
	
	List<Funcionario> buscarPorNome(String nome);

	List<Funcionario> buscarPorCargo(Long id);
	
	List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida);
}
