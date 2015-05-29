package mcc.controlador;

import java.util.ArrayList;
import java.util.List;

import mcc.beans.Usuario;
import mcc.controlador.form.EquipoForm;
import mcc.controlador.form.UsuarioAutoComplete;
import mcc.controlador.validador.EquipoFormValidator;
import mcc.negocio.EquipoNegocio;
import mcc.negocio.ReparacionNegocio;
import mcc.negocio.UsuarioNegocio;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("equipo")
public class EquipoControlador {

	private static final Logger log = Logger.getLogger(EquipoControlador.class);
	private static final String carpetaEquipo="equipo";
	
	@Autowired
	ReparacionNegocio reparacionNegocio;

	@Autowired
	UsuarioNegocio usuarioNegocio;
	
	@Autowired
	EquipoNegocio equipoNegocio;
	
	@Autowired
	EquipoFormValidator equipoFormValidator;
	
	/**
     * Obtiene los nombres de usuarios por apellido paterno
     * @param tagName
     * @return lista con los nombres de los usuarios
     */
    
    @RequestMapping(value = "/buscarUsuario", method = RequestMethod.GET)
	@ResponseBody
	public List<UsuarioAutoComplete>  buscarUsuario(@RequestParam String apellido) {
    	log.debug("Buscando usuario por " + apellido);
    	List<UsuarioAutoComplete> usuarioAutoCompleteList = this.equipoNegocio.buscarUsuarioPorApellido(apellido);
		return usuarioAutoCompleteList;
	}
	
	@RequestMapping("gestionarEquipo")
	public String gestionarEquipo(){
		log.debug("Iniciando pagina de administracion de equipos");
		return carpetaEquipo+"/gestionarEquipo";
	}
	
	@RequestMapping("registrarEquipo")
	public ModelAndView registrarEquipo(){
		log.debug("Iniciando pagina de registrarEquipo");
		EquipoForm equipoForm = equipoNegocio.iniciarPaginaRegistrarEquipo(new EquipoForm());
		return new ModelAndView(carpetaEquipo+"/registrarEquipo","equipoForm",equipoForm);
	}
	
	@RequestMapping("confirmaregistrarequipo")
	public ModelAndView confirmaregistrarequipo(@ModelAttribute("equipoForm") EquipoForm equipoForm,
			BindingResult bindingResult)
	{
		log.debug("Iniciando pagina de confirmaregistrarequipo " + equipoForm);
		equipoFormValidator.validate(equipoForm, bindingResult);
		if(bindingResult.hasErrors()){
			equipoForm = equipoNegocio.iniciarPaginaRegistrarEquipo(equipoForm);
			return new ModelAndView(carpetaEquipo+"/registrarEquipo","equipoForm",equipoForm);
		}
		equipoNegocio.confirmaRegistroEquipo(equipoForm);
		return new ModelAndView(carpetaEquipo+"/gestionarEquipo","msg","El registro se ha guardado con exito");
	}
	
	
	@RequestMapping("eliminarEquipo")
	public String eliminarEquipo(){
		log.debug("Iniciando pagina de eliminarEquipo");
		return carpetaEquipo+"/eliminarEquipo";
	}
	
	@RequestMapping("consultarEquipo")
	public String consultarEquipo(){
		log.debug("Iniciando pagina de consultarEquipo");
		return carpetaEquipo+"/consultarEquipo";
	}
	
	@RequestMapping("actualizarEquipo")
	public String actualizarEquipo(){
		log.debug("Iniciando pagina de actualizarEquipos");
		return carpetaEquipo+"/actualizarEquipo";
	}
	
}
