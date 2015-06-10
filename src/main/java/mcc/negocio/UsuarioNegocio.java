package mcc.negocio;

import java.util.List;

import mcc.beans.Equipos;
import mcc.beans.Estado;
import mcc.beans.Rol;
import mcc.beans.Usuario;
import mcc.controlador.form.EquipoForm;
import mcc.controlador.form.UsuarioForm;
import mcc.data.EquiposDAO;
import mcc.data.EstadoDAO;
import mcc.data.ReparacionesDAO;
import mcc.data.RolDAO;
import mcc.data.UsuarioDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que realizar el negocio
 * para los usuarios
 * @author
 *
 */
@Service
public class UsuarioNegocio {


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
	
	
	private static final Logger log = Logger.getLogger(UsuarioNegocio.class);
	
	@SuppressWarnings("unchecked")
	public UsuarioForm iniciarPaginaRegistarUsuario(UsuarioForm usuarioForm){
		List<Rol> rolList = rolDAO.findAll();
		for(Rol rol:rolList){
			usuarioForm.getTipoUsuarioMap().put(rol.getIdRol(), rol.getNombreRol());
			
		}
    	
    		return usuarioForm;
    }	
	
	public UsuarioForm insertaNuevoUsuario(UsuarioForm usuarioForm){
		Rol rol = rolDAO.findById(usuarioForm.getUsuario().getRol().getIdRol());
		Usuario usuario = usuarioForm.getUsuario();
		usuario.setRol(rol);
		usuarioDAO.save(usuario);
		usuarioForm.setUsuario(usuario);
		return usuarioForm;
	}
	
	/**
	 * Busca un usuario por id
	 * @param usuarioForm contenedor de informacion del equipo
	 * @param idUsuario id del usuario a buscar
	 * @return
	 */
	public UsuarioForm buscarUsuarioPorID(UsuarioForm usuarioForm,int idUsuario){
		Usuario usuario = usuarioDAO.findById(idUsuario);

		if(usuario==null){
			usuarioForm.setEstatusBusqueda("NOTFOUND");

		}
		else
		{
			@SuppressWarnings("unchecked")
			List<Rol> rolList = rolDAO.findAll();
			for(Rol rol:rolList){
				usuarioForm.getTipoUsuarioMap().put(rol.getIdRol(), rol.getNombreRol());
				
			}
			
			usuarioForm.setUsuario(usuario);
		}
		return usuarioForm;
	}

	/**
	 * Confirma el borrado de un usuario
	 * en la base de datos
	 * @param equipoForm
	 */
	public void confirmaBorradoUsuario(UsuarioForm usuarioForm){
		//Usuario usuario = usuarioDAO.loadById(usuarioForm.getUsuario().getIdUsuario());
		Usuario usuario = usuarioDAO.findById(usuarioForm.getUsuario().getIdUsuario());
		usuarioDAO.delete(usuario);
	}
	
}