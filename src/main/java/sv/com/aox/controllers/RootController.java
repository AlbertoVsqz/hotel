package sv.com.aox.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class RootController {

	
	@RequestMapping(value ="/mision", method = RequestMethod.GET)
	public String misionForm() {
		return "mision";
	}
	@RequestMapping(value ="/vision", method = RequestMethod.GET)
	public String visionForm() {
		return "vision";
	}
	@RequestMapping(value ="/ubicacion", method = RequestMethod.GET)
	public String ubicacionForm() {
		return "ubicacion";
	}
	@RequestMapping(value ="/contacto", method = RequestMethod.GET)
	public String contactoForm() {
		return "contacto";
	}
	
}
