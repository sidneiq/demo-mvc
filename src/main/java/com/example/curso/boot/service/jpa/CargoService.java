package com.example.curso.boot.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.boot.dao.jpa.CargoRepository;


@Service
public class CargoService {

	@Autowired
	private CargoRepository rep;
}
