package sv.com.aox.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import sv.com.aox.models.entities.Habitaciones;

public interface IHabitacionesDao extends CrudRepository<Habitaciones, Long>{

	@Query(value="SELECT  * FROM habitaciones WHERE rownum <= 6",nativeQuery=true)
	List<Habitaciones> selecthabitacion();
	
	@Query(value="SELECT  * FROM habitaciones WHERE Id_Tipo= ?1",nativeQuery=true)
	List<Habitaciones> selecthabitaciontipo(Long id);
	
}
