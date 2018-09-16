package sv.com.aox.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Tipo_Ususario")
public class Tipo_Usuario implements Serializable{

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TIPO_USUARIO_SECUENCIA")
	@SequenceGenerator(name = "TIPO_USUARIO_SECUENCIA", sequenceName = "TIPO_USUARIO_SECUENCIA")
	private Long Id;
	
	@Column(name="Tipo_Usuario")
	private String Tipo_Usuario;
	
	@Column(name="Descripcion")
	private String Descripcion;
	
	@Column(name="Estado")
	private String Estado;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTipo_Usuario() {
		return Tipo_Usuario;
	}

	public void setTipo_Usuario(String tipo_Usuario) {
		Tipo_Usuario = tipo_Usuario;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
}
