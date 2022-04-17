package ServiTec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ServiTec.entity.Usuario;
import ServiTec.service.IUsuarioService;

@Controller
public class LoginController {

	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario()) ;
		
		return "login";
	}
	
}
