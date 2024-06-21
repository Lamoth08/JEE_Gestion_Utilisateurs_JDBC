package forms;

import java.sql.SQLTimeoutException;
import java.util.HashMap;
import java.util.Map;

import beans.Utilisateur;
import dao.DatabaseDao;
import dao.UtilisateurDao;
import jakarta.servlet.http.HttpServletRequest;

public class AddUserForm {

	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	
	private static final String EMPTY_FIELD_ERROR_MSG = "Vous devez renseigner ce champ !";
	private static final String UNMATCHED_PASSWORD_ERROR_MSG = "Les deux mot de passe ne correspondent pas !";
	
	private HttpServletRequest request;
	private Map<String, String> erreurs ;
	private Boolean status ;
	private String statusMessage ;
	private Utilisateur utilisateur ;
	private DatabaseDao db = new DatabaseDao();
	
	public AddUserForm(HttpServletRequest request) {
		this.request = request ;
		this.erreurs = new HashMap<String, String>();
	}
	
	public boolean ajouter() {
		
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);
		//String passwordBis = getParameter(CHAMP_PASSWORD_BIS);
		
		Utilisateur utilisateur = new Utilisateur(nom, prenom, login, password);
		
		validerChamps(CHAMP_NOM,CHAMP_PRENOM,CHAMP_LOGIN,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		validerPassword();
		
		if(erreurs.isEmpty()) {
			this.status = true ;
			this.statusMessage = "Success : L'enregistrement a bien été effectué !";
			db.ajouterUtilisateur(utilisateur);
		} else {
			this.status = false ;
			this.statusMessage = "Echec : L'enregistrement n'a pas été fait !";
		}
		
		return status ;
	}
	
	public String getParameter(String parametre) {
		String valeur = this.request.getParameter(parametre);
		return(valeur == null || valeur.trim().isEmpty())? null : valeur.trim();
	}
	
	private void validerChamps(String...parametres) {   // PERMET DE PRENDRE UNE LISTE DE STRING EN PARAMETRES
		// for (int i = 0; i < parametres.length; i++) {
		for(String parametre : parametres) {
			if(this.getParameter(parametre) == null)
				erreurs.put(parametre, EMPTY_FIELD_ERROR_MSG);
		}
	}
	
	private void validerPassword() {
		String password = this.getParameter(CHAMP_PASSWORD);
		String password_bis = this.getParameter(CHAMP_PASSWORD_BIS);
		
		if(password != null && !password.equals(password_bis)) {
			erreurs.put(CHAMP_PASSWORD, UNMATCHED_PASSWORD_ERROR_MSG);
			erreurs.put(CHAMP_PASSWORD_BIS, UNMATCHED_PASSWORD_ERROR_MSG);
		}
	}
	
	public Map<String, String> getErreurs(){ return this.erreurs ;}
	public HttpServletRequest getRequest() { return this.request;}
	public Utilisateur getUtilisateur() { return this.utilisateur;}
	public String getStatusMessage() { return this.statusMessage;}
	public Boolean getStatus() { return this.status;}
	
}
