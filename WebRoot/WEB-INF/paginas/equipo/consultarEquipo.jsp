<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,mcc.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consultar Equipo</title>
<%@include file="../plantilla/estilosCSS.html" %> 
</head>
<body>
<%@include file="../plantilla/encabezado.html" %> 
<br />
<!-- inicia va el contenido -->
<div class="container">
	<h2 class="bg-primary text-center">Consultar  Equipo</h2>
	<div class="row text-center" >
	
	<div class="col-md-12">
		<form name="formbuscarporid" id="formbuscarporid" action="${pageContext.request.contextPath}/equipo/buscarEquipoPorIdParaConsultar.html" >
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
      	<c:when test="${equipoForm.equipos!=null &&  equipoForm.equipos.idEquipo!=0 }">
      	<div class="row ">
			
			<table class="table table-bordered table-striped table-condensed">
				<thead>
					<tr class="success">
						<th>Clave</th>
						<th>Responsable</th>
						<th>Marca</th>
						<th>Modelo</th>
						<th>Num. Serie</th>
						<th>Ubicacion</th>
						<th>Estado</th>
					</tr>
				</thead>
				<tbody>
				<tr>
					<td>${equipoForm.equipos.idEquipo } </td>
					<td>${equipoForm.equipos.usuario.nombre}  ${equipoForm.equipos.usuario.apellido} </td>
					<td>${equipoForm.equipos.marca } </td>
					<td>${equipoForm.equipos.modelo } </td>
					<td>${equipoForm.equipos.numSerie } </td>
					<td>${equipoForm.equipos.ubicacionString } </td>
					<td>${equipoForm.equipos.estado.estado} </td>
					
				</tr>
				</tbody>
			</table>
		</div>
      	</c:when>
	
	</c:choose>
	</div>
	
		<div class="row">
		<div class="form-group ">
			<div class="col-md-12 text-center">
				<a class="btn btn-info" href="${pageContext.request.contextPath}/equipo/gestionarEquipo.html">Regresar</a>
			</div>
	 	</div>
	 </div>	
	

</div><!-- fin container -->



<!--  finaliza el contenido -->
<%@include file="../plantilla/piepagina.html" %> 
</body>
</html>