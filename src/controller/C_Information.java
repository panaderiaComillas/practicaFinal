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
 * Servlet implementation class C_Information
 */
@WebServlet("/C_Information")
public class C_Information extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_Information() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String maVue = "/view/utilisateur/misInformaciones.jsp";
		
		M_DaoUser daoUser = new M_DaoUser();
        M_User utilisateur = daoUser.getOneByLogin((String) session.getAttribute("login"));
        request.setAttribute("utilisateur", utilisateur);
		
		this.getServletContext().getRequestDispatcher(maVue).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String maVue = null;
		M_DaoUser daoUser = new M_DaoUser();
        M_User utilisateur = daoUser.getOneByLogin((String) session.getAttribute("login"));
		if (request.getParameter("action")!=null) {
			if (request.getParameter("action").equals("Editar mis informaciones")) {
				maVue = "/view/utilisateur/modificarInformaciones.jsp";
				request.setAttribute("utilisateur", utilisateur);
			} 
			if(request.getParameter("action").equals("Guardar")){
				maVue = "/view/utilisateur/misInformaciones.jsp";
		        utilisateur.setNomUser(request.getParameter("nom").trim());
		        utilisateur.setPrenomUser(request.getParameter("prenom").trim());
		        utilisateur.setEmail(request.getParameter("mail").trim());
		        utilisateur.setTel(request.getParameter("tel").trim());
		        utilisateur.setLogin(request.getParameter("login").trim());
		        utilisateur.setMdp(daoUser.stringToSHA1(request.getParameter("password")));
		        request.setAttribute("utilisateur", utilisateur);
		        int ok = daoUser.updateUser(utilisateur);
		        if (ok==1) {
		        	request.setAttribute("message", "Modifications enregistrées");
		        } else {
		        	request.setAttribute("message", "Echec des modifications");
		        }
			}
		}
        request.setAttribute("utilisateur", utilisateur);

		this.getServletContext().getRequestDispatcher(maVue).forward(request,response);
	}

}
