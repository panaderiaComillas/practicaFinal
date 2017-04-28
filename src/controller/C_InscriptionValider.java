package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.M_DaoUser;
import metier.M_Role;
import metier.M_User;

/**
 * Servlet implementation class C_InscriptionValider
 */
@WebServlet("/C_InscriptionValider")
public class C_InscriptionValider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_InscriptionValider() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maVue = "/view/utilisateur/inscriptionValider.jsp";
		
		String nom=request.getParameter("nom");
		request.setAttribute("nom", nom);
		
		String prenom=request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		
		String mail=request.getParameter("mail");
		request.setAttribute("mail", mail);
		
		String login=request.getParameter("login");
		request.setAttribute("login", login);
		
		String mdp=request.getParameter("mdp");
		
		String mdp2=request.getParameter("mdp2");
		
		String tel=request.getParameter("tel");
		request.setAttribute("tel", tel);
		
		/*
		if(nom==""||prenom==""||mail==""||login==""||mdp==""){
			request.setAttribute("error", "error en el ingreso !");
			maVue = "/view/utilisateur/registrarse.jsp";
		}
		
		if((mdp)!=(mdp2)){
			request.setAttribute("error", "las contraseñas son diferentes !");
			maVue = "/view/utilisateur/registrarse.jsp";		
		}
		*/
		M_Role role= new M_Role(2,"Client");
				
		M_User unePersonne = new M_User(0, nom, prenom, mail, tel, login, mdp, role);
		M_DaoUser daoPers = new M_DaoUser();
		daoPers.insertUser(unePersonne);
				
        
        this.getServletContext().getRequestDispatcher(maVue).forward(request,response);	
	}

}
