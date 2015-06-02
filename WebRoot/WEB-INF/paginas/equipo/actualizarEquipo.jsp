<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,mcc.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualizar Equipo</title>
<%@include file="../plantilla/estilosCSS.html" %> 
</head>
<body>
<%@include file="../plantilla/encabezado.jsp" %> 
<br />
<!-- inicia va el contenido -->
<div class="container">
	<h2 class="bg-primary text-center">Actualizar  Equipo</h2>
	<div class="row text-center" >
	
	<div class="col-md-12">
		<form name="formbuscarporid" id="formbuscarporid" action="${pageContext.request.contextPath}/equipo/buscarEquipoPorIdParaActualizar.html" >
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
	<c:choose>
		<c:when test="${equipoForm.estatusBusqueda!=null &&  equipoForm.estatusBusqueda == 'NOTFOUND'}" >
			<div class="container" >
				<div class="alert alert-warning" role="alert">No se ha encontrado información</div>
			</div>	
      	</c:when>
      	<c:when test="${equipoForm.estatusBusqueda!=null &&  equipoForm.estatusBusqueda == 'NOTVALIDKEY'}" >
			<div class="container" >
				<div class="alert alert-danger" role="alert">Clave no valida</div>
			</div>	
      	</c:when>
	 </c:choose>
	
	<!-- inicia va el contenido -->
	<c:if test="${equipoForm.equipos.usuario!=null &&  equipoForm.equipos.idEquipo!=0 }">
  	<form:form method="post" action="${pageContext.request.contextPath}/equipo/confirmaactualizarequipo.html"   
  	modelAttribute="equipoForm" cssClass="form-horizontal" role="form">
	<div class="row" >
	    <div id="form-registra-equipo-izquierda" class="col-md-6">
			<div class="form-group ">
				<form:label path="equipos.tipo" class="control-label col-md-3">Tipo * :
				</form:label>
				<div class="col-md-9">
				    <form:input path="equipos.tipo" class="form-control"  maxlength="40"   />
				 	<form:errors path="equipos.tipo"  cssClass="text-danger pull-left" element="div"  />
			    </div> 
			</div> 
			<div class="form-group ">
	    		<form:label path="equipos.modelo" class="control-label col-md-3">Modelo * :
	    		</form:label>
		    	<div class="col-md-9">
		        	<form:input path="equipos.modelo" class="form-control"  maxlength="40"  />
		        	<form:errors path="equipos.modelo"  cssClass="text-danger pull-left" element="div"  />
		    	</div> 
			</div> 
			<div class="form-group ">
	    		<form:label path="equipos.numSerie" class="control-label col-md-3">Num Serie *:
	    		</form:label>
		    	<div class="col-md-9">
		        	<form:input path="equipos.numSerie" class="form-control"  maxlength="40" />
		        	<form:errors path="equipos.numSerie"  cssClass="text-danger pull-left" element="div"  />
		    	</div> 
			</div> 
			<div class="form-group ">
				<form:label path="equipos.marca" class="control-label col-md-3">Marca * :
				</form:label>
			<div class="col-md-9">
			    <form:textarea  rows="6" path="equipos.marca" class="form-control"  maxlength="250" />
			    <form:errors path="equipos.marca"  cssClass="text-danger pull-left" element="div"  />
			</div>
			</div> 
			<div class="form-group ">
				<form:label path="nombreUsuarioResponsable" class="control-label col-md-3">Usuario Responsable *:
				</form:label>
			<div class="col-md-9">
			    <form:input  path="nombreUsuarioResponsable" id="nombreUsuarioResponsable" class="form-control"  maxlength="250" />
			    
			    <form:errors path="nombreUsuarioResponsable"  cssClass="text-danger pull-left" element="div"  />
			    <span id="helpBlock" class="help-block">Busqueda por apellido.</span>
			    <form:hidden path="idNombreUsuarioResponsable" id="idNombreUsuarioResponsable" />
			    
			</div>
			</div> 
		
			
	
	    </div> <!--  fin form-registra-equipo-izquierda -->
	     <div id="form-registra-equipo-derecha" class="col-md-6">
		     <div class="form-group ">
			        <form:label path="equipos.estado.idEstado" class="control-label col-sm-3">Estado * :
			        </form:label>
			        <div class="col-sm-4">
			        <form:select path="equipos.estado.idEstado" items="${equipoForm.estadoMap}" />
			        </div>
			    </div>
				<div class="form-group ">
					<form:label path="equipos.ubicacionString" class="control-label col-md-3">Ubicacion *:
					</form:label>
					<div class="col-md-9">
					    <form:input path="equipos.ubicacionString" class="form-control"  maxlength="40"   />
						<form:errors path="equipos.ubicacionString"  cssClass="text-danger pull-left" element="div"   />
					</div> 
				</div> 
				<div class="form-group ">
					<form:label path="equipos.idEquipo" class="control-label col-md-3">Clave Equipo :
					</form:label>
					<div class="col-md-9">
					    <form:input path="equipos.idEquipo" class="form-control"  maxlength="40"  readonly="true" />
						<form:errors path="equipos.idEquipo"  cssClass="text-danger pull-left" element="div"   />
					</div> 
				</div> 
	     </div><!-- fin form-registra-equipo-derecha -->
    </div> <!-- fin row form -->
    
	<div class="row">
		<div class="form-group ">
			<div class="col-sm-4" ></div>	
			<div class="col-sm-3">
				<input type="submit"  class="btn btn-info" value="Actualizar" />
			</div>
			<div class="col-sm-3">
				<a class="btn btn-warning" href="${pageContext.request.contextPath}/equipo/gestionarEquipo.html">Cancelar</a>
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