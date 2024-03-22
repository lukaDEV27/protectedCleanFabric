package br.com.protectedCleanFabric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.protectedCleanFabric.service.ClienteService;

@Controller
public class ConsultaController {
	
	@Autowired
	private ClienteService clienteServise;
	
	@GetMapping("/consulta_cliente")
	public String cliente(ModelMap model) {
		
		model.addAttribute("clientes", clienteServise.findAll());
		
		return "consulta";
	}

}
