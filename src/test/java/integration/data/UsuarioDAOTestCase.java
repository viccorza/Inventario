package integration.data;

import static org.junit.Assert.*;
import mcc.beans.Rol;
import mcc.beans.Usuario;
import mcc.data.RolDAO;
import mcc.data.UsuarioDAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebRoot/WEB-INF/spring-servlet.xml"})
public class UsuarioDAOTestCase {
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	RolDAO rolDAO;
	
	@Test
	public void findAllTest(){
		Rol rol = rolDAO.findById(3);
		//for(int i=0 ; i<5;i++){
		int i =100;
		Usuario usuario = new Usuario();
		usuario.setNombre("nombre");
		usuario.setApellido("apellido");
		usuario.setTelefono("554323"+i+""+i);
		usuario.setEmail("usuario"+i+"@yahoo.com.mx");
		usuario.setContrasena("secret"+i);
		usuario.setRol(rol);
		usuarioDAO.save(usuario);
		System.out.println(usuario.getIdUsuario());
		//}
	}
	
	@Test
	public void autenticarUsuarioPorIdUsuarioAndPasswordTest(){
		Usuario usuario = usuarioDAO.autenticarUsuarioPorIdUsuarioAndPassword(1,"secret0");
		assertNotNull(usuario);
		
	}

}
