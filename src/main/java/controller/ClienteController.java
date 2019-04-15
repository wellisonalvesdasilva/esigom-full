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

import dto.DtoClientePesquisa;
import dto.DtoRetornoPaginado;
import model.Cliente;
import services.ClienteService;

@Controller
@RequestMapping("/home/clientes")
@SessionAttributes("roles")

public class ClienteController {

	@Autowired
	ClienteService _clienteService;

	@RequestMapping(method = { RequestMethod.GET })
	public ModelAndView listarTodos() {
		return new ModelAndView("cliente/consultar");
	}

	@RequestMapping(value = "/pagination/{pagina}", method = { RequestMethod.POST })
	public @ResponseBody DtoRetornoPaginado<Cliente> paginated(@PathVariable("pagina") Integer pagina,
			@RequestBody DtoClientePesquisa dto) {
		return _clienteService.listAll(pagina, dto);
	}

	@RequestMapping(value = "/cadastrar", method = { RequestMethod.GET })
	public ModelAndView insert(ModelMap model) {
		model.addAttribute("obj", new Cliente());
		return new ModelAndView("cliente/cadastrar");
	}

	@RequestMapping(value = "/cadastrar", method = { RequestMethod.POST })
	public String insert(@ModelAttribute("obj") Cliente obj, RedirectAttributes ra, ModelMap model) throws Exception {
		_clienteService.salvar(obj);
		ra.addFlashAttribute("message", "Registro cadastrado com sucesso!");
		return "redirect:/home/clientes";
	}

	@RequestMapping(value = "/{cod}", method = { RequestMethod.GET })
	public ModelAndView editar(@PathVariable("cod") Integer cod, ModelMap model)
			throws NoSuchAlgorithmException, IllegalAccessException, InvocationTargetException {
		model.addAttribute("obj", _clienteService.getObj(cod));
		return new ModelAndView("cliente/editar");
	}

	@RequestMapping(value = "/{cod}", method = { RequestMethod.POST })
	public String editar(@PathVariable("cod") Integer cod, @ModelAttribute("obj") Cliente objMerge,
			RedirectAttributes ra) throws Exception {
		objMerge.setId(cod);
		Boolean retorno = _clienteService.editar(objMerge);

		if (retorno) {
			ra.addFlashAttribute("message", "Registro editado com sucesso!");
			return "redirect:/home/clientes";
		}
		return null;
	}

	@RequestMapping(value = "/excluir/{cod}", method = { RequestMethod.POST })
	public @ResponseBody void excluir(@PathVariable("cod") Integer cod) {
		try {
			_clienteService.deletar(cod);
		} catch (Exception e) {
			return;
		}
	}

	@RequestMapping(value = "/export", method = RequestMethod.POST)
	public void export(ModelAndView model, HttpServletResponse response, RedirectAttributes ra) throws Exception {
		try {
			_clienteService.exportPdfFile();
		} catch (Exception e) {
			System.out.println("Erro ao Exportar PDF!");
		}
	}

	@RequestMapping(value = "/detail/{cod}", method = { RequestMethod.GET })
	public @ResponseBody Object detalhes(@PathVariable("cod") Integer cod)
			throws IllegalAccessException, InvocationTargetException {

		Cliente cliente = (Cliente) _clienteService.getObj(cod);
		if (cliente != null) {
			return cliente;
		}
		System.out.println("Erro ao recuperar dados do cliente!");
		return null;

	}
}
