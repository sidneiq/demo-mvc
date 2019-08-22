package com.example.curso.boot.dao.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.curso.boot.domain.Cargo;

public interface CargoRepository extends JpaRepository<Cargo,Long> {

	  @Query("select pe.id, pe.nome from Cargo pe where pe.nome = :nome ")
	  Optional<Cargo> findByNome(@Param("nome") String nome);
}
