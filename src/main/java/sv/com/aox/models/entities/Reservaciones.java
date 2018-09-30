package sv.com.aox.models.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Reservaciones")
public class Reservaciones implements Serializable{

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "RESERVACIONES_SECUENCIA")
	@SequenceGenerator(name = "RESERVACIONES_SECUENCIA", sequenceName = "RESERVACIONES_SECUENCIA")
	private Long Id;
	
	@Column(name="Id_Usuario")
	private Long Id_Usuario;
	
	private Integer N_Habitacion;
	
	@Column(name="Fecha_Llegada")
	private Date Fecha_Llegada;
	
	@Column(name="Fecha_Salida")
	private Date Fecha_Salida;
	
	@Column(name="Estado")
	private Long Estado;

	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getId_Usuario() {
		return Id_Usuario;
	}

	public void setId_Usuario(Long id_Usuario) {
		Id_Usuario = id_Usuario;
	}

	public Integer getN_Habitacion() {
		return N_Habitacion;
	}

	public void setN_Habitacion(Integer n_Habitacion) {
		N_Habitacion = n_Habitacion;
	}

	public Date getFecha_Llegada() {
		return Fecha_Llegada;
	}

	public void setFecha_Llegada(Date fecha_Llegada) {
		Fecha_Llegada = fecha_Llegada;
	}

	public Date getFecha_Salida() {
		return Fecha_Salida;
	}

	public void setFecha_Salida(Date fecha_Salida) {
		Fecha_Salida = fecha_Salida;
	}

	public Long getEstado() {
		return Estado;
	}

	public void setEstado(Long estado) {
		Estado = estado;
	}
	
	
	
}
