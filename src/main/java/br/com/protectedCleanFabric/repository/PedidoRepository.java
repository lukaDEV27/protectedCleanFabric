package br.com.protectedCleanFabric.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.protectedCleanFabric.entity.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

	PedidoEntity getOneByIdPedido(Long idPedido);

	@Query(value = "select * from pedido where ?1 <= current_date;", nativeQuery = true)
	List<PedidoEntity> listarClientesDisponiveisRemarketig(Date dataAgendamento);

	

}
