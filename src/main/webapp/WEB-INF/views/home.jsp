<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Mizemply Sous Séchoir</title>
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
					<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
				<![endif]-->
		<link href="resources/bootstrap/css/login.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
		 		<div class="error">${error}</div>
				<div class="msg">${msg}</div>
		    <div class="row">
		        <div class="col-md-12">
		            <div class="wrap">
		                <p class="form-title">
		                   Mizemply sous séchoir</p>
		                <form class="login" action="<c:url value='/j_spring_security_check' />" method='POST'>
		                	<input type="text" name='username' placeholder="login" />
			                <input type="password" name="password" placeholder="Mot de passe" />
			                <input type="submit" value="Connection" class="btn btn-success btn-sm" />
			                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		                </form>
		            </div>
		        </div>
		    </div>
		</div>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>