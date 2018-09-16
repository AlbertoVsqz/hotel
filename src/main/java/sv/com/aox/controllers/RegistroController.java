package sv.com.aox.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.annotations.common.reflection.java.generics.TypeEnvironmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import aj.org.objectweb.asm.Type;
import sv.com.aox.models.entities.Detalle_Usuario;
import sv.com.aox.models.services.IDetalleUsuarioService;

@Controller
@SessionAttributes("registro")
public class RegistroController {

	@Autowired	
	private IDetalleUsuarioService usuario;

	
	@RequestMapping(value ="/registro", method = RequestMethod.GET)
	public String showRegistroForm() {
		return "registro";
	}
	
	/*@RequestMapping(value ="/registro", method = RequestMethod.POST)
	public String verificar(@RequestParam String dui, @RequestParam String nombre, @RequestParam String apellido, @RequestParam Integer edad, @RequestParam String telefono, @RequestParam String direccion, @RequestParam String ciudad, @RequestParam String usuariov, @RequestParam String pass, @RequestParam String email, HttpSession session, Model model) {
		int ntelefono = Integer.parseInt(telefono);
		int tipo = 1;
		int estado = 1;
		System.out.println(dui);
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(edad);
		System.out.println(ntelefono);
		System.out.println(direccion);
		System.out.println(ciudad);
		System.out.println(usuariov);
		System.out.println(pass);
		System.out.println(email);
		
		
		
		List<Detalle_Usuario> usuario2 = usuario.registrousuario(null, dui, nombre, apellido, usuariov, pass, email, edad, ntelefono, direccion, ciudad, tipo, estado);
		/*System.out.println(uname);
		System.out.println(psw);
		usuario2.forEach(System.out::println);
		usuario2.stream().forEach(System.out::println);*/
		/*
		if(usuario2.isEmpty()) {
			/*System.out.println("entra");*/
			/*model.addAttribute("loginError"," Intente de nuevo, Usuario y/o Contraseña Incorrectas");
			
			return "login";
		}

		return "index";
	}*/

	@RequestMapping(value="/registro", method=RequestMethod.POST)
	public String guardar(@Valid Detalle_Usuario cliente, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus, @RequestParam String dui, Model model) {
		
			List<Detalle_Usuario> verDui = usuario.verificardui(dui);
		
		if(verDui.isEmpty()) {
			if(bindingResult.hasErrors()) {
				return "registro";
			}
			usuario.save(cliente);
			sessionStatus.setComplete();
			
			flash.addFlashAttribute("success","USUARIO CREADO CORRECTAMENTE");
			return "redirect:/";
		}else {
			
			/*System.out.println("entra");*/
			model.addAttribute("duiError","El Dui Ingresado Ya existe");
			return "registro";
		}
		
		
	}
	
	
	
}
