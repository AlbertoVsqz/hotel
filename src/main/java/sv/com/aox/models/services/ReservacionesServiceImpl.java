package sv.com.aox.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.aox.models.dao.IHabitacionesDao;
import sv.com.aox.models.dao.IReservacionesDao;
import sv.com.aox.models.entities.Habitaciones;
import sv.com.aox.models.entities.Reservaciones;

@Service
public class ReservacionesServiceImpl implements IReservacionesService{

	@Autowired
	private IReservacionesDao reservacionesDao;
	
	@Override
	@Transactional (readOnly=true)
	public List<Reservaciones> findAll() {
			return (List<Reservaciones>) reservacionesDao.findAll();
	}

	@Override
	@Transactional
	public void save(Reservaciones reservacion) {
		reservacionesDao.save(reservacion);
		
	}

	@Override
	@Transactional (readOnly=true)
	public Reservaciones findOne(Long id) {
		return reservacionesDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		reservacionesDao.deleteById(id);
		
	}
}
