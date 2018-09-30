package sv.com.aox.controllers;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sv.com.aox.models.entities.Detalle_Usuario;
import sv.com.aox.models.entities.Habitaciones;
import sv.com.aox.models.entities.Reservaciones;
import sv.com.aox.models.entities.Tipo_Habitacion;
import sv.com.aox.models.services.IHabitacionesService;
import sv.com.aox.models.services.IReservacionesService;
import sv.com.aox.models.services.TipoHabitacionService;

@Controller
@SessionAttributes("reserva")

public class ReservaController {
	
	@Autowired	
	private IHabitacionesService habitacionesService ;

	@Autowired
	private TipoHabitacionService tipohabitacionService;


	@Autowired
	private IReservacionesService reservacionService;
	
	@RequestMapping(value="/reserva/{id}")
	public String findById(Map<String, Object> model, @PathVariable Long id, Model modelo) {
		//System.out.print(id);
		Habitaciones habitacion = habitacionesService.findOne(id);
		Tipo_Habitacion tipo = tipohabitacionService.findOne(habitacion.getId_Tipo());
		model.put("habitaciones", habitacion);
		model.put("tipos", tipo);
		//System.out.print("hola"+habitacion);
		//return "redirect:/reserva";
		return "reserva";
	
	}
	@RequestMapping(value ="/reserva", method = RequestMethod.GET)
	public String showReservaForm() {
		return "reserva";
	}
	
	@RequestMapping(value ="reserva/ponreserva", method = RequestMethod.POST)
	public String guardar(@Valid Reservaciones reservacionv, Map<String, Object> modelo,HttpSession session, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus, Model model,@RequestParam String Id_Usuario) {
		System.out.println(Id_Usuario);
		if(Id_Usuario.isEmpty()) {
			flash.addFlashAttribute("error","NECESITA INICIAR SESSION PRIMERO PARA PODER RESERVAR");
			return "redirect:/login";
			
		}else {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.hasErrors());
			flash.addFlashAttribute("error","HA OCURRIDO UN PROBLEMA");
			modelo.put("errores", bindingResult);
			return "/reserva";
		}else {
		
		reservacionService.save(reservacionv);
		sessionStatus.setComplete();
		flash.addFlashAttribute("success","SU RESERVA SE HA REALIZADO CORRECTAMENTE");
		return "redirect:/";
		}
		}
	}
	
}
