package controller;
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

import dto.DtoEstoquePesquisa;
import dto.DtoRetornoPaginado;
import model.Estoque;
import services.ClienteService;
import services.EstoqueService;
import services.EstoqueService;

@Controller
@RequestMapping("/home/estoques")
@SessionAttributes("roles")

public class EstoqueController {

	@Autowired
	EstoqueService _estoqueService;
	
	@RequestMapping(method = { RequestMethod.GET })
	public ModelAndView listarTodos() {
		return new ModelAndView("estoque/index");
	}
	
	@RequestMapping(value = "/pagination/{pagina}", method = { RequestMethod.POST })
	public @ResponseBody DtoRetornoPaginado<Estoque> paginated(@PathVariable("pagina") Integer pagina,
			@RequestBody DtoEstoquePesquisa dto) throws IllegalAccessException, InvocationTargetException {
		return _estoqueService.listAll(pagina, dto);
	}
	/*
	@RequestMapping(value = "/cadastrar", method = { RequestMethod.GET })
	public ModelAndView insert(ModelMap model) {
		model.addAttribute("obj", new Estoque());
		return new ModelAndView("Estoque/cadastrar");
	}

	@RequestMapping(value = "/cadastrar", method = { RequestMethod.POST })
	public String insert(@ModelAttribute("obj") Estoque obj, RedirectAttributes ra, ModelMap model) throws Exception {
		_EstoqueService.salvar(obj);
		ra.addFlashAttribute("message", "Registro cadastrado com sucesso!");
		return "redirect:/home/Estoques";
	}

	@RequestMapping(value = "/{cod}", method = { RequestMethod.GET })
	public ModelAndView editar(@PathVariable("cod") Integer cod, ModelMap model)
			throws NoSuchAlgorithmException, IllegalAccessException, InvocationTargetException {
		model.addAttribute("obj", _EstoqueService.getObj(cod));
		return new ModelAndView("Estoque/editar");
	}

	@RequestMapping(value = "/{cod}", method = { RequestMethod.POST })
	public String editar(@PathVariable("cod") Integer cod, @ModelAttribute("obj") Estoque objMerge, RedirectAttributes ra)
			throws Exception {
		objMerge.setId(cod);
		Boolean retorno = _EstoqueService.editar(objMerge);

		if (retorno) {
			ra.addFlashAttribute("message", "Registro editado com sucesso!");
			return "redirect:/home/Estoques";
		}
		return null;
	}

	@RequestMapping(value = "/excluir/{cod}", method = { RequestMethod.POST })
	public @ResponseBody void excluir(@PathVariable("cod") Integer cod) {
		try {
			_EstoqueService.deletar(cod);
		} catch (Exception e) {
			return;
		}
	}
*/
}
