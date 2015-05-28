package Data;
// default package

import java.util.HashSet;
import java.util.Set;

/**
 * Rol entity. @author MyEclipse Persistence Tools
 */

public class Rol implements java.io.Serializable {

	// Fields

	private Integer idRol;
	private String nombreRol;
	private String descripcion;
	private Set usuarios = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rol() {
	}

	/** minimal constructor */
	public Rol(Integer idRol, String nombreRol, String descripcion) {
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.descripcion = descripcion;
	}

	/** full constructor */
	public Rol(Integer idRol, String nombreRol, String descripcion, Set usuarios) {
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.descripcion = descripcion;
		this.usuarios = usuarios;
	}

	// Property accessors

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set usuarios) {
		this.usuarios = usuarios;
	}

}