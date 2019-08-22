package com.example.curso.boot.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curso.boot.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {

}
