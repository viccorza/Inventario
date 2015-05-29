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
	
	public void confirmaRegistroEquipo(EquipoForm equipoForm){
		Usuario usuario = usuarioDAO.findById(equipoForm.getIdNombreUsuarioResponsable());
		Estado estado = estadoDAO.findById(Integer.parseInt(equipoForm.getEquipos().getEstado().getEstado()));
		Equipos equipo =  equipoForm.getEquipos();
		equipo.setUsuario(usuario);
		equipo.setEstado(estado);
		equiposDAO.save(equipo);
	}
	
	
}