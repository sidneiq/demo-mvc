package com.example.curso.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
@Entity
public class Role  extends AbstractEntity<Long> implements GrantedAuthority {

	@NotBlank
	@Size(min = 3, max = 25)
	@Column(nullable = false, unique = true, length = 25)
	private String nome;

	@Override
	public String getAuthority() {
		return nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
