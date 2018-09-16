package sv.com.aox.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Habitaciones")
public class Habitaciones implements Serializable{

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "HABITACIONES_SECUENCIA")
	@SequenceGenerator(name = "HABITACIONES_SECUENCIA", sequenceName = "HABITACIONES_SECUENCIA")
	private Long Id;
	
	@Column(name="numero")
	private Long Numero;
	
	

	//muchas facturas un cliente
	//EAGER: trae todo de una vez, toda la consulta, va a traer tambien el cliente, carga demasiado
	//LAZY: Evitar que traiga, solo hacer consulta cuando se le llama
	
	@Column(name="Id_Tipo")
	@JoinColumn()
	private Long Id_Tipo;
	
	@Column(name="Precio")
	private Double Precio;
	
	@Column(name="Caracteristicas")
	private String Caracteristicas;
	
	@Column(name="N_Piso")
	private String N_Piso;
	
	@Column(name="Capacidad")
	private Long Capacidad;
	
	@Column(name="Estado")
	private Long Estado;


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getNumero() {
		return Numero;
	}

	public void setNumero(Long numero) {
		Numero = numero;
	}

	public Long getId_Tipo() {
		return Id_Tipo;
	}

	public void setId_Tipo(Long id_Tipo) {
		Id_Tipo = id_Tipo;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	public String getCaracteristicas() {
		return Caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		Caracteristicas = caracteristicas;
	}

	public String getN_Piso() {
		return N_Piso;
	}

	public void setN_Piso(String n_Piso) {
		N_Piso = n_Piso;
	}

	public Long getCapacidad() {
		return Capacidad;
	}

	public void setCapacidad(Long capacidad) {
		Capacidad = capacidad;
	}

	public Long getEstado() {
		return Estado;
	}

	public void setEstado(Long estado) {
		Estado = estado;
	}
	
	
	
}
