package com.pizzaria.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pizzaria.dominio.SaborPizza;

@Repository
public class SaborPizzaRepo extends DefaultRepository<SaborPizza, Long> {

	@Override
	public List<SaborPizza> listar(Class<SaborPizza> classe) {
		log.info("Início SaborPizzaRepo.listar(" + classe.getName() + ")");	
		// TODO Auto-generated method stub
		return super.listar(classe);
	}
	
}
