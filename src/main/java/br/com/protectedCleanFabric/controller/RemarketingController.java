package br.com.protectedCleanFabric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.protectedCleanFabric.service.PedidoService;

@Controller
public class RemarketingController {
	
	//@Autowired
	//private ClienteService clienteService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/remarketing")//nome que eu quiser colocar
	public String principal(ModelMap model)
	{
	/*	model.addAttribute("pedidos", pedidoService.listarClientesDisponiveisRemarketig(null));*/
		return "remarketing"; //caminho real do arquivo
	}
	
	/*@GetMapping("/pedido/{idCliente}")
	public ModelAndView revenda(ModelMap model,@PathVariable("idCliente") Long idCliente) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("pedido");
		model.addAttribute("idCliente", idCliente);
		model.addAttribute("cliente", clienteService.getOneByIdCliente(idCliente));
		
		return mv;*/

	
}
