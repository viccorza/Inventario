package mcc.controlador;

import mcc.controlador.form.EquipoForm;
import mcc.controlador.form.ReparacionForm;
import mcc.controlador.validador.ReparacionFormValidator;
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


@Controller
@RequestMapping("reparacion")
public class ReparacionControlador {

	private static final Logger log = Logger.getLogger(ReparacionControlador.class);
	private static final String carpetaReparacion="reparacion";
	@Autowired
	ReparacionNegocio reparacionNegocio;

	@Autowired
	UsuarioNegocio usuarioNegocio;
	
	@Autowired
	ReparacionFormValidator reparacionFormValidator;
	
	@Autowired
	EquipoNegocio equipoNegocio;
	
	@RequestMapping("gestionarReparacion")
	public String gestionarReparacion(){
	
		return carpetaReparacion+"/registrarReparacion";
	}
	

	/**
	 * Realiza la busqueda de un 
	 * equipo por ID para la pagina de eliminar
	 * @param idEquipo
	 * @return
	 */
	@RequestMapping("buscarEquipoPorIdParaReparacion")
	public ModelAndView buscarEquipoPorIdParaReparacion(@RequestParam("idEquipo")String idEquipo){
		int idEquipoInt =0;
		ReparacionForm reparacionForm = new ReparacionForm();
		reparacionForm.setEquipos(null);
		try{
			 idEquipoInt =Integer.parseInt(idEquipo);
		}
		catch(NumberFormatException ex){
			reparacionForm.setEstatusBusqueda("NOTVALIDKEY");
			return new ModelAndView(carpetaReparacion+"/registrarReparacion","reparacionForm",reparacionForm);

		}
		if(idEquipo!=null && !idEquipo.trim().isEmpty() && idEquipoInt !=0){
			reparacionForm =  reparacionNegocio.buscarEquipoPorIDParaReparacion(new ReparacionForm(), idEquipoInt);
				return new ModelAndView(carpetaReparacion+"/registrarReparacion","reparacionForm",reparacionForm);
			
		}
		reparacionForm.setEstatusBusqueda("NOTFOUND");
		return new ModelAndView(carpetaReparacion+"/registrarReparacion","reparacionForm",reparacionForm);

	}
	
	@RequestMapping("confirmareparacion")
	public ModelAndView confirmareparacion(@ModelAttribute("reparacionForm") ReparacionForm reparacionForm,BindingResult bindingResult){
		log.debug("Iniciando pagina de confirmareparacion " + reparacionForm);
		reparacionFormValidator.validate(reparacionForm, bindingResult);
		if(bindingResult.hasErrors()){
			reparacionForm =  reparacionNegocio.buscarEquipoPorIDParaReparacion(new ReparacionForm(), reparacionForm.getEquipos().getIdEquipo());
			return new ModelAndView(carpetaReparacion+"/registrarReparacion","reparacionForm",reparacionForm);
		}
		else{
			reparacionForm = reparacionNegocio.confirmarReparacion(reparacionForm);
			reparacionForm.setSuccess(true);
			reparacionForm.setDescripcionSuccess("Reparacion guardada con exito");
		
			reparacionForm.setEquipos(null);
			return new ModelAndView(carpetaReparacion+"/registrarReparacion","reparacionForm",reparacionForm);
		}
	}
	
}
