package sv.com.aox.models.services;

import java.util.List;

import sv.com.aox.models.entities.Detalle_Usuario;;

public interface IDetalleUsuarioService {
	
public List<Detalle_Usuario> findAll();
	
	public void save(Detalle_Usuario detalleuser);
	
	public Detalle_Usuario findOne(Long id);
	
	public void delete(Long id);
	
	public List<Detalle_Usuario> loginusuario(String user, String pass);
	
	public List<Detalle_Usuario> registrousuario(Integer id, String dui, String nombre, String apellido, String usuario, String contrasena ,String correo,
												Integer edad, Integer telefono, String direccion, String ciudad, Integer tipo, Integer estado);
	
	public List<Detalle_Usuario> verificardui(String dui);
}
