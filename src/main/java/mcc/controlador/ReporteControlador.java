package mcc.controlador;

import mcc.negocio.ReporteNegocio;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("reporte")
public class ReporteControlador {
	private static final Logger log = Logger.getLogger(EquipoControlador.class);
	private static final String carpetaReporte="reporte";
	@Autowired
	ReporteNegocio reporteNegocio;
	
	@RequestMapping("gestionarReporte")
	public String gestionarReporte(){
		return  carpetaReporte+"/gestionarReporte";
	}
	
	/**
     * 
     */
    @RequestMapping(value = "/generarReporte", method = RequestMethod.GET)
	public ModelAndView generarReporteExcel() {
 
		return new ModelAndView("reporteExcel", "reparacionesList",reporteNegocio.buscarTodasLasReparaciones());
	}
	
	
}
