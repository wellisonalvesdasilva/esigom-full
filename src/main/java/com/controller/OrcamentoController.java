package com.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.DtoListaPeca;
import com.model.Cliente;
import com.model.Servico;
import com.services.OrcamentoService;

@Controller
@RequestMapping("/home/orcamentos")
@SessionAttributes("roles")

public class OrcamentoController {

	@Autowired
	OrcamentoService _ordemServicoService;

	@RequestMapping(value = "/cadastrar", method = { RequestMethod.GET })
	public ModelAndView insert(ModelMap model) {
		model.addAttribute("obj", new Servico());
		return new ModelAndView("orcamento/cadastrar");
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getPesquisaPeca/{nome}", method = { RequestMethod.GET })
	public @ResponseBody DtoListaPeca getPecas(@PathVariable("nome") String nome, RedirectAttributes r) {

		DtoListaPeca retorno = _ordemServicoService.getPesquisaPeca(nome);

		if (retorno != null) {
			return retorno;
		}
		return null;
	}

	@RequestMapping(value = "/getPesquisaServico/{nome}", method = { RequestMethod.GET })
	public @ResponseBody DtoListaPeca getServicos(@PathVariable("nome") String nome, RedirectAttributes r) {

		DtoListaPeca retorno = _ordemServicoService.getPesquisaServico(nome);

		if (retorno != null) {
			return retorno;
		}
		return null;
	}

	@RequestMapping(value = "/getCliente/{cpf}", method = { RequestMethod.GET })
	public @ResponseBody Cliente getCliente(@PathVariable("cpf") String cpf) {

		Cliente retorno = _ordemServicoService.getCliente(cpf);

		if (retorno != null) {
			return retorno;
		}
		return null;
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public @ResponseBody Boolean saveOrcamento(@RequestParam Object dto) {

		return _ordemServicoService.salvarOrcamento(dto);

	}

}
