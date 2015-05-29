package integration.data;

import java.util.List;

import mcc.beans.Estado;
import mcc.data.EstadoDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebRoot/WEB-INF/spring-servlet.xml"})
public class EstadoDAOTestCase {

	@Autowired
	EstadoDAO estadoDAO;
	
	
	//@Test
	public void saveTestCase(){
		Estado transientInstance1 = new Estado();
		transientInstance1.setIdEstado(1);
		transientInstance1.setEstado("REGISTRADO");
		transientInstance1.setDescripcion("REGISTRADO");
		estadoDAO.save(transientInstance1);
		
		Estado transientInstance2 = new Estado();
		transientInstance2.setIdEstado(2);
		transientInstance2.setEstado("ASIGNADO");
		transientInstance2.setDescripcion("ASIGNADO");
		estadoDAO.save(transientInstance2);
		
		Estado transientInstance3 = new Estado();
		transientInstance3.setIdEstado(3);
		transientInstance3.setEstado("EN REPARACION");
		transientInstance3.setDescripcion("EN REPARACION");
		estadoDAO.save(transientInstance3);
		
	}
	
	@Test
	public void findAllTest(){
		List<Estado> estadoList = estadoDAO.findAll();
		Assert.notNull(estadoList);
	}
	
}
