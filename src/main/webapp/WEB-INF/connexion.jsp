<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>Page de connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
 
</head>
<body>
		<div class="container mt-5 pt-5">
		<div class="row">
			<div class="col-12 col-sm-8 col-md-6 m-auto">
				<div class="card border-0 shadow">
					<div class="card-body">			 
						<form action="Authentification" method="post">
							<fieldset>
								<legend class="text-center">Connexion</legend>
								
								<div class="pt-3">
									<!-- <label for="identifiant" class="form-control-label"> Nom d'utilisateur</label>  -->
									<input type="text" class="form-control " name="identifiant" placeholder="Nom d'utilisateur"/> <br/><br/>
								</div>
								
								<div class="pt-3">
									<!-- <label for="pssword"> Mot de passe</label>  -->
									<input type="password" class="form-control " name="pssword" placeholder="Mot de passe"/> <br/><br/>
								</div>
								
								<div class="text-center mb-3 ">
									<input type="submit" value="Se connecter" class="btn btn-primary" />
								</div>
								
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>