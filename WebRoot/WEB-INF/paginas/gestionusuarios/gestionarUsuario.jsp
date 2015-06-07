<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,mcc.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestionar Usuarios</title>
<%@include file="../plantilla/estilosCSS.html" %> 
</head>
<body>
<%@include file="../plantilla/encabezado.jsp" %> 
<br />
<!-- inicia va el contenido -->
<c:if test="${msg!=null}">
<div class="container" >
<div class="alert alert-success" role="alert">${msg}</div>
</div>				
</c:if>
 <div class="jumbotron">
      <div class="container">
        <h1 class="text-center">Gestionar Usuarios</h1>
      
      </div>
    </div>
<div class="container">
    <div class="row">
        <div class="col-sm-3 col-md-3">
            <div class="post">
                <div class="post-img-content">
                <a href=" <c:url value="/usuario/registrarUsuario.html" />" >
                    <img src="http://placehold.it/460x250/e67e22/ffffff&text=REGISTRAR USUARIO" class="img-responsive" />
                    </a>
                </div>
                
            </div>
        </div>
        <div class="col-sm-3 col-md-3">
            <div class="post">
                <div class="post-img-content">
                   <a href=" <c:url value="/usuario/eliminarUsuario.html" />" >
                    <img src="http://placehold.it/460x250/2980b9/ffffff&text=ELIMINAR USUARIO" class="img-responsive" />
                   </a>
                </div>
            </div>
        </div>
        <div class="col-sm-3 col-md-3">
            <div class="post">
                <div class="post-img-content">
                   <a href=" <c:url value="/usuario/consultarUsuario.html" />" >
                    <img src="http://placehold.it/460x250/47A447/ffffff&text=CONSULTAR USUARIO" class="img-responsive" />
                  </a>  
                </div>
            
            </div>
        </div>
          <div class="col-sm-3 col-md-3">
            <div class="post">
                <div class="post-img-content">
                    <a href=" <c:url value="/usuario/actualizarusuario.html" />" >
                   	 <img src="http://placehold.it/460x250/e67e22/ffffff&text=ACTUALIZAR USUARIO" class="img-responsive" />
                    </a>
                </div>
            
            </div>
        </div>
    </div>
</div>
<br />
<div class="container text-center">

<h2> <span class="label label-info">Elige una opción</span></h2>

</div>


<!--  finaliza el contenido -->
<%@include file="../plantilla/piepagina.html" %> 
</body>
</html>