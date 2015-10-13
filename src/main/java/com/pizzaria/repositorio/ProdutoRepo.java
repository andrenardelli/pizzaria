package com.pizzaria.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pizzaria.dominio.Produto;

@Repository
public class ProdutoRepo extends DefaultRepository<Produto, Long> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Produto> listar(Class T) {
		log.info("Início ProdutoRepo.listar(" + T.getName() + ")");	
		// TODO Auto-generated method stub
		return super.listar(T);
	}

	@Override
	public Produto getById(Class<Produto> classe, Long id) {
		log.info("Início ProdutoRepo.getById(" + classe.getName() + ", " + id + ")");	
		// TODO Auto-generated method stub
		return super.getById(classe, id);
	}
	
}
