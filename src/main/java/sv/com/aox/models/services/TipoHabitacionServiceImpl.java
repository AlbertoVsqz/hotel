package sv.com.aox.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.aox.models.dao.ITipoHabitacionDao;
import sv.com.aox.models.entities.Tipo_Habitacion;


@Service
public class TipoHabitacionServiceImpl implements TipoHabitacionService{

	@Autowired
	private ITipoHabitacionDao tipohabitacionDao;
	
	@Override
	@Transactional (readOnly=true)
	public List<Tipo_Habitacion> findAll() {
			return (List<Tipo_Habitacion>) tipohabitacionDao.findAll();
	}

	@Override
	@Transactional
	public void save(Tipo_Habitacion tipohabitacion) {
		tipohabitacionDao.save(tipohabitacion);
		
	}

	@Override
	@Transactional (readOnly=true)
	public Tipo_Habitacion findOne(Long id) {
		return tipohabitacionDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		tipohabitacionDao.deleteById(id);
		
	}
}
