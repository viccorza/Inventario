package mcc.controlador.validador;


import mcc.controlador.form.EquipoForm;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EquipoFormValidator implements Validator {
	
	
	private static final Logger log = Logger.getLogger(EquipoFormValidator.class);

	private static final String valorRequerido="El valor es requerido";
	@Override
	public boolean supports(Class<?> arg0) {
		return EquipoFormValidator.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object target, Errors errors) {
		log.debug("Entrando al validador de Equipos");
		EquipoForm equipoForm = (EquipoForm)target;
		ValidationUtils.rejectIfEmpty(errors, "equipos.tipo", "errorCode",valorRequerido);
		ValidationUtils.rejectIfEmpty(errors, "equipos.modelo", "errorCode",valorRequerido);
		ValidationUtils.rejectIfEmpty(errors, "equipos.numSerie", "errorCode",valorRequerido);
		ValidationUtils.rejectIfEmpty(errors, "equipos.marca", "errorCode",valorRequerido);
		ValidationUtils.rejectIfEmpty(errors, "nombreUsuarioResponsable", "errorCode",valorRequerido);
		ValidationUtils.rejectIfEmpty(errors, "equipos.estado", "errorCode",valorRequerido);
		ValidationUtils.rejectIfEmpty(errors, "equipos.ubicacionString", "errorCode",valorRequerido);
		ValidationUtils.rejectIfEmpty(errors, "idNombreUsuarioResponsable", "errorCode",valorRequerido);
		if(equipoForm.getIdNombreUsuarioResponsable()<=0){
			errors.rejectValue("nombreUsuarioResponsable", "nombreUsuarioResponsable","Debe ser un usuario Valido");

		}
	}

	
}
