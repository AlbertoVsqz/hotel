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

import sv.com.aox.models.entities.Estado_Habitaciones;
import sv.com.aox.models.services.AdEstadoHabitacionesService;
@Controller
@SessionAttributes("AdEstadohabitaciones")
public class AdEstadoHabitacionesController {
	@Autowired	
	private AdEstadoHabitacionesService adestadohabitacionesService ;
	
@RequestMapping(value="/admin/estadohabitaciones", method=RequestMethod.GET)
public String listar(Map<String, Object> model) {
	System.out.println(adestadohabitacionesService.findAll());
	model.put("titulo", "Hotel Olympia");
	model.put("estadohabitaciones", adestadohabitacionesService.findAll());

	return "admin/estadohabitaciones";
}
@RequestMapping(value="/admin/estadohabitacion")
public String crear(Map<String, Object> model) {
	Estado_Habitaciones estadohabitaciones = new Estado_Habitaciones();
	model.put("estadohabitaciones", estadohabitaciones);
	model.put("title", "Formulario de Estado de Habitaciones");
	return "admin/estadohabitacion";
}
@RequestMapping(value="/admin/estadohabitacion", method=RequestMethod.POST)
public String guardar(@Valid Estado_Habitaciones estadohabitaciones, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
	if(bindingResult.hasErrors()) {
		return "/admin/estadohabitacion";
	}
	
	adestadohabitacionesService.save(estadohabitaciones);
	sessionStatus.setComplete();
	
	flash.addFlashAttribute("success","Producto creado con exito");
	return "redirect:/admin/estadohabitaciones";
}

@RequestMapping(value="admin/estadohabitacion/{id}")
public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
	Estado_Habitaciones estadohabitacion = null;
	if (id > 0) {
		estadohabitacion= adestadohabitacionesService.findOne(id);
	}else {
		flash.addFlashAttribute("error","El Id no puede ser cero");
		return "redirect:admin/estadohabitacion";
	}
	model.put("estadohabitaciones", estadohabitacion);
	model.put("title", "Editar Estado de Habitacion");
	
	return "admin/estadohabitacion";
}

@RequestMapping(value="/remo/{id}")
public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
	if (id > 0 ) {
		adestadohabitacionesService.delete(id);
	}
	flash.addFlashAttribute("success","producto eliminado con exito");
	return "redirect:/admin/estadohabitaciones";
}
}
