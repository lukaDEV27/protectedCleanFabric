package br.com.protectedCleanFabric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.protectedCleanFabric.entity.PedidoEntity;
import br.com.protectedCleanFabric.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository pedidoRepository;
	
	private String mensagem;
	
	//Metodo para confirmação de cadastro
	@Override
	public String save(PedidoEntity pedidoEntity) throws Exception {
		 
			this.mensagem = "Pedido cadastrado com sucesso!";
			pedidoRepository.saveAndFlush(pedidoEntity);
		
		return mensagem;
	}

	//Lista de pedidos
	@Override
	public List<PedidoEntity> findAll() {
		
		return pedidoRepository.findAll();
	}

	
	@Override
	public PedidoEntity getOneByIdPedido(Long idPedido) throws Exception {
		
		return pedidoRepository.getOneByIdPedido(idPedido);
	}
	
	@Override
	public String deleteById(Long idPedido) throws Exception {
		try 
		{
			pedidoRepository.deleteById(idPedido);
			this.mensagem = "Pedido excluído com sucesso.";
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
