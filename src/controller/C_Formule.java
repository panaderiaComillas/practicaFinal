package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.M_DaoMenu;
import metier.M_Menu;


/**
 * Servlet implementation class C_Formule
 */
@WebServlet("/C_Formule")
public class C_Formule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String template = "/view/templates/template.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_Formule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maVue = "/view/utilisateur/afficherFormules.jsp";

		M_DaoMenu daoFormule = new M_DaoMenu();
        List<M_Menu> formules = daoFormule.getMenus();
        request.setAttribute("listFormules", formules);

        request.setAttribute("maVue", maVue );
        this.getServletContext().getRequestDispatcher(template).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
