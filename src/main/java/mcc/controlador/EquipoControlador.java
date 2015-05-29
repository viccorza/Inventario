package mcc.controlador;

import mcc.negocio.EquipoNegocio;
import mcc.negocio.ReparacionNegocio;
import mcc.negocio.UsuarioNegocio;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("gestionarEquipo")
	public String gestionarEquipo(){
		log.debug("Iniciando pagina de administracion de equipos");
		return carpetaEquipo+"/gestionarEquipo";
	}
	
}
