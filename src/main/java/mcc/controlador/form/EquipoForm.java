package mcc.controlador.form;

import java.util.HashMap;
import java.util.Map;

import mcc.beans.Equipos;
import mcc.beans.Usuario;

public class EquipoForm {
	
	

	@Override
	public String toString() {
		return "EquipoForm [estadoMap=" + estadoMap
				+ ", nombreUsuarioResponsable=" + nombreUsuarioResponsable
				+ ", idNombreUsuarioResponsable=" + idNombreUsuarioResponsable
				+ ", equipos=" + equipos + "]";
	}
	
	private String estatusBusqueda;
	

	public String getEstatusBusqueda() {
		return estatusBusqueda;
	}






	public void setEstatusBusqueda(String estatusBusqueda) {
		this.estatusBusqueda = estatusBusqueda;
	}

	/**
     *Mapa para utilizar en un 
     *select de html, se obtiene 
     *de la base de datos 
     */
    private Map<Integer,String> estadoMap;
    
    /**
     * Atributo de usuario para
     * la captura de equipo
     */
    private String nombreUsuarioResponsable;
    
    private int idNombreUsuarioResponsable;
    
    
	public String getNombreUsuarioResponsable() {
		return nombreUsuarioResponsable;
	}






	public void setNombreUsuarioResponsable(String nombreUsuarioResponsable) {
		this.nombreUsuarioResponsable = nombreUsuarioResponsable;
	}






	public int getIdNombreUsuarioResponsable() {
		return idNombreUsuarioResponsable;
	}






	public void setIdNombreUsuarioResponsable(int idNombreUsuarioResponsable) {
		this.idNombreUsuarioResponsable = idNombreUsuarioResponsable;
	}

	/**
     * Atributo para guardar,actualizar o 
     * visualizar la informacion de 
     * un equipo
     */
    private Equipos equipos;
    
    public EquipoForm(){
    	this.estadoMap = new HashMap<Integer,String>();
    	this.equipos = new Equipos();
    	
    }
    

    
    

    
	public Equipos getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}

	public Map<Integer, String> getEstadoMap() {
		return estadoMap;
	}

	public void setEstadoMap(Map<Integer, String> estadoMap) {
		this.estadoMap = estadoMap;
	}

    
    
}
