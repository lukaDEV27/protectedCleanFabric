package br.com.protectedCleanFabric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.protectedCleanFabric.entity.TipoServicoEntity;
import br.com.protectedCleanFabric.repository.TipoServicoRepository;

@Service
public class TipoServicoServiceImpl implements TipoServicoService {

	@Autowired
	private TipoServicoRepository tipoServicoRepository;
	@Override
	public List<TipoServicoEntity> findAll() {
		
		return tipoServicoRepository.findAll();
	}

}
