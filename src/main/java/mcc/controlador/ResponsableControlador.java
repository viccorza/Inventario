package mcc.controlador;

import mcc.beans.Usuario;
import mcc.negocio.ResponsableNegocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("responsable")
public class ResponsableControlador {
	
	@Autowired
	ResponsableNegocio responsableNegocio;
	
	private static final String carpetaResponsable="responsable";
	
	@RequestMapping("gestionarResponsable")
	public ModelAndView gestionarResponsableEquipos(@RequestParam("idUsuarioString") String idUsuarioString){
		Integer idUsuario = Integer.parseInt(idUsuarioString);
		return new ModelAndView(carpetaResponsable+"/responsableEquipo","listaEquiposResponsable",responsableNegocio.obtenerEquiposPorResponsable(idUsuario));
	}

}
