package mcc.negocio;

import java.util.List;

import mcc.beans.Estado;
import mcc.controlador.form.EquipoForm;
import mcc.data.EquiposDAO;
import mcc.data.EstadoDAO;
import mcc.data.ReparacionesDAO;
import mcc.data.RolDAO;
import mcc.data.UsuarioDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que realizar el negocio
 * para los usuarios
 * @author
 *
 */
@Service
public class UsuarioNegocio {


	@Autowired
	private EquiposDAO equiposDAO;
	@Autowired
	private EstadoDAO estadoDAO;
	@Autowired
	private ReparacionesDAO reparacionesDAO;
	@Autowired
	private RolDAO rolDAO;
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	private static final Logger log = Logger.getLogger(UsuarioNegocio.class);
	
	/**
	 * inicializa los recursos para mostrar
	 * la pagina registrar usuario
	 * @return
	 */
	/*public UsuarioForm iniciarPaginaRegistrarUsuario(UsuarioForm usuarioForm){
		List<Estado> estadoList = estadoDAO.findAll();
		for(Estado estado:estadoList){
			equipoForm.getEstadoMap().put(estado.getIdEstado(),estado.getEstado());
		}
		
		return equipoForm;
	}*/
}
