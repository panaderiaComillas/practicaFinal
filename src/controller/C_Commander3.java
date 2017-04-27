package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.M_DaoBoisson;
import dao.M_DaoDessert;
import dao.M_DaoIngredient;
import dao.M_DaoMenu;
import dao.M_DaoSandwich;
import dao.M_DaoSauce;
import dao.M_DaoTypeRetrait;
import metier.M_Boisson;
import metier.M_Dessert;
import metier.M_Ingredient;
import metier.M_Menu;
import metier.M_Sandwich;
import metier.M_Sauce;
import metier.M_TypeRetrait;

/**
 * Servlet implementation class C_Commander3
 */
@WebServlet("/C_Commander3")
public class C_Commander3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_Commander3() {
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
		
		String maVue = "/view/utilisateur/commandeValider.jsp";
		
		request.setAttribute("nomMenu", request.getAttribute("nomMenu"));
		
		String[] ingrédients = request.getParameterValues("ingrédients");
		request.setAttribute("ingrédients", ingrédients);
		
		String[] sauces = request.getParameterValues("sauces");
		request.setAttribute("sauces", sauces);
		
		String boisson=request.getParameter("boisson");
		request.setAttribute("boisson", boisson);
		
		String dessert=request.getParameter("dessert");
		request.setAttribute("dessert", dessert);
		
		String typeRetrait=request.getParameter("typeRetrait");
		request.setAttribute("typeRetrait", typeRetrait);
        
        this.getServletContext().getRequestDispatcher(maVue).forward(request,response);	
	}

}
