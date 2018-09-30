package sv.com.aox.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.aox.models.dao.AdTipoHabitacionesDao;
import sv.com.aox.models.entities.Tipo_Habitacion;
@Service
public class AdTipoHabitacionesImpl implements AdTipoHabitacionesService{
	@Autowired
	private AdTipoHabitacionesDao adtipohabitacionesDao;
	
	@Override
	@Transactional (readOnly=true)
	public List<Tipo_Habitacion> findAll() {
			return (List<Tipo_Habitacion>) adtipohabitacionesDao.findAll();
	}

	@Override
	@Transactional
	public void save(Tipo_Habitacion tipohabitacion) {
		adtipohabitacionesDao.save(tipohabitacion);
		
	}

	@Override
	@Transactional (readOnly=true)
	public Tipo_Habitacion findOne(Long id) {
		return adtipohabitacionesDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		adtipohabitacionesDao.deleteById(id);
		
	}
}
