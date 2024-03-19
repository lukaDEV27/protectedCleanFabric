package br.com.protectedCleanFabric.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.protectedCleanFabric.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

	ClienteEntity getOneByIdCliente(Long idCliente);
}
