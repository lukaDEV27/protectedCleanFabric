package br.com.protectedCleanFabric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.protectedCleanFabric.service.ClienteService;

@Controller
public class ConsultaController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/consulta_cliente")
	public String consulta(ModelMap model) {
		
		model.addAttribute("clientes", clienteService.findAll());
		
		return "consulta";
	}
	
	@GetMapping("/consulta_cliente/consultar_clientes")
	public String consultaCliente(ModelMap model) {
		
		model.addAttribute("clientes", clienteService.consultarCliente(null, null, null));
		
		return "consulta";
	}
	
	@GetMapping("/consulta_cliente/excluir_cliente/{idCliente}")
	public ModelAndView delete(ModelMap model, @PathVariable("idCliente") Long idCliente, RedirectAttributes atributes) throws Exception 
	{
		ModelAndView mv = new ModelAndView("consulta");
		model.addAttribute("mensagem", clienteService.deleteById(idCliente));
		//após a exclusão de um cliente eu preciso atualizar a listagem na página
		//por isso realizo uma nova consulta findall
		model.addAttribute("clientes", clienteService.findAll());
		return mv;
		//termina a exclusão
	}

}
