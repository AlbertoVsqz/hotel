package sv.com.aox.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sv.com.aox.models.services.IDetalleUsuarioService;

@Controller
@SessionAttributes("usuarios")

public class AdUsuariosController {
	@Autowired	
	private IDetalleUsuarioService usuario;

	@RequestMapping(value ="/admin/usuarios", method = RequestMethod.GET)
	public String showForm(Map<String, Object> model) {
		model.put("titulo", "Hotel Olympia");
		model.put("usuarios", usuario.findAll());
		return "/admin/Usuarios";
	}
}
