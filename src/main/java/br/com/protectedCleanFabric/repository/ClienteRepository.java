package br.com.protectedCleanFabric.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.protectedCleanFabric.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

	ClienteEntity getOneByIdCliente(Long idCliente);
	
	@Query(value = "select * from cliente "
			+ "where nome = ?1 and sobrenome = ?2"
			+ " and telefone = ?3", nativeQuery = true)
	List<ClienteEntity> consultarCliente(String nome, String sobrenome, String telefone);
	
}
