package mcc.controlador.form;

import java.util.HashMap;
import java.util.Map;

import mcc.beans.Usuario;

public class UsuarioForm {
	
	private Usuario usuario;
	private Map<Integer,String> tipoUsuarioMap;
	
	public UsuarioForm(){
		usuario = new Usuario();
		tipoUsuarioMap= new HashMap<Integer,String>();
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Map<Integer, String> getTipoUsuarioMap() {
		return tipoUsuarioMap;
	}

	public void setTipoUsuarioMap(Map<Integer, String> tipoUsuarioMap) {
		this.tipoUsuarioMap = tipoUsuarioMap;
	}
}
