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
		 if (pedidoEntity.getValor() == null) {
			this.mensagem = "Digite o valor do pedido.";
			throw new Exception("Preencha o valor do pedido.");
		} else if (pedidoEntity.getDataAgendamento() == null) {
			this.mensagem = "Preencha a data do agendamento do serviço.";
			throw new Exception("Preencha a data do agendamento do serviço.");
		/*} else if (pedidoEntity.getTipoServicos() == null) {
			this.mensagem = "Selecione o tipo de serviço agendado.";
			throw new Exception("Selecione o tipo de serviço agendado.");*/
		} else if (pedidoEntity.getCliente() == null){
			this.mensagem = "Preencha o campo do cliente que solicitou o serviço.";
			throw new Exception("Preencha o campo do cliente que solicitou o serviço.");
		} else {
			pedidoRepository.saveAndFlush(pedidoEntity);
		}
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
			this.mensagem = "Cliente excluído com sucesso.";
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
