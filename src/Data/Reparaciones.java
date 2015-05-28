package Data;
// default package

import java.sql.Timestamp;

/**
 * Reparaciones entity. @author MyEclipse Persistence Tools
 */

public class Reparaciones implements java.io.Serializable {

	// Fields

	private ReparacionesId id;
	private Usuario usuario;
	private Timestamp fechaReparacion;
	private Integer personalSoporteIdPersonalSoporte;

	// Constructors

	/** default constructor */
	public Reparaciones() {
	}

	/** full constructor */
	public Reparaciones(ReparacionesId id, Usuario usuario,
			Timestamp fechaReparacion, Integer personalSoporteIdPersonalSoporte) {
		this.id = id;
		this.usuario = usuario;
		this.fechaReparacion = fechaReparacion;
		this.personalSoporteIdPersonalSoporte = personalSoporteIdPersonalSoporte;
	}

	// Property accessors

	public ReparacionesId getId() {
		return this.id;
	}

	public void setId(ReparacionesId id) {
		this.id = id;
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