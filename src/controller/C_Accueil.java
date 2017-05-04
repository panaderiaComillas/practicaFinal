package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class C_Accueil
 */
@WebServlet("/C_Accueil")
public class C_Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String template = "/view/templates/template.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maVue = "/view/accueil/accueil.jsp";
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
