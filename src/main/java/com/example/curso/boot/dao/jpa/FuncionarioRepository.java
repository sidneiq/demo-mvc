package com.example.curso.boot.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curso.boot.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

}
