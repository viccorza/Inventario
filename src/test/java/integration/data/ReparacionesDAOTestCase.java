package integration.data;

import java.sql.Timestamp;
import java.util.List;

import mcc.beans.Equipos;
import mcc.beans.Reparaciones;
import mcc.beans.Usuario;
import mcc.data.EquiposDAO;
import mcc.data.ReparacionesDAO;
import mcc.data.UsuarioDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebRoot/WEB-INF/spring-servlet.xml"})
public class ReparacionesDAOTestCase {
	@Autowired
	ReparacionesDAO reparacionesDAO;
	@Autowired
	EquiposDAO equiposDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Test
	public void insertarReparacionTest(){
		
		Equipos equipos = equiposDAO.findById(4);
		Usuario usuario = usuarioDAO.findById(1);
		System.out.println(usuario);
		
		Reparaciones reparaciones = new Reparaciones();
		reparaciones.setEquipos(equipos);
		reparaciones.setPersonalSoporteIdPersonalSoporte(usuario.getIdUsuario());
	    java.util.Date date= new java.util.Date();
	    reparaciones.setUsuario(usuario);
		reparaciones.setFechaReparacion(new Timestamp(date.getTime()));
		reparacionesDAO.save(reparaciones);
	}
	
	
	@Test
	public void buscarTodosTest(){
		
		List<Reparaciones> reparacionesList = reparacionesDAO.findAll();
		for(Reparaciones reparaciones:reparacionesList){
			System.out.println(reparaciones);
		}
	}
	

}
