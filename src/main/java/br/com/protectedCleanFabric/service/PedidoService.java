package br.com.protectedCleanFabric.service;

import java.util.List;

import br.com.protectedCleanFabric.entity.PedidoEntity;

public interface PedidoService {

	String save(PedidoEntity pedidoEntity) throws Exception;
	List<PedidoEntity> findAll();
	PedidoEntity getOneByIdPedido (Long idPedido) throws Exception;
	
}
