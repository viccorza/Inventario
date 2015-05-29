package mcc.controlador.form;

public class UsuarioAutoComplete {
	
public String id;
	
	
	public String tagName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public UsuarioAutoComplete(String id, String tagName) {
		this.id = id;
		this.tagName = tagName;
	}
	

	@Override
	public String toString() {
		return "TagAutoCompleteUsuario [id=" + id + ", tagName=" + tagName
				+ "]";
	}

}
