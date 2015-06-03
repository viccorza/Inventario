<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                   Acceso Denegado</h1>
              
                <div class="error-details">
                   No tienes permisos o no haz iniciado sesion en la aplicacion.
                </div>
                <div class="error-actions">
                     <a href=" <c:url value="/index.jsp" />" > Ir a login </a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>