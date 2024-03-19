package br.com.protectedCleanFabric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.protectedCleanFabric.entity.ClienteEntity;
import br.com.protectedCleanFabric.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cliente")
	public String cliente(ModelMap model) {
		
		model.addAttribute("cliente", clienteService.findAll());
		
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
			
//
}
