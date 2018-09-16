package sv.com.aox.models.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import sv.com.aox.models.entities.Detalle_Usuario;


public interface IDetalleUsuarioDao extends CrudRepository<Detalle_Usuario, Long>{

	@Query(value="SELECT * FROM detalle_usuario WHERE usuario=?1 AND contrasena=?2",nativeQuery=true)
	List<Detalle_Usuario> loginusaurio(String user, String pass);
	
	@Query(value="INSERT INTO detalle_usuario(id, dui, nombre, apellido, usuario, contrasena, correo, edad, telefono, direccion, ciudad, tipo, estado) VALUES(null, ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12);",
				nativeQuery=true)
	List<Detalle_Usuario> registrousuario(Integer id, String dui, String nombre, String apellido, String usuario, String contrasena ,String correo,
											Integer edad, Integer telefono, String direccion, String ciudad, Integer tipo, Integer estado);
	
	@Query(value="SELECT * FROM detalle_usuario WHERE dui=?1",nativeQuery=true)
	List<Detalle_Usuario> verifydui(String dui);
	
}