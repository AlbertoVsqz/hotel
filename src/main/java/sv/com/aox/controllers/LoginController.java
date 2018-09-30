package sv.com.aox.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import sv.com.aox.models.entities.Detalle_Usuario;
import sv.com.aox.models.services.IDetalleUsuarioService;



@Controller
@SessionAttributes("login")

public class LoginController {
	
	@Autowired	
	private IDetalleUsuarioService usuario;


	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}
	
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String verificar(@RequestParam String uname, @RequestParam String psw, HttpSession session, Model model) {
		
		List<Detalle_Usuario> usuario2 = usuario.loginusuario(uname,psw);
		/*System.out.println(uname);
		System.out.println(psw);
		usuario2.forEach(System.out::println);
		usuario2.stream().forEach(System.out::println);*/
		
		if(usuario2.isEmpty()) {
			/*System.out.println("entra");*/
			model.addAttribute("loginError"," Intente de nuevo, Usuario y/o Contraseña Incorrectas");
			
			return "login";
		}
		
		session.setAttribute("usuariologeado", usuario2);
		return "redirect:/";
	}
	
	@RequestMapping(value="/cerrarsession")
	public String destroySession(HttpSession session) {
		session.removeAttribute("usuariologeado");
		return "redirect:/";
	}

	
	
	
	
}
