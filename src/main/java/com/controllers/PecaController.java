package com.controllers;

import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dtos.DtoPecaPesquisa;
import com.dtos.DtoRetornoPaginado;
import com.entities.Peca;
import com.servicesapi.PecaService;

@Controller
@RequestMapping("/home/pecas")
@SessionAttributes("roles")

public class PecaController {

	@Autowired
	PecaService _pecaService;

	@RequestMapping(method = { RequestMethod.GET })
	public ModelAndView listarTodos() {
		return new ModelAndView("peca/consultar");
	}

	@RequestMapping(value = "/pagination/{pagina}", method = { RequestMethod.POST })
	public @ResponseBody DtoRetornoPaginado<Peca> paginated(@PathVariable("pagina") Integer pagina,
			@RequestBody DtoPecaPesquisa dto) {
		return _pecaService.listAll(pagina, dto);
	}

	@RequestMapping(value = "/cadastrar", method = { RequestMethod.GET })
	public ModelAndView insert(ModelMap model) {
		model.addAttribute("obj", new Peca());
		return new ModelAndView("peca/cadastrar");
	}

	@RequestMapping(value = "/cadastrar", method = { RequestMethod.POST })
	public String insert(@ModelAttribute("obj") Peca obj, RedirectAttributes ra, ModelMap model) throws Exception {
		_pecaService.salvar(obj);
		ra.addFlashAttribute("message", "Registro cadastrado com sucesso!");
		return "redirect:/home/pecas";
	}

	@RequestMapping(value = "/{cod}", method = { RequestMethod.GET })
	public ModelAndView editar(@PathVariable("cod") Integer cod, ModelMap model)
			throws NoSuchAlgorithmException, IllegalAccessException, InvocationTargetException {
		model.addAttribute("obj", _pecaService.getObj(cod));
		return new ModelAndView("peca/editar");
	}

	@RequestMapping(value = "/{cod}", method = { RequestMethod.POST })
	public String editar(@PathVariable("cod") Integer cod, @ModelAttribute("obj") Peca objMerge, RedirectAttributes ra)
			throws Exception {
		objMerge.setId(cod);
		Boolean retorno = _pecaService.editar(objMerge);

		if (retorno) {
			ra.addFlashAttribute("message", "Registro editado com sucesso!");
			return "redirect:/home/Pecas";
		}
		return null;
	}

	@RequestMapping(value = "/excluir/{cod}", method = { RequestMethod.POST })
	public @ResponseBody void excluir(@PathVariable("cod") Integer cod) {
		try {
			_pecaService.deletar(cod);
		} catch (Exception e) {
			return;
		}
	}

}
