package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.List;

import persistance.Connexion;
import beans.Utilisateur;

public class DatabaseDao {

	private Connection conn = Connexion.getConnexion();
	private static final String SQL_LISTER_UTILISATEURS = "SELECT * FROM utilisateur";
	private static final String SQL_CHERCHER_UTILISATEUR_ID = "SELECT * FROM utilisateur WHERE id = ? ";
	private static final String SQL_CHERCHER_UTILISATEUR_LOGIN = "SELECT * FROM utilisateur WHERE login = ? and password = ?";
	private static final String SQL_SUPPRIMER_UTILISATEUR = "DELETE FROM utilisateur WHERE id = ? ";
	private static final String SQL_MODIFIER_UTILISATEUR = "UPDATE utilisateur set nom = ? , prenom = ? , login = ? , password = ? WHERE id=? ";
	private static final String SQL_INSERER_UTILISATEUR = "INSERT INTO utilisateur (nom, prenom, login, password) VALUES(?,?,?,?)";

	public List<Utilisateur> listerUtilisateurs() {

		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

		try {

			PreparedStatement st = conn.prepareStatement(SQL_LISTER_UTILISATEURS);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Utilisateur u = new Utilisateur();
				u.setId(rs.getInt("id"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setLogin(rs.getString("login"));
				u.setPassword(rs.getString("password"));

				utilisateurs.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("La liste des utilisateurs est momentanément indisponible !");
		}

		return utilisateurs;
	}

	public Utilisateur chercherUtilisateur(int id) {

		Utilisateur u1 = new Utilisateur();

		try {
			PreparedStatement st = conn.prepareStatement(SQL_CHERCHER_UTILISATEUR_ID);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				u1.setId(rs.getInt("id"));
				u1.setNom(rs.getString("nom"));
				u1.setPrenom(rs.getString("prenom"));
				u1.setLogin(rs.getString("login"));
				u1.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName() + " :" + e.getMessage());
			System.out.println("L utilisateur que vous cherche n a pas ete trouve !");
		}

		return u1;
	}
	
	public Boolean chercherUtilisateur(String login, String mdp) {
		try {
			
			PreparedStatement st = conn.prepareStatement(SQL_CHERCHER_UTILISATEUR_LOGIN);
			st.setString(1, login);
			st.setString(2, mdp);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true ;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName()+" : "+e.getMessage());
			System.out.println("L utilisateur n a pas ete trouve !");
		}
		
		return false ;
	}

	public Boolean modifierUtilisateur(Utilisateur u) {

		int result = 0;
		try {

			PreparedStatement st = conn.prepareStatement(SQL_MODIFIER_UTILISATEUR);
			st.setString(1, u.getNom());
			st.setString(2, u.getPrenom());
			st.setString(3, u.getLogin());
			st.setString(4, u.getPassword());
			st.setInt(5, u.getId());

			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName() + " :" + e.getMessage());
			System.out.println("L utilisateur n a pas ete modifie !");
		}

		return result > 0 ? true : false;
	}

	public Boolean supprimerUtilisateur(int id) {

		int result = 0;
		try {

			PreparedStatement st = conn.prepareStatement(SQL_SUPPRIMER_UTILISATEUR);
			st.setInt(1, id);

			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName() + " :" + e.getMessage());
			System.out.println("L utilisateur n a pas ete supprime !");
		}

		return result > 0 ? true : false;
	}

	public Boolean ajouterUtilisateur(Utilisateur utilisateur) {

		int result = 0;

		try {
			PreparedStatement st = conn.prepareStatement(SQL_INSERER_UTILISATEUR);
			st.setString(1, utilisateur.getNom());
			st.setString(2, utilisateur.getPrenom());
			st.setString(3, utilisateur.getLogin());
			st.setString(4, utilisateur.getPassword());

			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName() + " :" + e.getMessage());
			System.out.println("L utilisateur n a pas ete ajoute !");
		}

		return result > 0 ? true : false;
	}

	
	/*
	 * public static void main(String []args) throws SQLException { DatabaseDao db =
	 * new DatabaseDao();
	 * 
	 * Utilisateur user1 = new Utilisateur(); List<Utilisateur> liste = new
	 * ArrayList<Utilisateur>();
	 * 
	 * 
	 * //user1.setNom("Camara"); user1.setPrenom("Moustapha");
	 * //user1.setLogin("mcamara"); user1.setPassword("chocolat");
	 * //db.ajouterUtilisateur(user1);
	 * 
	 * db.supprimerUtilisateur(5);
	 * 
	 * liste = db.listerUtilisateurs(); for(Utilisateur u : liste){
	 * System.out.print("User "+u.getId()+" : "); System.out.print(u.getNom()+" ");
	 * System.out.print(u.getPrenom()+" "); System.out.print(u.getLogin()+" ");
	 * System.out.print(u.getPassword()+" "); System.out.println(); }
	 * 
	 * }
	 */
	  
	 
}
