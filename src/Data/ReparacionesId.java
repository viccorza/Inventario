package Data;
// default package

/**
 * ReparacionesId entity. @author MyEclipse Persistence Tools
 */

public class ReparacionesId implements java.io.Serializable {

	// Fields

	private Integer idReparaciones;
	private Equipos equipos;

	// Constructors

	/** default constructor */
	public ReparacionesId() {
	}

	/** full constructor */
	public ReparacionesId(Integer idReparaciones, Equipos equipos) {
		this.idReparaciones = idReparaciones;
		this.equipos = equipos;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ReparacionesId))
			return false;
		ReparacionesId castOther = (ReparacionesId) other;

		return ((this.getIdReparaciones() == castOther.getIdReparaciones()) || (this
				.getIdReparaciones() != null
				&& castOther.getIdReparaciones() != null && this
				.getIdReparaciones().equals(castOther.getIdReparaciones())))
				&& ((this.getEquipos() == castOther.getEquipos()) || (this
						.getEquipos() != null && castOther.getEquipos() != null && this
						.getEquipos().equals(castOther.getEquipos())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdReparaciones() == null ? 0 : this.getIdReparaciones()
						.hashCode());
		result = 37 * result
				+ (getEquipos() == null ? 0 : this.getEquipos().hashCode());
		return result;
	}

}