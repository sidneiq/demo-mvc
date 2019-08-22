package com.example.curso.boot.web.validator;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.curso.boot.domain.Cargo;
import com.example.curso.boot.service.em.CargoService;

public class CargoValidator implements Validator {
	
	private CargoService service;
	

	public CargoValidator(CargoService service) {
		this.service = service;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Cargo.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Cargo f = (Cargo) object;
		
		if (f.getNome() != null && !f.getNome().trim().equals("")) {
			
			List<Cargo> list = service.buscarPorNome(f.getNome().trim());

			if (!list.isEmpty()) {
				//errors.rejectValue("nome", "duplicate.entry.data");
			}
		}
	}

}
