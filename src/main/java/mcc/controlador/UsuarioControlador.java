package mcc.controlador;

import mcc.controlador.form.UsuarioForm;
import mcc.controlador.validador.UsuarioFormValidador;
import mcc.data.RolDAO;
import mcc.negocio.EquipoNegocio;
import mcc.negocio.ReparacionNegocio;
import mcc.negocio.UsuarioNegocio;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@Autowired
	UsuarioFormValidador usuarioFormValidador; 
	private static final String carpetaUsuario="usuario";
	
	
	
	
	@RequestMapping("gestionarUsuario")
	public ModelAndView listarUsuarios(){
		log.debug("Entrando a listarUsuarios debug ");

		return new ModelAndView(carpetaUsuario+"/gestionarUsuario","param",1);
	}
	
	@RequestMapping("registrarUsuario")
	public ModelAndView registrarUsuario(){
		UsuarioForm usuarioForm = usuarioNegocio.iniciarPaginaRegistarUsuario(new UsuarioForm());
		
		return new ModelAndView(carpetaUsuario+"/registrarUsuario","usuarioForm",usuarioForm);
	}
    
	@RequestMapping("confirmaregistrarusuario")
	public ModelAndView confirmaregistrarusuario(@ModelAttribute("usuarioForm") UsuarioForm usuarioForm,
			BindingResult bindingResult){
		log.debug(usuarioForm.getUsuario());
		
		usuarioFormValidador.validate(usuarioForm, bindingResult);
		if(bindingResult.hasErrors()){
			return new ModelAndView(carpetaUsuario+"/registrarUsuario","usuarioForm",usuarioForm);

		}
		else{
		usuarioForm = usuarioNegocio.insertaNuevoUsuario(usuarioForm);
		log.debug(usuarioForm.getUsuario());
		return new ModelAndView(carpetaUsuario+"/gestionarUsuario","msg","Registro Exitoso , el id asignado es: " +usuarioForm.getUsuario().getIdUsuario());

		}

		
	}
	
	
	
	

}