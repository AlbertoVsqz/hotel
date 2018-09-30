package sv.com.aox.models.services;

import java.util.List;

import sv.com.aox.models.entities.Reservaciones;

public interface IReservacionesService {

public List<Reservaciones> findAll();
	
	public void save(Reservaciones habitaciones);
	
	public Reservaciones findOne(Long id);
	
	public void delete(Long id);
}
