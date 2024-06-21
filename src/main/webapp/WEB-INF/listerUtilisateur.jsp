<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>

<% final String APP_ROOT = request.getContextPath(); %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Utilisateurs</title>
</head>
<body>

	<h1>La liste des utilisateurs</h1>
	<hr>
	<br>
	<div>
		<a href="#"> Accueil </a> |
		<a href="<%= APP_ROOT %>/AddUser"> Ajouter utilisateur</a> |
		<a href="<%= APP_ROOT %>/ListUsers"> Lister utilisateur</a> |
		<a href="<%= APP_ROOT %>/Deconnexion"> Se deconnecter</a> 
	</div>
	<br>
	<br>
	<div id="corps">
	
		<% ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>) request.getAttribute("utilisateurs") ;%>
		<% if(utilisateurs.isEmpty()){ %>
			<p> La liste des utilisateurs est vide </p>
		<%} else {%>
			<table border="1" cellpadding="5" cellspacing="0">
			
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Login</th>
					<th>Mot de passe</th>
					<th colspan=2>Actions</th>
				</tr>
				<% for(Utilisateur utilisateur : utilisateurs){%>
					<tr>
						<td><%= utilisateur.getId()%></td>
						<td><%= utilisateur.getNom()%></td>
						<td><%= utilisateur.getPrenom()%></td>
						<td><%= utilisateur.getLogin()%></td>
						<td><%= utilisateur.getPassword()%></td>
						<td><a href="<%= APP_ROOT%>/UpdateUser?id=<%= utilisateur.getId() %>"> Modifier</a></td>
						<td><a href="<%= APP_ROOT%>/DeleteUser?id=<%= utilisateur.getId() %>" onClick="return confirm('Etes-vous sur de supprimer cet utilisateur ?')">Supprimer</a></td>
					</tr>
				<%}
			}%>
			</table>
	
	</div>
</body>
</html>