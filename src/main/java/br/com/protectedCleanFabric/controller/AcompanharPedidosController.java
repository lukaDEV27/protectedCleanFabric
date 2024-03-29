package br.com.protectedCleanFabric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.protectedCleanFabric.service.ClienteService;
import br.com.protectedCleanFabric.service.PedidoService;

@Controller
public class AcompanharPedidosController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/acompanhar_pedidos") //nome que eu quiser colocar
	public String acompanharPedidos(ModelMap model)
	{
		model.addAttribute("docentes", pedidoService.findAll());
		model.addAttribute("setores", clienteService.findAll());
		return "acompanhar_pedidos"; //caminho real do arquivo
	}

}
