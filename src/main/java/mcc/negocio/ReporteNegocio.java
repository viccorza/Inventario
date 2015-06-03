package mcc.negocio;

import java.util.List;

import mcc.beans.Reparaciones;
import mcc.data.ReparacionesDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteNegocio {
	
	
	@Autowired
	private ReparacionesDAO reparacionesDAO;
	
	public List<Reparaciones> buscarTodasLasReparaciones(){
		return reparacionesDAO.findAll();
	}
	

}
