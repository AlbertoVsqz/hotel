package sv.com.aox.models.services;

import java.util.List;

import sv.com.aox.models.entities.Estado_Habitaciones;

public interface AdEstadoHabitacionesService {
public List<Estado_Habitaciones> findAll();
	
	public void save(Estado_Habitaciones estadohabitaciones);
	
	public Estado_Habitaciones findOne(Long id);
	
	public void delete(Long id);
}
