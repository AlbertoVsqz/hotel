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

import sv.com.aox.models.entities.Tipo_Habitacion;
import sv.com.aox.models.services.AdTipoHabitacionesService;
@Controller
@SessionAttributes("AdTipoHabitaciones")
public class AdTipoHabitacionesController {

	@Autowired	
	private AdTipoHabitacionesService adtipohabitacionesService ;
	
@RequestMapping(value="/admin/tipohabitaciones", method=RequestMethod.GET)
public String listar(Map<String, Object> model) {
	System.out.println(adtipohabitacionesService.findAll());
	model.put("titulo", "Hotel Olympia");
	model.put("tipohabitaciones", adtipohabitacionesService.findAll());

	return "admin/tipohabitaciones";
}
@RequestMapping(value="/admin/tipohabitacion")
public String crear(Map<String, Object> model) {
	Tipo_Habitacion tipohabitacion = new Tipo_Habitacion();
	model.put("tipohabitaciones", tipohabitacion);
	model.put("title", "Formulario de Tipo de Habitaciones");
	return "admin/tipohabitacion";
}
@RequestMapping(value="/admin/tipohabitacion", method=RequestMethod.POST)
public String guardar(@Valid Tipo_Habitacion tipohabitacion, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
	if(bindingResult.hasErrors()) {
		return "/admin/tipohabitacion";
	}
	
	adtipohabitacionesService.save(tipohabitacion);
	sessionStatus.setComplete();
	
	flash.addFlashAttribute("success","Producto creado con exito");
	return "redirect:/admin/tipohabitaciones";
}

@RequestMapping(value="admin/tipohabitacion/{id}")
public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
	Tipo_Habitacion tipohabitacion = null;
	if (id > 0) {
		tipohabitacion= adtipohabitacionesService.findOne(id);
	}else {
		flash.addFlashAttribute("error","El Id no puede ser cero");
		return "redirect:admin/tipohabitacion";
	}
	model.put("tipohabitaciones", tipohabitacion);
	model.put("title", "Editar Tipo de Habitacion");
	
	return "admin/tipohabitacion";
}

@RequestMapping(value="/remov/{id}")
public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
	if (id > 0 ) {
		adtipohabitacionesService.delete(id);
	}
	flash.addFlashAttribute("success","producto eliminado con exito");
	return "redirect:/admin/tipohabitaciones";
}

}
