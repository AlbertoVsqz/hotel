package sv.com.aox.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.aox.models.dao.IHabitacionesDao;
import sv.com.aox.models.entities.Habitaciones;



@Service
public class HabitacionesServiceImpl implements IHabitacionesService{

	@Autowired
	private IHabitacionesDao habitacionesDao;
	
	@Override
	@Transactional (readOnly=true)
	public List<Habitaciones> findAll() {
			return (List<Habitaciones>) habitacionesDao.findAll();
	}

	@Override
	@Transactional
	public void save(Habitaciones habitacion) {
		habitacionesDao.save(habitacion);
		
	}

	@Override
	@Transactional (readOnly=true)
	public Habitaciones findOne(Long id) {
		return habitacionesDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		habitacionesDao.deleteById(id);
		
	}
}
