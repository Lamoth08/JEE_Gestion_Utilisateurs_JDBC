<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<% final String APPROOT = request.getContextPath(); %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title> Gestion des utilisateurs </title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
		
	</head>
	<body>
	
	<h1>Gestion des utilisateurs</h1>
	<hr>
	<br>
	
	<div>
		| <a href="#"> Accueil </a> |
		  <a href="<%= APPROOT %>/AddUser"> Ajouter utilisateur</a> |
		  <a href="<%= APPROOT %>/ListUsers"> Lister les utilisateurs</a> |		  
		  <a href="<%= APPROOT %>/Deconnexion"> Se deconnecter</a> |
	</div>
	<br>
	<br> 
	<hr>
	
	<c:choose>
		<c:when test="${ status == true }">
			<div class="alert alert-success"> ${ statusMessage } </div>
		</c:when>
		<c:when test="${ status == false }">
			<div class="alert alert-danger"> ${ statusMessage } </div>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	<!-- <div class="alert alert-${ status ? 'success' : 'danger' }"> ${ statusMessage } </div> -->
		
		<div class="container mt-5 pt-5)">
			<div class="row">
				<div class="col-9 m-auto">
					<div class="card">
						<div class="card-body">
							<form action="AddUser" method="post">
								<fieldset>
									<legend class="text-center">Ajouter nouvel utilisateur</legend>
									<div>
										<label for="nom"> Nom</label>
										<input type="text" name="nom" id="nom" value="${ utilisateur.nom }"/><br> <br>
										<span class=${ status ? 'succes' : 'echec' }>${ erreurs.nom }</span>
									</div>
									
									<div>
										<label for="prenom"> Prenom</label>
										<input type="text" name="prenom" id="prenom" value="${ utilisateur.prenom }"/><br> <br>
										<span class=${ status ? 'succes' : 'echec' }>${ erreurs.prenom }</span>
									</div>
									
									<div>
										<label for="login"> Login</label>
										<input type="text" name="login" id="login" value="${ utilisateur.login}" /><br> <br>
										<span class=${ status ? 'succes' : 'echec' }>${ erreurs.login }</span>
									</div>
									
									<div>
										<label for="password"> Password</label>
										<input type="password" name="password" id="password" /><br> <br>
										<span class=${ status ? 'succes' : 'echec' }>${ erreurs.password }</span>
									</div>
									
									<div>
										<label for="passwordBis"> Password (Confirmation)</label>
										<input type="password" name="passwordBis" id="passwordBis" /><br> <br>
										<span class=${ status ? 'succes' : 'echec' }>${erreurs.passwordBis }</span>
									</div>
									
									<input type="submit" value="Ajouter" class="btn btn-primary"/>
									
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		
		</div>
		
	</body>
</html>