package mcc.negocio;

import java.sql.Timestamp;
import java.util.List;

import mcc.beans.Equipos;
import mcc.beans.Estado;
import mcc.beans.Reparaciones;
import mcc.beans.Usuario;
import mcc.controlador.form.EquipoForm;
import mcc.controlador.form.ReparacionForm;
import mcc.data.EquiposDAO;
import mcc.data.EstadoDAO;
import mcc.data.ReparacionesDAO;
import mcc.data.RolDAO;
import mcc.data.UsuarioDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReparacionNegocio {

	private static final Logger log = Logger.getLogger(ReparacionNegocio.class);
	
	@Autowired
	private EquiposDAO equiposDAO;
	@Autowired
	private EstadoDAO estadoDAO;
	@Autowired
	private ReparacionesDAO reparacionesDAO;
	@Autowired
	private RolDAO rolDAO;
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Busca un equipo por id
	 * @param equipoForm contenedor de informacion del equipo
	 * @param idEquipo id del equipo a buscar
	 * @return
	 */
	public ReparacionForm buscarEquipoPorIDParaReparacion(ReparacionForm reparacionForm,int idEquipo){
		Equipos equipos = equiposDAO.findById(idEquipo);
		Estado estado =estadoDAO.findById(3);

		if(equipos==null){
			reparacionForm.setEstatusBusqueda("NOTFOUND");

		}
		else
		{
			equipos.setEstado(estado);
			reparacionForm.setEquipos(equipos);
		}
		return reparacionForm;
	}

	public ReparacionForm confirmarReparacion(ReparacionForm reparacionForm){
		Equipos equipos = equiposDAO.findById(reparacionForm.getEquipos().getIdEquipo());
		Usuario usuario = usuarioDAO.findById(equipos.getUsuario().getIdUsuario());
		Reparaciones reparaciones = new Reparaciones();
		reparaciones.setEquipos(equipos);
		reparaciones.setPersonalSoporteIdPersonalSoporte(reparacionForm.getIdNombreUsuarioResponsable());
		java.util.Date date= new java.util.Date();
	    reparaciones.setUsuario(usuario);
		reparaciones.setFechaReparacion(new Timestamp(date.getTime()));
		reparacionesDAO.save(reparaciones);
		reparacionForm.setReparaciones(reparaciones);
		return reparacionForm;
	}
	
	
}
