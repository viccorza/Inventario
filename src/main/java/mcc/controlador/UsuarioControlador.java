package mcc.controlador;

import mcc.data.RolDAO;
import mcc.negocio.EquipoNegocio;
import mcc.negocio.ReparacionNegocio;
import mcc.negocio.UsuarioNegocio;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Clase de controlador
 * que atiende las peticiones
 * de las entidades de usuario
 * 
 *
 */


@Controller
@RequestMapping("usuario")
public class UsuarioControlador {
	
	private static final Logger log = Logger.getLogger(UsuarioControlador.class);
	
	@Autowired
	ReparacionNegocio reparacionNegocio;

	@Autowired
	UsuarioNegocio usuarioNegocio;
	
	@Autowired
	EquipoNegocio equipoNegocio;
	private static final String carpetaUsuario="usuario";
	
	
	
	
	@RequestMapping("listaUsuarios")
	public ModelAndView listarUsuarios(){
		log.debug("Entrando a listarUsuarios");
		return new ModelAndView(carpetaUsuario+"/listaUsuario","param",1);
	}
	
	


}
