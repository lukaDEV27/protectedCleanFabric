package br.com.protectedCleanFabric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.protectedCleanFabric.service.PedidoService;

@Controller
public class ConsultaPedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/consulta_pedido")
	public String consultaPedido(ModelMap model) {
		
		model.addAttribute("pedidos", pedidoService.findAll());
		
		return "consultaPedido";
	}
	
	@GetMapping("/consulta_pedido/consultar_pedidos")
	public String consultaCliente(ModelMap model) {
		
		model.addAttribute("clientes", pedidoService.consultarPedido(null, null, null, null));
		
		return "consultaPedido";
	}
	
	@GetMapping("/consulta_pedido/excluir_pedido/{idPedido}")
	public ModelAndView delete(ModelMap model, @PathVariable("idPedido") Long idPedido, RedirectAttributes atributes) throws Exception 
	{
		ModelAndView mv = new ModelAndView("consultaPedido");
		model.addAttribute("mensagem", pedidoService.deleteById(idPedido));
		//após a exclusão de um cliente eu preciso atualizar a listagem na página
		//por isso realizo uma nova consulta findall
		model.addAttribute("pedidos", pedidoService.findAll());
		return mv;
		//termina a exclusão
	}

}
