package sv.com.aox.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import sv.com.aox.models.dao.IDetalleUsuarioDao;
import sv.com.aox.models.entities.Detalle_Usuario;

@Service
public class DetalleUsuarioServiceImpl implements IDetalleUsuarioService{

	@Autowired
	private IDetalleUsuarioDao detalleusuarioDao;
	
	
	@Override
	@Transactional (readOnly=true)
	public List<Detalle_Usuario> findAll() {
			return (List<Detalle_Usuario>) detalleusuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Detalle_Usuario detalleusuario) {
		detalleusuarioDao.save(detalleusuario);
		
	}

	@Override
	@Transactional (readOnly=true)
	public Detalle_Usuario findOne(Long id) {
		return detalleusuarioDao.findById(id).orElse(null);
	}

		
	@Override
	public void delete(Long id) {
		detalleusuarioDao.deleteById(id);
		
	}
	
	@Override
	public List<Detalle_Usuario> loginusuario(String user, String psw) {
		
		return detalleusuarioDao.loginusaurio(user, psw);
		
		
		
	}

	@Override
	public List<Detalle_Usuario> registrousuario(Integer vid, String vdui, String vnombre, String vapellido, String vusuario,
			String vcontrasena, String vcorreo, Integer vedad, Integer vtelefono, String vdireccion, String vciudad, Integer vtipo, Integer vestado) {
		// TODO Auto-generated method stub
		return detalleusuarioDao.registrousuario(vid, vdui, vnombre, vapellido, vusuario, vcontrasena, vcorreo, vedad, vtelefono, vdireccion, vciudad, vtipo, vestado);
	}
		
	@Override
	public List<Detalle_Usuario> verificardui(String dui) {
		
		return detalleusuarioDao.verifydui(dui);
		
	}
		
	
	
}
