package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/Redirection"})
public class Redirection extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id_con = request.getParameter("identifiant");
		String mdp_con = request.getParameter("pssword");
		
		String msg_con ="Echec de la connexion : login ou mot de passe erroné";
		
		if(id_con.equals("admin") & mdp_con.equals("passer"))
			msg_con = " Vous etes connectes !";
		
		request.setAttribute("message", msg_con);

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/status.jsp").forward(request, response);
	}
}
