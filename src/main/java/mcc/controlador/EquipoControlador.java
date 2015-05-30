package mcc.controlador;

import java.util.ArrayList;
import java.util.List;

import mcc.beans.Equipos;
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
	
    /**
     * Muestra la pantalla de gestionarEquipo
     * @return
     */
	@RequestMapping("gestionarEquipo")
	public String gestionarEquipo(){
		log.debug("Iniciando pagina de administracion de equipos");
		return carpetaEquipo+"/gestionarEquipo";
	}
	/**
	 * Muestra la pantalla de registrar Equipo
	 * @return
	 */
	@RequestMapping("registrarEquipo")
	public ModelAndView registrarEquipo(){
		log.debug("Iniciando pagina de registrarEquipo");
		EquipoForm equipoForm = equipoNegocio.iniciarPaginaRegistrarEquipo(new EquipoForm());
		return new ModelAndView(carpetaEquipo+"/registrarEquipo","equipoForm",equipoForm);
	}
	/**
	 * Guarda la informacion de un equipo
	 * @param equipoForm datos de la forma
	 * @param bindingResult en caso de que haya errores, se guardan en esta entidad
	 * @return si hay errores muestra la misma pantalla , si no, muestra gestionar equipo
	 */
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
		Equipos equipos = equipoNegocio.confirmaRegistroEquipo(equipoForm);
		return new ModelAndView(carpetaEquipo+"/gestionarEquipo","msg","Registro exitoso, id Asignado : "+equipos.getIdEquipo());
	}
	
	/**
	 * Muestra la pantalla de eliminar equipo
	 * @return
	 */
	@RequestMapping("eliminarEquipo")
	public ModelAndView eliminarEquipo(){
		log.debug("Iniciando pagina de eliminarEquipo");
		EquipoForm equipoForm = equipoNegocio.iniciarPaginaRegistrarEquipo(new EquipoForm());
		return new ModelAndView(carpetaEquipo+"/eliminarEquipo","equipoForm",null);
	}
	
	/**
	 * Muestra la pantalla de consultar equipo
	 * @return
	 */

	@RequestMapping("consultarEquipo")
	public String consultarEquipo(){
		log.debug("Iniciando pagina de consultarEquipo");
		return carpetaEquipo+"/consultarEquipo";
	}
	/**
	 * Realiza la busqueda de un 
	 * equipo por ID
	 * @param idEquipo
	 * @return
	 */
	@RequestMapping("buscarEquipoPorId")
	public ModelAndView buscarEquipoPorId(@RequestParam("idEquipo")String idEquipo){
		int idEquipoInt =0;
		try{
			 idEquipoInt =Integer.parseInt(idEquipo);
		}
		catch(NumberFormatException ex){
			return new ModelAndView(carpetaEquipo+"/eliminarEquipo","equipoForm",null);

		}
		if(idEquipo!=null && !idEquipo.trim().isEmpty() && idEquipoInt !=0){
			EquipoForm equipoForm = equipoNegocio.buscarEquipoPorID(new EquipoForm(), idEquipoInt);
				return new ModelAndView(carpetaEquipo+"/eliminarEquipo","equipoForm",equipoForm);
			
		}
		return new ModelAndView(carpetaEquipo+"/eliminarEquipo","equipoForm",null);

	}
	
	@RequestMapping("confirmaBorradoEquipo")
	public ModelAndView confirmaBorradoEquipo(@ModelAttribute("equipoForm") EquipoForm equipoForm)
	{
		equipoNegocio.confirmaBorradoEquipo(equipoForm);
		return new ModelAndView(carpetaEquipo+"/gestionarEquipo","msg","El registro con id: "+ equipoForm.getEquipos().getIdEquipo()+" ha sido borrado");

	}
	
	/**
	 * Muestra la pantalla de actualizar equipo
	 * @return
	 */
	@RequestMapping("actualizarEquipo")
	public String actualizarEquipo(){
		log.debug("Iniciando pagina de actualizarEquipos");
		return carpetaEquipo+"/actualizarEquipo";
	}
	
}
