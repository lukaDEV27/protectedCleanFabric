package br.com.protectedCleanFabric.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.protectedCleanFabric.entity.ClienteEntity;

public interface ClienteService {

	String save(ClienteEntity clienteEntity) throws Exception;

	List<ClienteEntity> findAll();

	ClienteEntity getOneByIdCliente(Long idCliente) throws Exception;

	@Query(value = "select * from cliente " + "where nome = ?1 and sobrenome = ?2"
			+ " and telefone = ?3", nativeQuery = true)
	List<ClienteEntity> consultarCliente(String nome, String sobrenome, String telefone);

	// Começa a exclusão
	String deleteById(Long idCliente) throws Exception;
	// Termina a exclusão
}
