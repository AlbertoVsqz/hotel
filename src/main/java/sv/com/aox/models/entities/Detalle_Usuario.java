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
@Table(name="Detalle_usuario")
public class Detalle_Usuario implements Serializable{
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "DETALLE_USUARIO_SECUENCIA")
	@SequenceGenerator(name = "DETALLE_USUARIO_SECUENCIA", sequenceName = "DETALLE_USUARIO_SECUENCIA")
	private Long Id;
	
	@Column(name="Dui")
	private String Dui;
	
	@Column(name="Nombre")
	private String Nombre;
	
	@Column(name="Apellido")
	private String Apellido;
	
	@Column(name="Usuario")
	private String Usuario;
	
	@Column(name="Contrasena")
	private String Contrasena;
	
	@Column(name="Correo")
	private String Correo;
	
	@Column(name="Edad")
	private Long Edad;
	
	@Column(name="Telefono")
	private Long Telefono;
	
	@Column(name="Direccion")
	private String Direccion;
	
	@Column(name="Ciudad")
	private String Ciudad;
	
	@Column(name="Tipo")
	private Long Tipo;
	
	@Column(name="Estado")
	private Long Estado;

	
	
	public Detalle_Usuario() {
		super();
	}

	public Detalle_Usuario(Long id, String dui, String nombre, String apellido, String usuario, String contrasena,
			String correo, Long edad, Long telefono, String direccion, String ciudad, Long tipo, Long estado) {
		super();
		Id = id;
		Dui = dui;
		Nombre = nombre;
		Apellido = apellido;
		Usuario = usuario;
		Contrasena = contrasena;
		Correo = correo;
		Edad = edad;
		Telefono = telefono;
		Direccion = direccion;
		Ciudad = ciudad;
		Tipo = tipo;
		Estado = estado;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDui() {
		return Dui;
	}

	public void setDui(String dui) {
		Dui = dui;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public Long getEdad() {
		return Edad;
	}

	public void setEdad(Long edad) {
		Edad = edad;
	}

	public Long getTelefono() {
		return Telefono;
	}

	public void setTelefono(Long telefono) {
		Telefono = telefono;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public Long getTipo() {
		return Tipo;
	}

	public void setTipo(Long tipo) {
		Tipo = tipo;
	}

	public Long getEstado() {
		return Estado;
	}

	public void setEstado(Long estado) {
		Estado = estado;
	}
	
	
}
