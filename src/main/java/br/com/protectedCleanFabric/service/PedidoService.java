package br.com.protectedCleanFabric.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.protectedCleanFabric.entity.PedidoEntity;

public interface PedidoService {

	String save(PedidoEntity pedidoEntity) throws Exception;

	List<PedidoEntity> findAll();

	PedidoEntity getOneByIdPedido(Long idPedido) throws Exception;

	@Query(value = "select 	c.nome, c.sobrenome, p.* from pedido p "
			+ "inner join cliente c on p.cliente_id = c.id_cliente " + "where " + "c.nome = ?1 and "
			+ "c.sobrenome = ?2 and " + "p.data_agendamento = ?3 and" + "p.num_pedido = ?4", nativeQuery = true)
	List<PedidoEntity> consultarPedido(String clienteNome, String clienteSobrenome, Date dataAgendamento,
			String numPedido);

	// Começa a exclusão
	String deleteById(Long idPedido) throws Exception;
	// Termina a exclusão
}
