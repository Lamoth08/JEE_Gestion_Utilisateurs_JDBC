package servlets;

import java.io.IOException;

import dao.DatabaseDao;
import dao.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {

	private static final String VUE_LISTER_UTILISATEURS = "/WEB-INF/listerUtilisateur.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DatabaseDao db = new DatabaseDao();
		String id = request.getParameter("id");
		db.supprimerUtilisateur(Integer.parseInt(id));
		
		//this.getServletContext().getRequestDispatcher(VUE_LISTER_UTILISATEURS).forward(request, response);
		response.sendRedirect(request.getContextPath()+"/ListUsers");
	}
	
}


// DVWA