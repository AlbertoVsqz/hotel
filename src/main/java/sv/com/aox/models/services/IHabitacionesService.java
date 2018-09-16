package sv.com.aox.models.services;

import java.util.List;

import sv.com.aox.models.entities.Habitaciones;

public interface IHabitacionesService {

	public List<Habitaciones> findAll();
	
	public void save(Habitaciones habitaciones);
	
	public Habitaciones findOne(Long id);
	
	public void delete(Long id);
	
}
