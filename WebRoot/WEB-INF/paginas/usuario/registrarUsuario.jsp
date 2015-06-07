<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,mcc.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar Usuario</title>
<%@include file="../plantilla/estilosCSS.html" %> 
</head>
<body>
<%@include file="../plantilla/encabezado.jsp" %> 
<br />
<!-- inicia va el contenido -->
<div class="container">
	<h2 class="bg-primary text-center">Registro de  Usuario</h2>
	<form:form method="post" action="${pageContext.request.contextPath}/usuario/confirmaregistrarusuario.html"   
  	modelAttribute="usuarioForm" cssClass="form-horizontal" role="form">
	<div class="row" >	
	<div id="form-registra-equipo-izquierda" class="col-md-12">
			<div class="form-group ">
				<form:label path="usuario.nombre" class="control-label col-md-3">Nombre * :
				</form:label>
				<div class="col-md-9">
				    <form:input path="usuario.nombre" class="form-control"  maxlength="40" />
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
				<form:label path="usuario.email" class="control-label col-md-3">Email * :
				</form:label>
				<div class="col-md-9">
				    <form:input path="usuario.email" class="form-control"  maxlength="40" />
				 	<form:errors path="usuario.email"  cssClass="text-danger pull-left" element="div"  />
			    </div> 
			</div> 
			<div class="form-group ">
				<form:label path="usuario.contrasena" class="control-label col-md-3">Password * :
				</form:label>
				<div class="col-md-9">
				    <form:input path="usuario.contrasena" class="form-control"  maxlength="40" />
				 	<form:errors path="usuario.contrasena"  cssClass="text-danger pull-left" element="div"  />
			    </div> 
			</div>
			<div class="form-group ">
				<form:label path="usuario.telefono" class="control-label col-md-3">Telefono * :
				</form:label>
				<div class="col-md-9">
				    <form:input path="usuario.telefono" class="form-control"  maxlength="40" />
				 	<form:errors path="usuario.telefono"  cssClass="text-danger pull-left" element="div"  />
			    </div> 
			</div>
			<div class="form-group ">
			        <form:label path="usuario.rol.idRol" class="control-label col-sm-3">Tipo de usuario * :
			        </form:label>
			        <div class="col-sm-4">
			        <form:select path="usuario.rol.idRol" items="${usuarioForm.tipoUsuarioMap}" />
			        </div>
			    </div>
	</div>	
	<div class="row">
		<div class="form-group ">
			<div class="col-sm-4" ></div>	
			<div class="col-sm-3">
				<input type="submit"  class="btn btn-primary" value="Guardar" />
			</div>
			<div class="col-sm-3">
				<a class="btn btn-warning" href="${pageContext.request.contextPath}/usuario/gestionarUsuario.html">Cancelar</a>
			</div>
	 	</div>
	 </div>
	
	</div> <!-- termina row -->
	</form:form> <!-- termina form -->
</div> <!-- cierra container -->
	
	
<!--  finaliza el contenido -->
<%@include file="../plantilla/piepagina.html" %> 
</body>
</html>