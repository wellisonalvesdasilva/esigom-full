package com.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home/dashboard")
@SessionAttributes("roles")
public class DashboardController {

	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView consultar(@RequestParam Map<String, String> objPesquisa, ModelMap model) {
		// model.addAttribute("lista", _cardapioService.list(objPesquisa));
		return new ModelAndView("dashboard/index");
	}
}
