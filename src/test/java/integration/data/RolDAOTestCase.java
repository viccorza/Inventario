package integration.data;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;
import mcc.beans.Rol;
import mcc.data.RolDAO;

import org.junit.Before;
import org.junit.Test;



public class RolDAOTestCase {

	private RolDAO rolDAO;
	@Before
	public void setup()
	{
		rolDAO =  new RolDAO();
		
	}
	/**
	 * Se espera que sea exitoso
	 */
	//@Test
	public void saveSucces(){
		Rol rol = new Rol();
		rol.setNombreRol("CAPTURISTA");
		rol.setDescripcion("ROL DE CAPTURISTA");
		//Si no manda excepcion, guardo exitosamente
		rolDAO.save(rol);
	}
	
	/**
	 * Se espera que mande una excepcion
	 * por que se manda un atributo nulo
	 * 
	 */
	
	//@Test(expected=Exception.class)
	public void saveFail(){
		Rol rol = new Rol();
		rol.setNombreRol("CAPTURISTA");
		rol.setDescripcion(null);
		//DEBE  mandar  una excepcion
		rolDAO.save(rol);
	}

	
	@Test
	public void findAllTest(){
		List<Rol> rolDAOList = rolDAO.findAll();
		assertNotNull(rolDAOList);
		
	}
	
	
	@Test
	public void findById(){
		Rol rol = rolDAO.findById(3);
		assertNotNull(rol);
		
	}
}
