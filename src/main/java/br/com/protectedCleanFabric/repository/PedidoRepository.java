package br.com.protectedCleanFabric.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.protectedCleanFabric.entity.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

	PedidoEntity getOneByIdPedido(Long idPedido);

}
