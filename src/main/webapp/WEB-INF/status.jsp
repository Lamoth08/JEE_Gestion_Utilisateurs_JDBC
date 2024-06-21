<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Statut de connexion</title>
	</head>
	<body>
			<h1> Bienvenue à la page d'accueil</h1>
				<% String msg = (String) request.getAttribute("message"); %>
				<p> <%= msg %> </p>
		
	</body>
</html>