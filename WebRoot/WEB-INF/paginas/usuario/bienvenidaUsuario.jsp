<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,mcc.*,mcc.beans.Usuario"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenida usuario</title>
<%@include file="../plantilla/estilosCSS.html" %> 
</head>
<body>

<jsp:include page="../plantilla/encabezado.jsp"/> 
<!-- inicia va el contenido -->
<div class="jumbotron">
  <div class="container">
    <h1>Bienvenido Usuario</h1>
    <p>Elige una opción</p>
  </div>
</div>
  <div class="container">
  
  
    <div class="row">
  	<c:if test="${usuarioSession.getRol().getIdRol()<=1}">
  	<div class="col-sm-2 col-md-2">
                <a  class="btn btn-default" href=" <c:url value="/usuario/gestionarUsuario.html" />" >
                	GESTIONAR USUARIOS
                    </a>
               
        </div>
     <div class="col-sm-2 col-md-2">
                          <a class="btn btn-default" href=" <c:url value="/equipo/gestionarReporte.html" />" >
                   GENERAR REPORTES 
                   </a>
               
    </div>
  	</c:if>
  	<c:if test="${usuarioSession.getRol().getIdRol()<=2}">
  	 <div class="col-sm-2 col-md-2">
                   <a class="btn btn-default" href=" <c:url value="/equipo/gestionarEquipo.html" />" >
                   GESTIONAR EQUIPOS
                  </a>  
            
        </div>
        <div class="col-sm-2 col-md-2">
                   <a class="btn btn-default" href=" <c:url value="/reparacion/gestionarReporte.html" />" >
                   REGISTRAR REPARACION
                  </a>  
                   </div>
  	</c:if>
  	<c:if test="${usuarioSession.getRol().getIdRol()<=3}">
  	  	<div class="col-sm-1 col-md-1"> </div>
  	
  		 <div class="col-sm-2 col-md-2">
         
                    <a  class="btn btn-default" href=" <c:url value="/equipo/gestionarResponsable.html" />" >
                    CONSULTAR POR RESPONSABLE
                    </a>
         
        </div>
  	</c:if>
     </div>
  </div>
  
  
<!--  finaliza el contenido -->
<%@include file="../plantilla/piepagina.html" %> 
</body>
</html>