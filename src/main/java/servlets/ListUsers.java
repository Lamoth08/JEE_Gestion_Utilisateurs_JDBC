package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DatabaseDao;
import dao.UtilisateurDao;

//@WebServlet("/ListUsers")
public class ListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LISTER_UTILISATEUR  = "/WEB-INF/listerUtilisateur.jsp";
       

    public ListUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DatabaseDao db = new DatabaseDao();
		request.setAttribute("utilisateurs", db.listerUtilisateurs());
		this.getServletContext().getRequestDispatcher(VUE_LISTER_UTILISATEUR).forward(request, response);
	}

}
