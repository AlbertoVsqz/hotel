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
@Table(name="Estado_Reservacion")
public class Estado_Reservacion implements Serializable{

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ESTADO_RESERVACION_SECUENCIA")
	@SequenceGenerator(name = "ESTADO_RESERVACION_SECUENCIA", sequenceName = "ESTADO_RESERVACION_SECUENCIA")
	private Long Id;
	
	@Column(name="Estado")
	private String Estado;
	
	@Column(name="Descripcion")
	private String Descripcion;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
}
