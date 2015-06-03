package mcc.controlador.validador;

import mcc.controlador.form.EquipoForm;
import mcc.controlador.form.ReparacionForm;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ReparacionFormValidator implements Validator {
	
	
	private static final Logger log = Logger.getLogger(ReparacionFormValidator.class);

	private static final String valorRequerido="El valor es requerido";
	@Override
	public boolean supports(Class<?> arg0) {
		return ReparacionFormValidator.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object target, Errors errors) {
		log.debug("Entrando al validador de Equipos");
		ReparacionForm reparacionForm = (ReparacionForm)target;
		ValidationUtils.rejectIfEmpty(errors, "nombreUsuarioResponsable", "errorCode",valorRequerido);
		

	}

	
}
