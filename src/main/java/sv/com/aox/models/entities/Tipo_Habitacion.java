package sv.com.aox.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="Tipo_Habitacion")
public class Tipo_Habitacion implements Serializable{

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TIPO_HABITACION_SECUENCIA")
	@SequenceGenerator(name = "TIPO_HABITACION_SECUENCIA", sequenceName = "TIPO_HABITACION_SECUENCIA")
	private Long Id;
	
	@Column(name="Tipo")
	private String Tipo;
	
	@Column(name="Descripcion")
	private String Descripcion;
	
	//en la tabla facturas va a crear cliente id para relacionar ambas tablas
		@OneToMany(mappedBy="Id_Tipo", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
		private List<Habitaciones> habitaciones;
		
		public Tipo_Habitacion() {
			habitaciones= new ArrayList<Habitaciones>();
		}
		
		
	public List<Habitaciones> getHabitaciones() {
			return habitaciones;
		}


		public void setHabitaciones(List<Habitaciones> habitaciones) {
			this.habitaciones = habitaciones;
		}
		
		public void addHabitaciones(Habitaciones habita) {
			this.habitaciones.add(habita);
		}
		

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	

}
