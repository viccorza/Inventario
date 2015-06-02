<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Sistema Inventario</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
  </head>
  
  <body>
   <!--
    you can substitue the span of reauth email for a input with the email and
    include the remember me checkbox
    -->
    <div class="container">
    <div class="row">
    <div class="col-md-3"></div>
        <div class="col-md-6">
    
        <div class="card card-container">
            <img id="profile-img" class="profile-img-card" src="http://dominiociudadano.org/wp-content/uploads/2014/11/unam.jpg" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" method="POST" action="${pageContext.request.contextPath}/logininventario/autenticarUsuario.html"  >
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" id="idUsuario" name="idUsuario" class="form-control" placeholder="Id de usuario" required autofocus>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Entrar</button>
            </form><!-- /form -->
            </div>
                <div class="col-md-3"></div>
            
            
        </div><!-- /card-container -->
        </div>
            <div class="row">
        
        <c:if test="${msg!=null}">
		<div class="container" >
		   <div class="col-md-3"></div>
			 <div class="col-md-6">
			<div class="alert alert-danger" role="alert">${msg}</div>
			</div>
			<div class="col-md-3"></div>
			
			</div>					
		</c:if>
		</div>
    </div><!-- /container -->
   
   <br>
  </body>
</html>
