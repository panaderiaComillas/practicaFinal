package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.M_DaoUser;
import metier.M_User;

/**
 * Servlet implementation class C_Connection
 */
@WebServlet("/C_Connection")
public class C_Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String template = "/view/templates/template.jsp";
	String maVue = "/view/connexion/conectarse.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_Connection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(maVue).forward(request,response);	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		if (request.getParameter("login")!=null && request.getParameter("mdp")!=null) {
			String login=request.getParameter("login");
			String mdp=request.getParameter("mdp");
			M_DaoUser daoUser= new M_DaoUser();
			M_User unUser = daoUser.verifierLogin(login, mdp);
			if (unUser != null) {
				session.setAttribute("login", login);
				session.setAttribute("idUser", unUser.getIdUser());
				session.setAttribute("role", unUser.getRole().getIdRole());
				request.setAttribute("maVue", "/index.jsp" );
			} else {
				String message="ECHEC d'identification : login ou mot de passe inconnu<br>";
				request.setAttribute("message", message);
				request.setAttribute("maVue", maVue );
			}
		} else {
			String message="Attention : le login et/ou le mot de passe ne sont pas renseignés";
			request.setAttribute("message", message);
			request.setAttribute("maVue", maVue );
		}
		this.getServletContext().getRequestDispatcher(template).forward(request,response);
	}
}
