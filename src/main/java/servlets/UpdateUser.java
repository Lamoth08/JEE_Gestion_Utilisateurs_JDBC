package servlets;

import java.io.IOException;

import beans.Utilisateur;
import dao.DatabaseDao;
import dao.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {

	private static final String VUE_MODIFIER_UTILISATEUR = "/WEB-INF/modifierUtilisateur.jsp";
	private DatabaseDao db = new DatabaseDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		int sentId = Integer.parseInt(id);
		Utilisateur u = null ;
		
		if(id != null && id.matches("[0-9]+")) {
			u = db.chercherUtilisateur(sentId);
			u.setId(sentId);
		}
		
		request.setAttribute("utilisateur", u);
		
		this.getServletContext().getRequestDispatcher(VUE_MODIFIER_UTILISATEUR).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Utilisateur u = new Utilisateur(nom, prenom, login, password);
		u.setId(Integer.parseInt(id));

		
		if(db.modifierUtilisateur(u)) {
			System.out.println(" Modification enregistrée ! ");
		} else {
			System.out.println("Aucune modification enrgistrée x/ !");
		}
		
		//this.getServletContext().getRequestDispatcher("").forward(request,response);
		response.sendRedirect(request.getContextPath()+"/ListUsers");
		
	}
}
