<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,mcc.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Responsable Equipo</title>
<%@include file="../plantilla/estilosCSS.html" %> 
</head>
<body>
<%@include file="../plantilla/encabezado.jsp" %> 
<br />
<!-- inicia va el contenido -->
<div class="container">
	<h2 class="bg-primary text-center">Responsable  Equipo</h2>
	<div class="row text-center" >
	<br />
	</div>
	<div class="row text-center">
	<c:choose>
		<c:when test="${listaEquiposResponsable==null &&  listaEquiposResponsable.size() == 0}" >
			<div class="container" >
				<div class="alert alert-warning" role="alert">No se ha encontrado información</div>
			</div>	
      	</c:when>
      	<c:when test="${listaEquiposResponsable!=null &&  listaEquiposResponsable.size()!=0 }">
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
				<c:forEach items="${listaEquiposResponsable}" var="equipos" varStatus="status">
				<tr>
				
					<td>${equipos.idEquipo } </td>
					<td>${equipos.usuario.nombre}  ${equipoForm.equipos.usuario.apellido} </td>
					<td>${equipos.marca } </td>
					<td>${equipos.modelo } </td>
					<td>${equipos.numSerie } </td>
					<td>${equipos.ubicacionString } </td>
					<td>${equipos.estado.estado} </td>
					
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
      	</c:when>
	
	</c:choose>
	</div>
	
	
	

</div><!-- fin container -->



<!--  finaliza el contenido -->
<%@include file="../plantilla/piepagina.html" %> 
</body>
</html>