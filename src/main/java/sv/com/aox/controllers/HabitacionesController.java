 package sv.com.aox.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sv.com.aox.models.services.IHabitacionesService;
import sv.com.aox.models.services.TipoHabitacionService;



@Controller
@SessionAttributes("habitaciones")

public class HabitacionesController {

	@Autowired	
		private IHabitacionesService habitacionesService ;
	
	@Autowired
		private TipoHabitacionService tipohabitacionService;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String listar(Map<String, Object> model) {
		System.out.println(tipohabitacionService.findAll());
		System.out.println(habitacionesService.findAll());
		model.put("titulo", "Hotel Olympia");
		model.put("tipo", tipohabitacionService.findAll());
		model.put("habitaciones", habitacionesService.findAll());
		 
		
		
		return "index";
	}
}
