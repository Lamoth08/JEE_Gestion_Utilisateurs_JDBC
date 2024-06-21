package servlets;

import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;
import forms.AddUserForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	
	private static final String VUE_AJOUTER_UTILISATEUR = "/WEB-INF/ajouterUtilisateur.jsp";
	// private static final String VUE_LISTER_UTILISATEUR = "/WEB-INF/listerUtilisateur.jsp";

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VUE_AJOUTER_UTILISATEUR).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		UtilisateurDao.ajouter(new Utilisateur(nom, prenom, login, password));
		
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(login);
		System.out.println(password);
		
		response.sendRedirect(request.getContextPath()+"/ListUsers");*/
		
		
		
		AddUserForm form = new AddUserForm(request);
		
		if(form.ajouter()) {
			
			//response.sendRedirect(request.getContextPath()+"/ListUsers");			
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("status", form.getStatus());

			this.getServletContext().getRequestDispatcher(VUE_AJOUTER_UTILISATEUR).forward(request, response);
		
		} else {
			
			request.setAttribute("utilisateur", form.getUtilisateur());
			request.setAttribute("erreurs", form.getErreurs());
			request.setAttribute("statusMessage", form.getStatusMessage());
			request.setAttribute("status", form.getStatus());

			this.getServletContext().getRequestDispatcher(VUE_AJOUTER_UTILISATEUR).forward(request, response);
		}
		
	}
}
