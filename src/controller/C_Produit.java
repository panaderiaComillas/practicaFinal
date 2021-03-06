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
import dao.M_DaoSandwich;
import metier.M_Boisson;
import metier.M_Dessert;
import metier.M_Ingredient;
import metier.M_Sandwich;

/**
 * Servlet implementation class C_Produit
 */
@WebServlet("/C_Produit")
public class C_Produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String template = "/view/templates/template.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_Produit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maVue = "/view/utilisateur/afficherProduits.jsp";

		M_DaoSandwich daoSandwich = new M_DaoSandwich();
        //récupération de la liste
		List<M_Sandwich> sandwichs = daoSandwich.getSandwichs();
		request.setAttribute("listSandwichs", sandwichs);

        M_DaoIngredient daoIngredient = new M_DaoIngredient();
        //récupération de la liste
        List<M_Ingredient> Ingredients = daoIngredient.getIngredients();
        request.setAttribute("listIngredients", Ingredients);

        M_DaoDessert daoDessert = new M_DaoDessert();
        //récupération de la liste
        List<M_Dessert> Desserts = daoDessert.getDesserts();
        request.setAttribute("listDesserts", Desserts);

        M_DaoBoisson daoBoisson = new M_DaoBoisson();
        //récupération de la liste
        List<M_Boisson> Boissons = daoBoisson.getBoissons();
        request.setAttribute("listBoissons", Boissons);

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
