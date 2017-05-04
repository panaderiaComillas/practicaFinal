package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.M_DaoRole;
import dao.M_DaoUser;
import metier.M_Role;
import metier.M_User;

/**
 * Servlet implementation class C_InscriptionValider
 */
@WebServlet("/C_InscriptionValider")
public class C_InscriptionValider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String template = "/view/templates/template.jsp";
       
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
		
		String nom=request.getParameter("nom").trim();
		request.setAttribute("nom", nom);
		
		String prenom=request.getParameter("prenom").trim();
		request.setAttribute("prenom", prenom);
		
		String mail=request.getParameter("mail").trim();
		request.setAttribute("mail", mail);
		
		String tel=request.getParameter("tel").trim();
		request.setAttribute("tel", tel);
		
		String login=request.getParameter("login").trim();
		request.setAttribute("login", login);
		
		String mdp=request.getParameter("mdp").trim();
		
		String mdp2=request.getParameter("mdp2").trim();
		
		
		if(nom==""||prenom==""||mail==""||login==""||mdp==""){
			request.setAttribute("error", "error en el ingreso !");
			maVue = "/view/utilisateur/registrarse.jsp";
		}else if(!mdp.equals(mdp2)){
			request.setAttribute("error", "las contraseñas son diferentes !");
			maVue = "/view/utilisateur/registrarse.jsp";	
			}else{
				M_DaoRole daoRole= new M_DaoRole();
				M_Role role= daoRole.getRoleByID(2);
				M_DaoUser daoUser = new M_DaoUser();
				M_User unePersonne = new M_User(nom, prenom, mail, tel, login, daoUser.stringToSHA1(mdp), role);
				daoUser.insertUser(unePersonne);
			}	
        
		request.setAttribute("maVue", maVue );
        this.getServletContext().getRequestDispatcher(template).forward(request,response);
	}

}
