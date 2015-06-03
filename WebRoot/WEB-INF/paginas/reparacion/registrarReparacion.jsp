<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,mcc.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar Reparacion</title>
<%@include file="../plantilla/estilosCSS.html" %> 
</head>
<body>
<%@include file="../plantilla/encabezado.jsp" %> 
<br />
<!-- inicia va el contenido -->
<div class="container">
		<c:if test="${reparacionForm.success==true}">
		<div class="container" >
		<div class="alert alert-success" role="alert">${reparacionForm.descripcionSuccess}</div>
		</div>				
		</c:if>
	<h2 class="bg-primary text-center">Registrar Reparación de   Equipo</h2>
	<div class="row text-center" >
	
	<div class="col-md-12">
		<form name="formbuscarporid" id="formbuscarporid" action="${pageContext.request.contextPath}/reparacion/buscarEquipoPorIdParaReparacion.html" >
			<label for="idEquipo">Clave de Equipo</label>
			<input type="text" id="idEquipo" name="idEquipo" maxlength="15" />
			<input type="submit" class="btn btn-primary  active"  value="buscar" />
				<span class="glyphicon glyphicon-search" aria-hidden="true">
			</span>
		</form>
		<br />
		<br />
	</div>
	<br />
	</div>
	<div class="row text-center">
	<c:choose>
		<c:when test="${reparacionForm.estatusBusqueda!=null &&  reparacionForm.estatusBusqueda == 'NOTFOUND'}" >
			<div class="container" >
				<div class="alert alert-warning" role="alert">No se ha encontrado información</div>
			</div>	
      	</c:when>
      	<c:when test="${reparacionForm.estatusBusqueda!=null &&  reparacionForm.estatusBusqueda == 'NOTVALIDKEY'}" >
			<div class="container" >
				<div class="alert alert-danger" role="alert">Clave no valida</div>
			</div>	
      	</c:when>
      	<c:when test="${reparacionForm.equipos!=null &&  reparacionForm.equipos.idEquipo!=0 }">
			<form:form method="post" action="${pageContext.request.contextPath}/reparacion/confirmareparacion.html"   
			modelAttribute="reparacionForm" cssClass="form-horizontal" role="form">
				<div class="row" >
				  <div id="form-registra-equipo-izquierda" class="col-md-6">
				<div class="form-group ">
					<form:label path="equipos.idEquipo" class="control-label col-md-3">Clave:
				</form:label>
				<div class="col-md-9">
				    <form:input path="equipos.idEquipo" class="form-control"  maxlength="40"  readonly="true" />
				<form:errors path="equipos.idEquipo"  cssClass="text-danger pull-left" element="div"  />
					    </div> 
					</div> 
				
				<div class="form-group ">
				<form:label path="nombreUsuarioResponsable" class="control-label col-md-3">Encargado Reparacion *:
				</form:label>
			<div class="col-md-9">
			    <form:input  path="nombreUsuarioResponsable" id="nombreUsuarioResponsable" class="form-control"  maxlength="250" />
			    
			    <form:errors path="nombreUsuarioResponsable"  cssClass="text-danger pull-left" element="div"  />
			    <span id="helpBlock" class="help-block">Busqueda por apellido.</span>
			    <form:hidden path="idNombreUsuarioResponsable" id="idNombreUsuarioResponsable" />
			    
			</div>
			</div> 
			
			<div class="form-group ">
					<form:label path="equipos.estado.estado" class="control-label col-md-3">Estado:
				</form:label>
				<div class="col-md-9">
				    <form:input path="equipos.estado.estado" class="form-control"  maxlength="40"  readonly="true"/>
				<form:errors path="equipos.estado.estado"  cssClass="text-danger pull-left" element="div"  />
					    </div> 
					</div> 
			
			</div><!-- form-registra-equipo-izquierda -->
			  <div id="form-registra-equipo-derecha" class="col-md-6">
		     <div class="form-group ">
			        <form:label path="fechaReparacionCadena" class="control-label col-sm-3">Fecha de Registro :
			        </form:label>
			        <div class="col-sm-4">
			         <form:input path="fechaReparacionCadena" class="form-control"  maxlength="40"  readonly="true"/>
					<form:errors path="fechaReparacionCadena"  cssClass="text-danger pull-left" element="div"  />
			        </div>
			    </div>
			    <div class="form-group ">
			        <form:label path="equipos.ubicacionString" class="control-label col-sm-3">Ubicacion :
			        </form:label>
			        <div class="col-sm-4">
			         <form:input path="equipos.ubicacionString" class="form-control"  maxlength="40"  readonly="true"/>
					<form:errors path="equipos.ubicacionString"  cssClass="text-danger pull-left" element="div"  />
			        </div>
			    </div>
			 </div>
				</div> <!-- row -->
				<div class="row">
		<div class="form-group ">
				<input type="submit"  class="btn btn-primary" value="Guardar" />
			
	 	</div>
	 </div>	
			</form:form>
      	</c:when>
	
	</c:choose>
	</div>
	
	
	

</div><!-- fin container -->



<!--  finaliza el contenido -->
<%@include file="../plantilla/piepagina.html" %> 
</body>
</html>