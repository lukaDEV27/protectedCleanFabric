package br.com.protectedCleanFabric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.protectedCleanFabric.entity.ClienteEntity;
import br.com.protectedCleanFabric.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	private String mensagem;
	
	@Override
	public String save(ClienteEntity clienteEntity) throws Exception {
		if (clienteEntity.getNome() == null) {
			this.mensagem = "Digite o nome do cliente.";
			throw new Exception("Preencha o nome do cliente.");
		} else if (clienteEntity.getSobrenome() == null) {
			this.mensagem = "Digite o sobrenome do cliente.";
			throw new Exception("Preencha o sobrenome do cliente.");
		} else if (clienteEntity.getEndereco() == null) {
			this.mensagem = "Digite o endereço do cliente.";
			throw new Exception("Preencha o endereço do cliente.");
		} else {
			this.mensagem = "Cliente cadastrado com sucesso!";
			clienteRepository.saveAndFlush(clienteEntity);
		}
		return mensagem;
	}

	@Override
	public List<ClienteEntity> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public ClienteEntity getOneByIdCliente(Long idCliente) throws Exception {
		return clienteRepository.getOneByIdCliente(idCliente);
	}

	@Override
	public String deleteById(Long idCliente) throws Exception {
		try 
		{
			clienteRepository.deleteById(idCliente);
			this.mensagem = "Cliente excluído com sucesso.";
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
