package sv.com.aox.models.services;
import java.util.List;
import sv.com.aox.models.entities.Tipo_Habitacion;

public interface TipoHabitacionService {

	public List<Tipo_Habitacion> findAll();
	
	public void save(Tipo_Habitacion tipohabitaciones);
	
	public Tipo_Habitacion findOne(Long id);
	
	public void delete(Long id);
}
