package br.com.protectedCleanFabric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.protectedCleanFabric.entity.PedidoEntity;
import br.com.protectedCleanFabric.service.ClienteService;
import br.com.protectedCleanFabric.service.PedidoService;

@Controller
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/pedido")
	public String pedido(ModelMap model) {
		
		model.addAttribute("pedidos", pedidoService.findAll());
		model.addAttribute("clientes", clienteService.findAll());
		
		return "pedido";
	}
	
	@PostMapping("/salvar_pedido")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("pedidoEntity") PedidoEntity pedidoEntity,
			RedirectAttributes attibutes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/cliente");
		attibutes.addFlashAttribute("mensagem", pedidoService.save(pedidoEntity));
		return mv;
	}
	
}
