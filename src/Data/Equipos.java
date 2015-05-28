package Data;
// default package

import java.util.HashSet;
import java.util.Set;

/**
 * Equipos entity. @author MyEclipse Persistence Tools
 */

public class Equipos implements java.io.Serializable {

	// Fields

	private Integer idEquipo;
	private Estado estado;
	private Usuario usuario;
	private String numSerie;
	private String modelo;
	private String marca;
	private String ubicación;
	private String tipo;
	private Set reparacioneses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Equipos() {
	}

	/** minimal constructor */
	public Equipos(Integer idEquipo, Estado estado, Usuario usuario,
			String numSerie, String modelo, String marca, String ubicación,
			String tipo) {
		this.idEquipo = idEquipo;
		this.estado = estado;
		this.usuario = usuario;
		this.numSerie = numSerie;
		this.modelo = modelo;
		this.marca = marca;
		this.ubicación = ubicación;
		this.tipo = tipo;
	}

	/** full constructor */
	public Equipos(Integer idEquipo, Estado estado, Usuario usuario,
			String numSerie, String modelo, String marca, String ubicación,
			String tipo, Set reparacioneses) {
		this.idEquipo = idEquipo;
		this.estado = estado;
		this.usuario = usuario;
		this.numSerie = numSerie;
		this.modelo = modelo;
		this.marca = marca;
		this.ubicación = ubicación;
		this.tipo = tipo;
		this.reparacioneses = reparacioneses;
	}

	// Property accessors

	public Integer getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNumSerie() {
		return this.numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getUbicación() {
		return this.ubicación;
	}

	public void setUbicación(String ubicación) {
		this.ubicación = ubicación;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set getReparacioneses() {
		return this.reparacioneses;
	}

	public void setReparacioneses(Set reparacioneses) {
		this.reparacioneses = reparacioneses;
	}

}