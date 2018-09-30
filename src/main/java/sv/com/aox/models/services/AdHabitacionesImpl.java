package sv.com.aox.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.aox.models.dao.AdHabitacionesDao;
import sv.com.aox.models.entities.Habitaciones;

@Service
public class AdHabitacionesImpl implements AdHabitacionesService {
	
	@Autowired
	private AdHabitacionesDao adhabitacionesDao;
	
	@Override
	@Transactional (readOnly=true)
	public List<Habitaciones> findAll() {
			return (List<Habitaciones>) adhabitacionesDao.findAll();
	}

	@Override
	@Transactional
	public void save(Habitaciones habitacion) {
		adhabitacionesDao.save(habitacion);
		
	}

	@Override
	@Transactional (readOnly=true)
	public Habitaciones findOne(Long id) {
		return adhabitacionesDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		adhabitacionesDao.deleteById(id);
		
	}

}
