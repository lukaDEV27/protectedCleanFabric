package br.com.protectedCleanFabric.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.protectedCleanFabric.entity.PedidoEntity;

public interface PedidoService {

	String save(PedidoEntity pedidoEntity) throws Exception;

	List<PedidoEntity> findAll();

	PedidoEntity getOneByIdPedido(Long idPedido) throws Exception;

	// Começa a exclusão
	String deleteById(Long idPedido) throws Exception;
	// Termina a exclusão

	@Query(value = "SELECT * FROM pedido WHERE timestampdiff(day, ?1, current_date()) >= 365;", nativeQuery = true)
	List<PedidoEntity> listarClientesDisponiveisRemarketig(Date dataAgendamento);
}
