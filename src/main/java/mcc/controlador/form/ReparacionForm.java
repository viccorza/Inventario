package mcc.controlador.form;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import mcc.beans.Equipos;
import mcc.beans.Reparaciones;

public class ReparacionForm extends EquipoForm{

	private Reparaciones reparaciones;
	
	private boolean success=false;
	private String  descripcionSuccess;
	
	public ReparacionForm(){
		this.reparaciones = new Reparaciones();
		java.util.Date date= new java.util.Date();
		reparaciones.setFechaReparacion(new Timestamp(date.getTime()));		
	}
	
	public String getFechaReparacionCadena(){
		 SimpleDateFormat simpleDateFormatFecha = 
 	            new SimpleDateFormat( "dd 'de' MMMM 'de' yyyy",new Locale("es"));
		 return simpleDateFormatFecha.format(reparaciones.getFechaReparacion().getTime());
	}

	public Reparaciones getReparaciones() {
		return reparaciones;
	}

	public void setReparaciones(Reparaciones reparaciones) {
		this.reparaciones = reparaciones;
	}

	

	public String getDescripcionSuccess() {
		return descripcionSuccess;
	}

	public void setDescripcionSuccess(String descripcionSuccess) {
		this.descripcionSuccess = descripcionSuccess;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	

}
