package sv.com.aox.models.services;

import java.util.List;

import sv.com.aox.models.entities.Tipo_Habitacion;

public interface AdTipoHabitacionesService {
	public List<Tipo_Habitacion> findAll();
	
	public void save(Tipo_Habitacion tipohabitacion);
	
	public Tipo_Habitacion findOne(Long id);
	
	public void delete(Long id);
}
