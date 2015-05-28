package mcc.beans;

import java.sql.Timestamp;

/**
 * Reparaciones entity. @author MyEclipse Persistence Tools
 */

public class Reparaciones implements java.io.Serializable {

	// Fields

	private Integer idReparaciones;
	private Equipos equipos;
	private Usuario usuario;
	private Timestamp fechaReparacion;
	private Integer personalSoporteIdPersonalSoporte;

	// Constructors

	/** default constructor */
	public Reparaciones() {
	}

	/** full constructor */
	public Reparaciones(Equipos equipos, Usuario usuario,
			Timestamp fechaReparacion, Integer personalSoporteIdPersonalSoporte) {
		this.equipos = equipos;
		this.usuario = usuario;
		this.fechaReparacion = fechaReparacion;
		this.personalSoporteIdPersonalSoporte = personalSoporteIdPersonalSoporte;
	}

	// Property accessors

	public Integer getIdReparaciones() {
		return this.idReparaciones;
	}

	public void setIdReparaciones(Integer idReparaciones) {
		this.idReparaciones = idReparaciones;
	}

	public Equipos getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Timestamp getFechaReparacion() {
		return this.fechaReparacion;
	}

	public void setFechaReparacion(Timestamp fechaReparacion) {
		this.fechaReparacion = fechaReparacion;
	}

	public Integer getPersonalSoporteIdPersonalSoporte() {
		return this.personalSoporteIdPersonalSoporte;
	}

	public void setPersonalSoporteIdPersonalSoporte(
			Integer personalSoporteIdPersonalSoporte) {
		this.personalSoporteIdPersonalSoporte = personalSoporteIdPersonalSoporte;
	}

}