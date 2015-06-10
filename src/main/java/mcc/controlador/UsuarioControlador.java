package mcc.controlador;


import mcc.controlador.form.EquipoForm;
import mcc.controlador.form.UsuarioForm;
import mcc.controlador.validador.UsuarioFormValidador;
import mcc.negocio.EquipoNegocio;
import mcc.negocio.ReparacionNegocio;
import mcc.negocio.UsuarioNegocio;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	private static final String carpetaUsuario="gestionusuarios";
	
	
	
	
	@RequestMapping("gestionarUsuario")
	public ModelAndView listarUsuarios(){
		log.debug("Entrando a gestionar usuarios debug ");

		return new ModelAndView(carpetaUsuario+"/gestionarUsuario","param",1);
	}
	
	@RequestMapping("registrarUsuario")
	public ModelAndView registrarUsuario(){
		UsuarioForm usuarioForm = usuarioNegocio.iniciarPaginaRegistarUsuario(new UsuarioForm());
		
		return new ModelAndView(carpetaUsuario+"/registroUsuario","usuarioForm",usuarioForm);
	}
    
	@RequestMapping("confirmaregistrarusuario")
	public ModelAndView confirmaregistrarusuario(@ModelAttribute("usuarioForm") UsuarioForm usuarioForm,
			BindingResult bindingResult){
		log.debug(usuarioForm.getUsuario());
		
		usuarioFormValidador.validate(usuarioForm, bindingResult);
		if(bindingResult.hasErrors()){
			return new ModelAndView(carpetaUsuario+"/registroUsuario","usuarioForm",usuarioForm);

		}
		else{
		usuarioForm = usuarioNegocio.insertaNuevoUsuario(usuarioForm);
		log.debug(usuarioForm.getUsuario());
		return new ModelAndView(carpetaUsuario+"/gestionarUsuario","msg","Registro Exitoso , el id asignado es: " +usuarioForm.getUsuario().getIdUsuario());

		}

		
	}
	
	/**
	 * Muestra la pantalla de eliminar usuario
	 * @return
	 */
	@RequestMapping("eliminarUsuario")
	public ModelAndView eliminarEquipo(){
		log.debug("Iniciando página eliminarUsuario");
		UsuarioForm usuarioForm = usuarioNegocio.iniciarPaginaRegistarUsuario(new UsuarioForm());
		usuarioForm.setUsuario(null);
		return new ModelAndView(carpetaUsuario+"/eliminarUsuario","usuarioForm",usuarioForm);
	}
	
	/**
	 * Realiza la busqueda de un 
	 * equipo por ID para la pagina de eliminar
	 * @param idEquipo
	 * @return
	 */
	@RequestMapping("buscarUsuarioPorIdParaEliminar")
	public ModelAndView buscarUsuarioPorIdParaEliminar(@RequestParam("idUsuario")String idUsuario){
		int idUsuarioInt =0;
		UsuarioForm usuarioForm = new UsuarioForm();
		usuarioForm.setUsuario(null);
		try{
			 idUsuarioInt =Integer.parseInt(idUsuario);
		}
		catch(NumberFormatException ex){
			usuarioForm.setEstatusBusqueda("NOTVALIDKEY");
			return new ModelAndView(carpetaUsuario+"/eliminarUsuario","usuarioForm",usuarioForm);

		}
		if(idUsuario!=null && !idUsuario.trim().isEmpty() && idUsuarioInt !=0){
			 usuarioForm = usuarioNegocio.buscarUsuarioPorID(new UsuarioForm(), idUsuarioInt);
				return new ModelAndView(carpetaUsuario+"/eliminarUsuario","usuarioForm",usuarioForm);
			
		}
		usuarioForm.setEstatusBusqueda("NOTFOUND");
		usuarioForm.setUsuario(null);
		return new ModelAndView(carpetaUsuario+"/eliminarUsuario","usuarioForm",usuarioForm);

	}
	/**
	 * confirma el borrado de un usuario
	 * @param usuarioForm contenedor de la informacion de usuario
	 * @return
	 */
	@RequestMapping("confirmaBorradoUsuario")
	public ModelAndView confirmaBorradoUsuario(@ModelAttribute("usuarioForm") UsuarioForm usuarioForm)
	{
		usuarioNegocio.confirmaBorradoUsuario(usuarioForm);
		return new ModelAndView(carpetaUsuario+"/gestionarUsuario","msg","El registro con id: "+ usuarioForm.getUsuario().getIdUsuario()+" ha sido borrado");

	}
	
	/**
	 * Muestra la pantalla de consultar equipo
	 * @return
	 */

	@RequestMapping("consultarUsuario")
	public String consultarUsuario(){
		log.debug("Iniciando pagina de consultarUsuario");
		return carpetaUsuario+"/consultarUsuario";
	}
	
	/**
	 * Realiza la busqueda de un 
	 * usuario por ID
	 * @param idUsuario
	 * @return
	 */
	@RequestMapping("buscarUsuarioPorIdParaConsultar")
	public ModelAndView buscarUsuarioPorIdParaConsultar(@RequestParam("idUsuario")String idUsuario){
		int idUsuarioInt =0;
		UsuarioForm usuarioForm = new UsuarioForm();
		usuarioForm.setUsuario(null);
		try{
			 idUsuarioInt =Integer.parseInt(idUsuario);
		}
		catch(NumberFormatException ex){
			usuarioForm.setEstatusBusqueda("NOTVALIDKEY");
			return new ModelAndView(carpetaUsuario+"/consultarUsuario","usuarioForm",usuarioForm);

		}
		if(idUsuario!=null && !idUsuario.trim().isEmpty() && idUsuarioInt !=0){
			usuarioForm =  usuarioNegocio.buscarUsuarioPorID(new UsuarioForm(), idUsuarioInt);
				return new ModelAndView(carpetaUsuario+"/consultarUsuario","usuarioForm",usuarioForm);
			
		}
		usuarioForm.setEstatusBusqueda("NOTFOUND");
		return new ModelAndView(carpetaUsuario+"/consultarUsuario","usuarioForm",usuarioForm);

	}
	
	

}