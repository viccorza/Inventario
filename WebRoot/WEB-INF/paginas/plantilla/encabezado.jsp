<%@  page 
import="mcc.beans.Usuario"
 %> 
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Navegacion</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Sistema de control de inventarios : 
          <% 
             Usuario usuario =(Usuario)request.getSession().getAttribute("usuarioSession");
          	if(usuario==null || usuario.getNombre()==null){
          	  response.sendRedirect
          				(request.getContextPath()+"/accesoDenegado.jsp");
          				
          		}
           
          	//Integer nombreRol = usuario.getRol().getIdRol();
             out.println(usuario.getNombre());
          %>
          
          </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" role="form">
            <a href="${pageContext.request.contextPath}/logininventario/terminarSessionUsuario.html"  class="btn btn-success">Salir</a>
          </form>
        </div><!--/.navbar-collapse -->
      </div> <!-- fin container -->
 </nav>
 
 

