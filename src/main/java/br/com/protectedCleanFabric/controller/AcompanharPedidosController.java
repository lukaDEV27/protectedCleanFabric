package br.com.protectedCleanFabric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.protectedCleanFabric.entity.PedidoEntity;
import br.com.protectedCleanFabric.service.PedidoService;

@Controller
public class AcompanharPedidosController {
	
	@Autowired
	private PedidoService pedidoService;
	
	
	@GetMapping("/acompanhar_pedidos") //nome que eu quiser colocar
	public String acompanharPedidos(ModelMap model)
	{
		model.addAttribute("pedidos", pedidoService.findAll());
		return "acompanhar_pedidos"; //caminho real do arquivo
	}
	
	@GetMapping("/alterar_pedido/{idPedido}")
	public ModelAndView update(ModelMap model,@PathVariable("idPedido") Long idPedido) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_pedido");
		model.addAttribute("idPedido", idPedido);
		model.addAttribute("pedido", pedidoService.getOneByIdPedido(idPedido));
		
		return mv;
	}
	
	@PostMapping("/alterar_pedido")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("pedidoEntity") PedidoEntity pedidoEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/pedido");
		atributes.addFlashAttribute("mensagem", pedidoService.save(pedidoEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_pedido/{idPedido}")
	public ModelAndView delete(ModelMap model, @PathVariable("idPedido") Long idPedido, RedirectAttributes atributes) throws Exception 
	{
		ModelAndView mv = new ModelAndView("redirect:/acompanhar_pedidos");
		model.addAttribute("mensagem", pedidoService.deleteById(idPedido));
		//após a exclusão de um docente eu preciso atualizar a listagem na página
		//por isso realizo uma nova consulta findall
		model.addAttribute("pedidos", pedidoService.findAll());
		return mv;
		//termina a exclusão
	}
	
	@GetMapping("/remarcar_pedido/{idPedido}")
	public ModelAndView remarcar(ModelMap model,@PathVariable("idPedido") Long idPedido) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("reamarcar_pedido");
		model.addAttribute("idPedido", idPedido);
		model.addAttribute("pedido", pedidoService.getOneByIdPedido(idPedido));
		
		return mv;
	}
	
	@PostMapping("/remarcar_pedido")
	public ModelAndView remarcar(
			ModelMap model,
			@ModelAttribute("pedidoEntity") PedidoEntity pedidoEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/pedido");
		atributes.addFlashAttribute("mensagem", pedidoService.save(pedidoEntity));
		
		return mv;
	}

}
