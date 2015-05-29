package mcc.controlador.form;

import java.util.Map;

public class EquipoForm {
	
	/**
     *Mapa para utilizar en un 
     *select de html, se obtiene 
     *de la base de datos 
     */
    private Map<Integer,String> estadoMap;

	public Map<Integer, String> getEstadoMap() {
		return estadoMap;
	}

	public void setEstadoMap(Map<Integer, String> estadoMap) {
		this.estadoMap = estadoMap;
	}

    
    
}
