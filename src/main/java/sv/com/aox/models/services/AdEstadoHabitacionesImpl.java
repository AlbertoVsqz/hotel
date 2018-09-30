package sv.com.aox.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.aox.models.dao.AdEstadoHabitacionesDao;
import sv.com.aox.models.entities.Estado_Habitaciones;

@Service
public class AdEstadoHabitacionesImpl implements AdEstadoHabitacionesService{
	@Autowired
	private AdEstadoHabitacionesDao adestadohabitacionesDao;
	
	@Override
	@Transactional (readOnly=true)
	public List<Estado_Habitaciones> findAll() {
			return (List<Estado_Habitaciones>) adestadohabitacionesDao.findAll();
	}

	@Override
	@Transactional
	public void save(Estado_Habitaciones estadohabitacion) {
		adestadohabitacionesDao.save(estadohabitacion);
		
	}

	@Override
	@Transactional (readOnly=true)
	public Estado_Habitaciones findOne(Long id) {
		return adestadohabitacionesDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		adestadohabitacionesDao.deleteById(id);
		
	}
}
