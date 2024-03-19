package br.com.protectedCleanFabric.service;

import java.util.List;

import br.com.protectedCleanFabric.entity.ClienteEntity;

public interface ClienteService {
	
	String save(ClienteEntity clienteEntity) throws Exception;
	List<ClienteEntity> findAll();
	ClienteEntity getOneByIdCliente (Long idCliente) throws Exception;

}
