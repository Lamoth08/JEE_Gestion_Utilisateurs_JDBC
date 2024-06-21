package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/Authentification","/Deconnexion"})
public class Authentification extends HttpServlet {

	private static final String VUE_CONNEXION = "/WEB-INF/connexion.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("identifiant");
		String password = req.getParameter("pssword");
		HttpSession session = req.getSession(); 
		
		if(id.equals("DIC3") && password.equals("passer")) {
			session.setAttribute("isConnected", true);			
			resp.sendRedirect(req.getContextPath()+"/AddUser");
		} else {
			session.setAttribute("isConnected", false);			
			this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(req, resp);
		}
		
	}
	
}
