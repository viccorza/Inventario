package mcc.negocio;

import java.util.List;

import mcc.beans.Equipos;
import mcc.data.EquiposDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsableNegocio {
	
	@Autowired
	private EquiposDAO equiposDAO;
	
	public List<Equipos> obtenerEquiposPorResponsable(Integer idResponsable){
		return equiposDAO.buscarTodosPorResponsable(idResponsable);
	}

}
