<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Mizemply Sous Séchoir</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta charset="UTF-8">

<!-- Bootstrap core CSS  -->
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="../bootstrap/js/dependencies/jquery-1.10.1.min.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>
<link rel="shortcut icon" href="../bootstrap/ico/icone_mairie.jpg">
<link href="../bootstrap/css/navbar.css" rel="stylesheet">
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
</style>
</head>
<body
	style="background: url(../bootstrap/ico/fond-gris.png) fixed; background-size: cover; padding: 0; margin: 0;">
	<nav class="navbar navbar-default" >
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<img
					style="min-width: 60px; height: 60px; margin-left: -2px; position: absolute; display: block;"
					src="../bootstrap/ico/logo_mairie.jpg" alt=""> <span
					class="navbar-brand application-heading">MAIRIE REGISTRY</span>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class=""><a href="accueil"><span
							class="glyphicon glyphicon-home"></span> Publier Service</a></li>
					<li class="active"><a href="accueilUpdate"> Modifier Service</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<br>
	<div class="container">
		<div class="jumbotron">
			<div class="page-header">
				<h3>
					Mise a jour du registry de la mairie de mizemply sous séchoir
				</h3>
			</div>
		</div>
	</div>
	<br>
	<div class="container">
		<div class="jumbotron">
			<c:if test="${not empty messageError}">
				<div class="error">${messageError}</div>
			</c:if>
			<c:if test="${not empty messageSucces}">
				<div class="msg">${messageSucces}</div>
			</c:if>
			<br>
			
			<form:form class="form form-horizontal" method="POST"
				action="publishUpdate">
				<fieldset>
					<legend>Identité</legend>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="organisation">Nom
							de l'organisation :*</label>
						<div class="col-sm-6">
							<input id="organisation" class="form-control" placeholder="nom"
								type="text" name="organisation" required="required" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="password">Mot
							de passe :*</label>
						<div class="col-sm-6">
							<input id="password" class="form-control" type="password"
								name="password" required="required" />
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>Mise à jour service</legend>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="date">Services</label>
						<div class="col-sm-6">
							<select id="serviceSelected" name="serviceSelected"
								class="form-control">
								<c:forEach items="${listeServices}" var="services">
									<option value="${services.nomService}">${services.nomService}</option>
								</c:forEach>
								
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="url">Nouvel url du
							service :*</label>
						<div class="col-sm-6">
							<input id="url" class="form-control" type="text" name="url"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-8 col-xs-offset-8 col-sm-6">
							<button type="submit" class="btn btn-success">Soumettre</button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>

</body>
</html>