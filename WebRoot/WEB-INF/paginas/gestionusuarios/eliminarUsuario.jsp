<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,mcc.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eliminar Usuario</title>
<%@include file="../plantilla/estilosCSS.html" %> 
</head>
<body>
<%@include file="../plantilla/encabezado.jsp" %> 
<br />
<!-- inicia va el contenido -->
<div class="container">
	<h2 class="bg-primary text-center">Eliminar  Usuario</h2>
	<div class="row text-center" >
	
	<div class="col-md-12">
		<form name="formbuscarporid" id="formbuscarporid" action="${pageContext.request.contextPath}/usuario/buscarUsuarioPorIdParaEliminar.html" >
			<label for="idUsuario">Clave de Usuario</label>
			<input type="text" id="idUsuario" name="idUsuario" maxlength="15" />
			<input type="submit" class="btn btn-primary  active"  value="buscar" />
				<span class="glyphicon glyphicon-search" aria-hidden="true">
			</span>
		</form>
		<br />
		<br />
		
	</div>
	<br />
	</div>
	<c:choose>
		<c:when test="${usuarioForm.estatusBusqueda!=null &&  usuarioForm.estatusBusqueda == 'NOTFOUND'}" >
			<div class="container" >
				<div class="alert alert-warning" role="alert">No se ha encontrado información</div>
			</div>	
      	</c:when>
      	<c:when test="${usuarioForm.estatusBusqueda!=null &&  usuarioForm.estatusBusqueda == 'NOTVALIDKEY'}" >
			<div class="container" >
				<div class="alert alert-danger" role="alert">Clave no valida</div>
			</div>	
      	</c:when>
	 </c:choose>
	
	<!-- inicia va el contenido -->
	<c:if test="${usuarioForm.usuario!=null &&  usuarioForm.usuario.idUsuario!=0 }">
  	<form:form method="post" action="${pageContext.request.contextPath}/usuario/confirmaBorradoUsuario.html"   
  	modelAttribute="usuarioForm" cssClass="form-horizontal" role="form">
	<div class="row" >
	    <div id="form-registra-equipo-izquierda" class="col-md-6">
			<div class="form-group ">
				<form:label path="usuario.idUsuario" class="control-label col-md-3">Tipo  :
				</form:label>
				<div class="col-md-9">
				    <form:input path="usuario.idUsuario" class="form-control"  maxlength="40"  readonly="true" />
				 	<form:errors path="usuario.idUsuario"  cssClass="text-danger pull-left" element="div"  />
			    </div> 
			</div>
			<div class="form-group ">
				<form:label path="usuario.nombre" class="control-label col-md-3">Tipo  :
				</form:label>
				<div class="col-md-9">
				    <form:input path="usuario.nombre" class="form-control"  maxlength="40"  readonly="true" />
				 	<form:errors path="usuario.nombre"  cssClass="text-danger pull-left" element="div"  />
			    </div> 
			</div> 
		<div class="form-group ">
	    		<form:label path="usuario.apellido" class="control-label col-md-3">Apellido * :
	    		</form:label>
		    	<div class="col-md-9">
		        	<form:input path="usuario.apellido" class="form-control"  maxlength="40" />
		        	<form:errors path="usuario.apellido"  cssClass="text-danger pull-left" element="div"  />
		    	</div> 
			</div> 
			<div class="form-group ">
	    		<form:label path="usuario.telefono" class="control-label col-md-3">Teléfono *:
	    		</form:label>
		    	<div class="col-md-9">
		        	<form:input path="usuario.telefono" class="form-control"  maxlength="40" />
		        	<form:errors path="usuario.telefono"  cssClass="text-danger pull-left" element="div"  />
		    	</div> 
			</div> 
			<div class="form-group ">
				<form:label path="usuario.email" class="control-label col-md-3">Email* :
				</form:label>
			<div class="col-md-9">
			    <form:textarea  rows="6" path="usuario.email" class="form-control"  maxlength="250" />
			    <form:errors path="usuario.email"  cssClass="text-danger pull-left" element="div"  />
			</div>
			</div>  
		
		</div> <!--  fin form-registra-equipo-izquierda -->
	     <div id="form-registra-equipo-derecha" class="col-md-6">
		    <div class="form-group ">
				<form:label path="usuario.contrasena" class="control-label col-md-3">Email* :
				</form:label>
			<div class="col-md-9">
			    <form:input  rows="6" path="usuario.contrasena" class="form-control"  maxlength="250" type="password"/>
			    <form:errors path="usuario.contrasena"  cssClass="text-danger pull-left" element="div"  />
			</div>
			</div>
			<div class="form-group ">
		       <form:label path="usuario.rol.idRol" class="control-label col-sm-3">Tipo de Usuario * :
			   </form:label>
			   <div class="col-sm-4">
			   		<form:select path="usuario.rol.idRol" items="${usuarioForm.tipoUsuarioMap}" />
			   </div>
			 </div>

	     </div><!-- fin form-registra-equipo-derecha -->
    </div> <!-- fin row form -->
    
	<div class="row">
		<div class="form-group ">
			<div class="col-sm-4" ></div>	
			<div class="col-sm-3">
				<input type="submit"  class="btn btn-danger" value="Eliminar" />
			</div>
			<div class="col-sm-3">
				<a class="btn btn-warning" href="${pageContext.request.contextPath}/usuario/gestionarUsuario.html">Cancelar</a>
			</div>
	 	</div>
	 </div>	
	</form:form>
</c:if>
	
</div> <!-- fin container -->

<!--  finaliza el contenido -->
<%@include file="../plantilla/piepagina.html" %> 
</body>
</html>