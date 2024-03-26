package br.com.protectedCleanFabric.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.protectedCleanFabric.entity.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
	
	PedidoEntity getOneByIdPedido(Long idPedido);
	
	@Query(value = "select c.nome, c.sobrenome, c.mercadoria, p.* from pedido p "
			+ "inner join cliente c on p.cliente_id = c.id_cliente "
			+ "where "
			+ "c.nome = ?1 and "
			+ "c.sobrenome = ?2 and "
			+ "p.data_agendamento = ?3 and"
			+ "p.num_pedido = ?4", nativeQuery = true)
	List<PedidoEntity> consultarPedido(String clienteNome, String clienteSobrenome, Date dataAgendamento, String numPedido);
	
}
