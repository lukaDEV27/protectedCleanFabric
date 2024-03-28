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

import br.com.protectedCleanFabric.entity.ClienteEntity;
import br.com.protectedCleanFabric.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	

	
	@GetMapping("/") //nome que eu quiser colocar
	public String principal(ModelMap model)
	{
		model.addAttribute("clientes", clienteService.findAll());
		return "cliente"; //caminho real do arquivo
	}
	
	@GetMapping("/cliente")
	public String cliente(ModelMap model) {
		
		model.addAttribute("clientes", clienteService.findAll());
		
		return "cliente";
	}
	@PostMapping("/salvar_cliente")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("clienteEntity") ClienteEntity clienteEntity,
			RedirectAttributes attibutes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/cliente");
		attibutes.addFlashAttribute("mensagem", clienteService.save(clienteEntity));
		return mv;
	}
	
	@GetMapping("/alterar_cliente/{idCliente}")
	public ModelAndView update(ModelMap model,@PathVariable("idCliente") Long idCliente) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_cliente");
		model.addAttribute("idCliente", idCliente);
		model.addAttribute("cliente", clienteService.getOneByIdCliente(idCliente));
		
		return mv;
	}
	
	@PostMapping("/alterar_cliente")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("clienteEntity") ClienteEntity clienteEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/cliente");
		atributes.addFlashAttribute("mensagem", clienteService.save(clienteEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_cliente/{idCliente}")
	public ModelAndView delete(ModelMap model, @PathVariable("idCliente") Long idCliente, RedirectAttributes atributes) throws Exception 
	{
		ModelAndView mv = new ModelAndView("redirect:/cliente");
		model.addAttribute("mensagem", clienteService.deleteById(idCliente));
		//após a exclusão de um docente eu preciso atualizar a listagem na página
		//por isso realizo uma nova consulta findall
		model.addAttribute("clientes", clienteService.findAll());
		return mv;
		//termina a exclusão
	}
	
	//Aqui inicia o cadastro de pedido do cliente selecionado;
	
	@GetMapping("/pedido/{idCliente}")
	public ModelAndView cadastroPedido(ModelMap model,@PathVariable("idCliente") Long idCliente) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("pedido");
		model.addAttribute("idCliente", idCliente);
		model.addAttribute("cliente", clienteService.getOneByIdCliente(idCliente));
		
		return mv;
	}
			
//
}
