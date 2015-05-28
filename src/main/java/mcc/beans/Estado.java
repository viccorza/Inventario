package mcc.beans;

import java.util.HashSet;
import java.util.Set;

/**
 * Estado entity. @author MyEclipse Persistence Tools
 */

public class Estado implements java.io.Serializable {

	// Fields

	private Integer idEstado;
	private String estado;
	private String descripcion;
	private Set equiposes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Estado() {
	}

	/** minimal constructor */
	public Estado(String estado) {
		this.estado = estado;
	}

	/** full constructor */
	public Estado(String estado, String descripcion, Set equiposes) {
		this.estado = estado;
		this.descripcion = descripcion;
		this.equiposes = equiposes;
	}

	// Property accessors

	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getEquiposes() {
		return this.equiposes;
	}

	public void setEquiposes(Set equiposes) {
		this.equiposes = equiposes;
	}

}