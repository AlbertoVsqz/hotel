package sv.com.aox.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.aox.models.services.AdHabitacionesService;
import  sv.com.aox.models.entities.Habitaciones;
@Controller
@SessionAttributes("Adhabitaciones")
public class AdHabitacionesController {

	@Autowired	
	private AdHabitacionesService adhabitacionesService ;
	
@RequestMapping(value="/admin/habitaciones", method=RequestMethod.GET)
public String listar(Map<String, Object> model) {
	System.out.println(adhabitacionesService.findAll());
	model.put("titulo", "Hotel Olympia");
	model.put("habitaciones", adhabitacionesService.findAll());

	return "admin/habitaciones";
}
@RequestMapping(value="/admin/habitacion")
public String crear(Map<String, Object> model) {
	Habitaciones habitaciones = new Habitaciones();
	model.put("habitaciones", habitaciones);
	model.put("title", "Formulario de Habitaciones");
	return "admin/habitacion";
}
@RequestMapping(value="/admin")
public String ver(Map<String, Object> model) {
	model.put("title", "Menu");
	return "admin/index";
}
@RequestMapping(value="/admin/index")
public String ver2(Map<String, Object> model) {
	model.put("title", "Menu");
	return "admin/index";
}
@RequestMapping(value="/admin/habitacion", method=RequestMethod.POST)
public String guardar(@Valid Habitaciones product, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
	if(bindingResult.hasErrors()) {
		return "/admin/habitacion";
	}
	
	adhabitacionesService.save(product);
	sessionStatus.setComplete();
	
	flash.addFlashAttribute("success","Producto creado con exito");
	return "redirect:/admin/habitaciones";
}

@RequestMapping(value="admin/habitacion/{id}")
public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
	Habitaciones habitacion = null;
	if (id > 0) {
		habitacion= adhabitacionesService.findOne(id);
	}else {
		flash.addFlashAttribute("error","El Id no puede ser cero");
		return "redirect:admin/habitacion";
	}
	model.put("habitaciones", habitacion);
	model.put("title", "Editar Habitacion");
	
	return "admin/habitacion";
}

@RequestMapping(value="/remove/{id}")
public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
	if (id > 0 ) {
		adhabitacionesService.delete(id);
	}
	flash.addFlashAttribute("success","producto eliminado con exito");
	return "redirect:/admin/habitaciones";
}

}
