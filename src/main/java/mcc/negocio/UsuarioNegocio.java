package mcc.negocio;

import java.util.List;

import mcc.beans.Rol;
import mcc.beans.Usuario;
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
	
}