package controller;

import java.io.IOException;
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
 * Servlet implementation class C_Commander2
 */
@WebServlet("/C_Commander2")
public class C_Commander2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_Commander2() {
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
		// TODO Auto-generated method stub
		
		String maVue = "/view/utilisateur/commander2.jsp";
		
		String nomMenu=request.getParameter("menus");
		request.setAttribute("nomMenu", nomMenu);
		
		M_DaoMenu daoFormule = new M_DaoMenu();
        //récupération de la liste
        List<M_Menu> formules = daoFormule.getMenus();
        request.setAttribute("listFormules", formules);

        M_DaoTypeRetrait daoTypeRetrait = new M_DaoTypeRetrait();
        //récupération de la liste
        List<M_TypeRetrait> typeRetraits = daoTypeRetrait.getTypeRetraits();
        request.setAttribute("listTypeRetraits", typeRetraits);

        M_DaoIngredient daoIngredient = new M_DaoIngredient();
        //récupération de la liste
        List<M_Ingredient> ingredients = daoIngredient.getIngredients();
        request.setAttribute("listIngredients", ingredients);
        
        M_DaoSauce daoSauce = new M_DaoSauce();
        //récupération de la liste
        List<M_Sauce> sauces = daoSauce.getSauces();
        request.setAttribute("listSauces", sauces);

        M_DaoDessert daoDessert = new M_DaoDessert();
        //récupération de la liste
        List<M_Dessert> desserts = daoDessert.getDesserts();
        request.setAttribute("listDesserts", desserts);

        M_DaoBoisson daoBoisson = new M_DaoBoisson();
        //récupération de la liste
        List<M_Boisson> boissons = daoBoisson.getBoissons();
        request.setAttribute("listBoissons", boissons);
        
        this.getServletContext().getRequestDispatcher(maVue).forward(request,response);	

	}

}
