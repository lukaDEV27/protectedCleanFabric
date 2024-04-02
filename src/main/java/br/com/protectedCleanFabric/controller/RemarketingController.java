package br.com.protectedCleanFabric.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.protectedCleanFabric.entity.ClienteEntity;
import br.com.protectedCleanFabric.service.ClienteService;
import br.com.protectedCleanFabric.service.PedidoService;

@Controller
public class RemarketingController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/remarketing")//nome que eu quiser colocar
	public String principal(ModelMap model, Date dataAgendamento) throws Exception
	{
		model.addAttribute("pedidos", pedidoService.listarClientesDisponiveisRemarketig(dataAgendamento));
		return "remarketing"; //caminho real do arquivo
	}
	
	/*@GetMapping("/pedido/{cliente}")
	public ModelAndView revenda(ModelMap model,@PathVariable("cliente") ClienteEntity cliente) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("pedido");
		model.addAttribute("cliente", cliente.getIdCliente());
		model.addAttribute("cliente", clienteService.getOneByIdCliente(cliente.getIdCliente()));
		
		return mv;
		
	}*/
	

}
