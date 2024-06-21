package dao;

import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao {

	private static int lastId = 0 ;
	private static final ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
	
	
	public static void ajouter(Utilisateur utilisateur) {
		utilisateur.setId(++lastId);
		utilisateurs.add(utilisateur);
	}
	
	public static ArrayList<Utilisateur> lister(){
		return utilisateurs ;
	}
	
	public static boolean modifier(Utilisateur u1) {
		for(Utilisateur u : utilisateurs) {
			if(u.getId()==u1.getId()) {
				// Faire les modifications
				u.setNom(u1.getNom());
				u.setPrenom(u1.getPrenom());
				u.setLogin(u1.getLogin());
				u.setPassword(u1.getPassword());
				return true ;
			}
		}
		return false ;
	}
	
	public static Utilisateur get(int id) {
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getId() == id)
				return utilisateur ;
		}
		return null ;
	}
	
	public static boolean supprimer(int id) {
		for(Utilisateur u : utilisateurs) {
			if(u.getId()==id) {
				utilisateurs.remove(u);
				return true ;
			}
		}
		return false ;
	}
	
}
