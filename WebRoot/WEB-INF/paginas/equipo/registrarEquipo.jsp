<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,mcc.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar Equipo</title>
<%@include file="../plantilla/estilosCSS.html" %> 
</head>
<body>
<%@include file="../plantilla/encabezado.html" %> 
<br />
<!-- inicia va el contenido -->
<div class="container">
	<h2 class="bg-primary text-center">Registro de  Equipo</h2>
  	<form:form method="post" action="${pageContext.request.contextPath}/equipo/confirmaregistrarequipo.html"   
  	modelAttribute="equipoForm" cssClass="form-horizontal" role="form">
	<div class="row" >
	    <div id="form-registra-equipo-izquierda" class="col-md-6">
			<div class="form-group ">
				<form:label path="equipos.tipo" class="control-label col-md-3">Tipo * :
				</form:label>
				<div class="col-md-9">
				    <form:input path="equipos.tipo" class="form-control"  maxlength="40" />
				 	<form:errors path="equipos.tipo"  cssClass="text-danger pull-left" element="div"  />
			    </div> 
			</div> 
			<div class="form-group ">
	    		<form:label path="equipos.modelo" class="control-label col-md-3">Modelo * :
	    		</form:label>
		    	<div class="col-md-9">
		        	<form:input path="equipos.modelo" class="form-control"  maxlength="40" />
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
			        <form:label path="equipos.estado" class="control-label col-sm-3">Estado * :
			        </form:label>
			        <div class="col-sm-4">
			        <form:select path="equipos.estado" items="${equipoForm.estadoMap}" />
			        </div>
			    </div>
				<div class="form-group ">
					<form:label path="equipos.ubicacionString" class="control-label col-md-3">Ubicacion * :
					</form:label>
					<div class="col-md-9">
					    <form:input path="equipos.ubicacionString" class="form-control"  maxlength="40" />
						<form:errors path="equipos.ubicacionString"  cssClass="text-danger pull-left" element="div"  />
					</div> 
				</div> 
	     </div><!-- fin form-registra-equipo-derecha -->
    </div> <!-- fin row form -->
    
	<div class="row">
		<div class="form-group ">
			<div class="col-sm-4" ></div>	
			<div class="col-sm-3">
				<input type="submit"  class="btn btn-primary" value="Guardar" />
			</div>
			<div class="col-sm-3">
				<a class="btn btn-warning" href="${pageContext.request.contextPath}/equipo/gestionarEquipo.html">Cancelar</a>
			</div>
	 	</div>
	 </div>	
	</form:form>
</div> <!-- fin container -->

<!--  finaliza el contenido -->
<%@include file="../plantilla/piepagina.html" %> 
</body>
</html>