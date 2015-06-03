package mcc.negocio;

import mcc.beans.Usuario;
import mcc.data.UsuarioDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginInventarioNegocio {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public Usuario autenticarUsuarioPorIdUsuarioAndPassword(Integer idUsuario,String password){
		return usuarioDAO.autenticarUsuarioPorIdUsuarioAndPassword(idUsuario,password);
	}
	

}
