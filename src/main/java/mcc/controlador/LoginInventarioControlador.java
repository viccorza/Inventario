package mcc.controlador;

import mcc.beans.Usuario;
import mcc.negocio.LoginInventarioNegocio;
import mcc.negocio.UsuarioNegocio;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("logininventario")
@SessionAttributes("usuarioSession")
public class LoginInventarioControlador {
	private static final Logger log = Logger.getLogger(LoginInventarioControlador.class);
	
	
	
	@ModelAttribute("usuarioSession")
	public Usuario getUsuarioSession(){
		log.debug("Creando nuevo usuario de session");
		return new Usuario();
	}
	
	private static final String carpetaUsuario="usuario";

	@Autowired
	LoginInventarioNegocio loginInventarioNegocio;
	
	@RequestMapping("mostarLoginUsuario")
	public String mostarLoginUsuario(){
		return carpetaUsuario+"/loginUsuario";
	}

	@RequestMapping(value="autenticarUsuario",method = RequestMethod.POST)
	public ModelAndView autenticarUsuarioPOST(@RequestParam("idUsuario")String idUsuarioString,
			@RequestParam("password")String password, @ModelAttribute("usuarioSession") Usuario usuarioSession )
			{
				log.debug("Entrando a login" + idUsuarioString + " "+ password);
				Integer idUsuario=0;
				boolean isValidUser=false;
				Usuario usuario =null;
				if(idUsuarioString!=null && password!=null&& !idUsuarioString.isEmpty() && !password.isEmpty())
				{
					try{
						idUsuario = Integer.parseInt(idUsuarioString);
						usuario =  loginInventarioNegocio.autenticarUsuarioPorIdUsuarioAndPassword(idUsuario,password);
						log.debug("Usuario obtenido" + usuario);
						if(usuario!=null){
							usuarioSession.setIdUsuario(usuario.getIdUsuario());
							usuarioSession.setApellido(usuario.getApellido());
							usuarioSession.setContrasena(usuario.getContrasena());
							usuarioSession.setEmail(usuario.getEmail());
							usuarioSession.setNombre(usuario.getNombre());
							usuarioSession.setRol(usuario.getRol());
							isValidUser = true;
						}

					}
					catch(NumberFormatException ex){
						log.warn("Error al convertir la cadena a entero "+ idUsuarioString);
					}
				}
				if(isValidUser){
					return new ModelAndView("redirect:/logininventario/bienvenidaUsuario.html","usuario",usuario);
				}
				else{
					return new ModelAndView(carpetaUsuario+"/loginUsuario","msg","usuario no valido");
				}
			}
	
	@RequestMapping(value="bienvenidaUsuario",method = RequestMethod.GET)
	public String bienvenidaUsuario(@ModelAttribute("usuarioSession") Usuario usuarioSession){
		if(usuarioSession==null || usuarioSession.getNombre()==null){
			return carpetaUsuario+"/accesoDenegado";
		}
		else{
			return carpetaUsuario+"/bienvenidaUsuario";
		}
	}
	
	@RequestMapping("terminarSessionUsuario")
	public ModelAndView terminarSessionUsuario(SessionStatus status){
		status.setComplete();
		return new ModelAndView(carpetaUsuario+"/loginUsuario","msg",null);
	}
}
