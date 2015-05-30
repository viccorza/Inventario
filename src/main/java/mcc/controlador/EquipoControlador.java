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
		equipoForm.setEquipos(null);
		return new ModelAndView(carpetaEquipo+"/eliminarEquipo","equipoForm",equipoForm);
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
	 * equipo por ID para la pagina de eliminar
	 * @param idEquipo
	 * @return
	 */
	@RequestMapping("buscarEquipoPorIdParaEliminar")
	public ModelAndView buscarEquipoPorIdParaEliminar(@RequestParam("idEquipo")String idEquipo){
		int idEquipoInt =0;
		EquipoForm equipoForm = new EquipoForm();
		equipoForm.setEquipos(null);
		try{
			 idEquipoInt =Integer.parseInt(idEquipo);
		}
		catch(NumberFormatException ex){
			equipoForm.setEstatusBusqueda("NOTVALIDKEY");
			return new ModelAndView(carpetaEquipo+"/eliminarEquipo","equipoForm",equipoForm);

		}
		if(idEquipo!=null && !idEquipo.trim().isEmpty() && idEquipoInt !=0){
			 equipoForm = equipoNegocio.buscarEquipoPorID(new EquipoForm(), idEquipoInt);
				return new ModelAndView(carpetaEquipo+"/eliminarEquipo","equipoForm",equipoForm);
			
		}
		equipoForm.setEstatusBusqueda("NOTFOUND");
		equipoForm.setEquipos(null);
		return new ModelAndView(carpetaEquipo+"/eliminarEquipo","equipoForm",equipoForm);

	}
	/**
	 * confirma el borrado de un equipo
	 * @param equipoForm contenedor de la informacion de equipo
	 * @return
	 */
	@RequestMapping("confirmaBorradoEquipo")
	public ModelAndView confirmaBorradoEquipo(@ModelAttribute("equipoForm") EquipoForm equipoForm)
	{
		equipoNegocio.confirmaBorradoEquipo(equipoForm);
		return new ModelAndView(carpetaEquipo+"/gestionarEquipo","msg","El registro con id: "+ equipoForm.getEquipos().getIdEquipo()+" ha sido borrado");

	}
	
	
	/**
	 * Realiza la busqueda de un 
	 * equipo por ID para la pagina de eliminar
	 * @param idEquipo
	 * @return
	 */
	@RequestMapping("buscarEquipoPorIdParaConsultar")
	public ModelAndView buscarEquipoPorIdParaConsultar(@RequestParam("idEquipo")String idEquipo){
		int idEquipoInt =0;
		EquipoForm equipoForm = new EquipoForm();
		equipoForm.setEquipos(null);
		try{
			 idEquipoInt =Integer.parseInt(idEquipo);
		}
		catch(NumberFormatException ex){
			equipoForm.setEstatusBusqueda("NOTVALIDKEY");
			return new ModelAndView(carpetaEquipo+"/consultarEquipo","equipoForm",equipoForm);

		}
		if(idEquipo!=null && !idEquipo.trim().isEmpty() && idEquipoInt !=0){
			equipoForm =  equipoNegocio.buscarEquipoPorID(new EquipoForm(), idEquipoInt);
				return new ModelAndView(carpetaEquipo+"/consultarEquipo","equipoForm",equipoForm);
			
		}
		equipoForm.setEstatusBusqueda("NOTFOUND");
		return new ModelAndView(carpetaEquipo+"/consultarEquipo","equipoForm",equipoForm);

	}
	
	/**
	 * Muestra la pantalla de actualizar equipo
	 * @return
	 */
	@RequestMapping("actualizarEquipo")
	public String actualizarEquipo(){
		return carpetaEquipo+"/actualizarEquipo";
	}
	
	/**
	 * Busca equipo por ID para la pantalla
	 * de actualizar
	 * @param idEquipo
	 * @return
	 */
	@RequestMapping("buscarEquipoPorIdParaActualizar")
	public ModelAndView buscarEquipoPorIdParaActualizar(@RequestParam("idEquipo")String idEquipo){
		log.debug("Buscando para  actualizar Equipo " + idEquipo);
		int idEquipoInt =0;
		EquipoForm equipoForm = new EquipoForm();
		equipoForm.setEquipos(null);
		try{
			 idEquipoInt =Integer.parseInt(idEquipo);
		}
		catch(NumberFormatException ex){
			equipoForm.setEstatusBusqueda("NOTVALIDKEY");
			return new ModelAndView(carpetaEquipo+"/actualizarEquipo","equipoForm",equipoForm);

		}
		if(idEquipo!=null && !idEquipo.trim().isEmpty() && idEquipoInt !=0){
			equipoForm =  equipoNegocio.buscarEquipoPorID(new EquipoForm(), idEquipoInt);
			if(equipoForm.getEquipos().getUsuario()!=null)
			{
				Usuario usuario = equipoForm.getEquipos().getUsuario();
				equipoForm.setNombreUsuarioResponsable(usuario.getNombre()+" "+usuario.getApellido());
				equipoForm.setIdNombreUsuarioResponsable(usuario.getIdUsuario());
				return new ModelAndView(carpetaEquipo+"/actualizarEquipo","equipoForm",equipoForm);
			}
		}
		equipoForm.setEstatusBusqueda("NOTFOUND");
		return new ModelAndView(carpetaEquipo+"/actualizarEquipo","equipoForm",equipoForm);
	}
	
	/**
	 * Actualiza la informacion de un equipo
	 * @param equipoForm datos de la forma
	 * @param bindingResult en caso de que haya errores, se guardan en esta entidad
	 * @return si hay errores muestra la misma pantalla , si no, muestra gestionar equipo
	 */
	@RequestMapping("confirmaactualizarequipo")
	public ModelAndView confirmaActualizarEquipo(@ModelAttribute("equipoForm") EquipoForm equipoForm,
			BindingResult bindingResult)
	{
		log.debug("-> Iniciando pagina de confirmaActualizarEquipo " + equipoForm);
		equipoFormValidator.validate(equipoForm, bindingResult);
		if(bindingResult.hasErrors()){
			equipoForm =  equipoNegocio.buscarEquipoPorID(new EquipoForm(), equipoForm.getEquipos().getIdEquipo());
			Usuario usuario = equipoForm.getEquipos().getUsuario();
			equipoForm.setNombreUsuarioResponsable(usuario.getNombre()+" "+usuario.getApellido());
			equipoForm.setIdNombreUsuarioResponsable(usuario.getIdUsuario());
			return new ModelAndView(carpetaEquipo+"/actualizarEquipo","equipoForm",equipoForm);
		}
		Equipos equipos = equipoNegocio.confirmaActualizacionEquipo(equipoForm);
		log.debug("<- Finalizando actualizacion " + equipoForm);

		return new ModelAndView(carpetaEquipo+"/gestionarEquipo","msg","Actualizacion exitosa de la clave de equipo : "+equipos.getIdEquipo());
	}
	
	
}
