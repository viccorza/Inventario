package mcc.controlador.validador;

import mcc.controlador.form.EquipoForm;
import mcc.controlador.form.UsuarioForm;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class UsuarioFormValidador implements Validator {
	
	
	private static final Logger log = Logger.getLogger(UsuarioFormValidador.class);

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return UsuarioFormValidador.class.isAssignableFrom(arg0);
	}

	private static final String valorRequerido="El valor es requerido";

	@Override
	public void validate(Object target, Errors errors) {
		log.debug("Entrando al validador de Equipos");
		UsuarioForm usuarioForm = (UsuarioForm)target;
		ValidationUtils.rejectIfEmpty(errors, "usuario.nombre", "errorCode",valorRequerido);

	}

}
