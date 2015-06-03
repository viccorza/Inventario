package integration.data;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import mcc.beans.Equipos;
import mcc.beans.Usuario;
import mcc.data.EquiposDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebRoot/WEB-INF/spring-servlet.xml"})
public class EquiposDAOTestCase {
	
	@Autowired
	EquiposDAO equiposDAO;
	
	@Test
	public void buscarTodosPorResponsableTest(){
		List<Equipos> equiposList = equiposDAO.buscarTodosPorResponsable(1);
		assertNotNull(equiposList);
	}

	
}
