package mcc.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mcc.beans.Equipos;
import mcc.beans.Estado;
import mcc.beans.Usuario;
import mcc.controlador.form.EquipoForm;
import mcc.controlador.form.UsuarioAutoComplete;
import mcc.data.EquiposDAO;
import mcc.data.EstadoDAO;
import mcc.data.ReparacionesDAO;
import mcc.data.RolDAO;
import mcc.data.UsuarioDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoNegocio {
	
	private static final Logger log = Logger.getLogger(EquipoNegocio.class);
	
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
	 * inicializa los recursos para mostrar
	 * la pagina registrar equipo
	 * @return
	 */
	public EquipoForm iniciarPaginaRegistrarEquipo(EquipoForm equipoForm){
		List<Estado> estadoList = estadoDAO.findAll();
		for(Estado estado:estadoList){
			equipoForm.getEstadoMap().put(estado.getIdEstado(),estado.getEstado());
		}
		
		return equipoForm;
	}
	
	/**
	 * realiza la busqueda de usuarios por apellido
	 * utilizado por autocomplete de jquery
	 * @param apellido a buscar
	 * @return entidad para realizar un autocomplete
	 */
	public List<UsuarioAutoComplete> buscarUsuarioPorApellido(String apellido){
		List<UsuarioAutoComplete> usuarioAutoCompleteList = new ArrayList<UsuarioAutoComplete>();
		List<Usuario> usuarioList = this.usuarioDAO.buscarUsuarioPorApellido(apellido);
		for(Usuario usuario:usuarioList){
			usuarioAutoCompleteList.add(
					new UsuarioAutoComplete (usuario.getIdUsuario()+"",usuario.getNombre()+" "+usuario.getApellido()));
		}
		return usuarioAutoCompleteList ;
	}
	
	/**
	 * Inserta la informacion de un equipo
	 * @param equipoForm contenedor de informacion de equipo
	 * @return instancia ya insertada con el id asignado
	 */
	public Equipos confirmaRegistroEquipo(EquipoForm equipoForm){
		Usuario usuario = usuarioDAO.findById(equipoForm.getIdNombreUsuarioResponsable());
		Estado estado = estadoDAO.findById(equipoForm.getEquipos().getEstado().getIdEstado());
		Equipos equipo =  equipoForm.getEquipos();
		equipo.setUsuario(usuario);
		equipo.setEstado(estado);
		equiposDAO.save(equipo);
		return equipo;
	}
	/**
	 * Busca un equipo por id
	 * @param equipoForm contenedor de informacion del equipo
	 * @param idEquipo id del equipo a buscar
	 * @return
	 */
	public EquipoForm buscarEquipoPorID(EquipoForm equipoForm,int idEquipo){
		Equipos equipos = equiposDAO.findById(idEquipo);

		if(equipos==null){
			equipoForm.setEstatusBusqueda("NOTFOUND");

		}
		else
		{
			List<Estado> estadoList = estadoDAO.findAll();
			for(Estado estado:estadoList){
				equipoForm.getEstadoMap().put(estado.getIdEstado(),estado.getEstado());
			}
			
			equipoForm.setEquipos(equipos);
		}
		return equipoForm;
	}

	/**
	 * Confirma el borrado de un equipo
	 * en la base de datos
	 * @param equipoForm
	 */
	public void confirmaBorradoEquipo(EquipoForm equipoForm){
		Equipos equipos = equiposDAO.loadById(equipoForm.getEquipos().getIdEquipo());
		equiposDAO.delete(equipos);
	}
	
	
	/**
	 * Actualiza la informacion de un equipo
	 * @param equipoForm contenedor de informacion de equipo
	 * @return instancia ya actualizada con el id asignado
	 */
	public Equipos confirmaActualizacionEquipo(EquipoForm equipoForm){
		Equipos equipo =  equipoForm.getEquipos();

		//Se obtiene el equipo de la base de datos.
		Equipos currentEquipo = equiposDAO.loadById(equipo.getIdEquipo());
		//Se obtiene el usuario proveniente de la forma
		Usuario usuario = usuarioDAO.findById(equipoForm.getIdNombreUsuarioResponsable());
		//Se obtiene el estado proveniente de la forma
		Estado estado = estadoDAO.findById(equipoForm.getEquipos().getEstado().getIdEstado());
		log.debug("Estadoa a actualizar " + estado);
		//Se establecen los valores provenientes de la forma

		currentEquipo.setTipo(equipo.getTipo());
		currentEquipo.setModelo(equipo.getModelo());
		currentEquipo.setNumSerie(equipo.getNumSerie());
		currentEquipo.setMarca(equipo.getMarca());
		currentEquipo.setUsuario(usuario);
		currentEquipo.setEstado(estado);
		currentEquipo.setUbicacionString(equipo.getUbicacionString());
		log.debug("currentEquipo  " + currentEquipo);

		equiposDAO.update(currentEquipo);
		return equipo;
	}
	
}
