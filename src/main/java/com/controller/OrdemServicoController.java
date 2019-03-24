package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Peca;
import com.model.Servico;
import com.services.ClienteService;
import com.services.OrdemServicoService;

@Controller
@RequestMapping("/home/os")
@SessionAttributes("roles")

public class OrdemServicoController {

	@Autowired
	OrdemServicoService _ordemServicoService;

	@RequestMapping(value = "/cadastrar", method = { RequestMethod.GET })
	public ModelAndView insert(ModelMap model) {
		model.addAttribute("obj", new Servico());
		return new ModelAndView("ordem-de-servico/cadastrar");
	}

	@RequestMapping(value = "/getPesquisaPeca/{nome}", method = { RequestMethod.GET })
	public @ResponseBody List<Peca> listarUgsPorAviso(@PathVariable("nome") String nome, RedirectAttributes r) {

		List<Peca> retorno = _ordemServicoService.getPesquisaPeca(nome);

		if (retorno != null) {
			return retorno;
		}
		return null;
	}

}
