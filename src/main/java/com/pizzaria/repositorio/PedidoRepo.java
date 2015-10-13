package com.pizzaria.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pizzaria.dominio.Pedido;

@Repository
public class PedidoRepo extends DefaultRepository<Pedido, Long> {
	
	@Override
	public boolean save(Pedido pedido) {
		log.info("Início PedidoRepo.save(" + pedido + ")");	
		// TODO Auto-generated method stub
		return super.save(pedido);
	}
	
	@Override
	public Pedido getById(Class<Pedido> classe, Long id) {
		log.info("Início PedidoRepo.getById(" + classe.getName() + ", " + id + ")");	
		// TODO Auto-generated method stub
		return super.getById(classe, id);
	}
	
	@Override
	public List<Pedido> listar(Class<Pedido> classe) {
		log.info("Início PedidoRepo.listar(" + classe.getName() + ")");	
		// TODO Auto-generated method stub
		return super.listar(classe);
	}
	
}
