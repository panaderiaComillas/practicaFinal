package controller;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.M_DaoAssaisonner;
import dao.M_DaoBoisson;
import dao.M_DaoCommande;
import dao.M_DaoComporter;
import dao.M_DaoContenir;
import dao.M_DaoDessert;
import dao.M_DaoIngredient;
import dao.M_DaoMenu;
import dao.M_DaoPosseder;
import dao.M_DaoSauce;
import dao.M_DaoTypeRetrait;
import dao.M_DaoUser;
import metier.M_Assaisonner;
import metier.M_Boisson;
import metier.M_Commande;
import metier.M_Comporter;
import metier.M_Contenir;
import metier.M_Dessert;
import metier.M_Ingredient;
import metier.M_Menu;
import metier.M_Posseder;
import metier.M_Sauce;
import metier.M_TypeRetrait;
import metier.M_User;

/**
 * Servlet implementation class C_Commander3
 */
@WebServlet("/C_Commander3")
public class C_Commander3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String template = "/view/templates/template.jsp";
       
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
		HttpSession session=request.getSession();
		int idUser=(int) session.getAttribute("idUser");

		String maVue = "/view/utilisateur/commandeValider.jsp";
		
		String nomMenu = request.getParameter("nomMenu");
		request.setAttribute("nomMenu", nomMenu);
//		M_DaoMenu daoMenu = new M_DaoMenu();
//		M_Menu menu = daoMenu.getMenuByName(nomMenu);
//		int idMenu = menu.getIdMenu();
        
		String[] ingredients = request.getParameterValues("ingredients");
		request.setAttribute("ingredients", ingredients);
//		M_DaoIngredient daoIngredient = new M_DaoIngredient();
//		int idIngredient;
//        for (String nomIngredient : ingredients) {
//			M_Ingredient ingredient = daoIngredient.getIngredientByName(nomIngredient);
//			idIngredient = ingredient.getIdIngredient();
//		}
		
		String[] sauces = request.getParameterValues("sauces");
		request.setAttribute("sauces", sauces);
//		M_DaoSauce daoSauce = new M_DaoSauce();
//		int idSauce;
//		List<Integer> listIdSauces = new ArrayList<Integer>();
//        for (String nomSauce : sauces) {
//        	M_Sauce sauce = daoSauce.getSauceByName(nomSauce);
//            idSauce = sauce.getIdSauce();
//            listIdSauces.add(idSauce);
//		}
//		
//		List<Integer> listIdProduits = new ArrayList<Integer>();
		
		String nomBoisson=request.getParameter("boisson");
		request.setAttribute("boisson", nomBoisson);
//		M_DaoBoisson daoBoisson = new M_DaoBoisson();
//		M_Boisson boisson = daoBoisson.getBoissonByName(nomBoisson);
//		int idBoisson = boisson.getIdProduit();
//		listIdProduits.add(idBoisson);
		
		String nomDessert=request.getParameter("dessert");
		request.setAttribute("dessert", nomDessert);
//		M_DaoDessert daoDessert = new M_DaoDessert();
//		M_Dessert dessert = daoDessert.getDessertByName(nomDessert);
//		int idDessert = dessert.getIdProduit();
//		listIdProduits.add(idDessert);
		
		String nomTypeRetrait=request.getParameter("typeRetrait");
		request.setAttribute("typeRetrait", nomTypeRetrait);
		M_DaoTypeRetrait daoTypeRetrait = new M_DaoTypeRetrait();
        M_TypeRetrait typeRetrait = daoTypeRetrait.getTypeRetraitByName(nomTypeRetrait);
        
        String stringHeureRetrait = request.getParameter("heureRetrait");
		request.setAttribute("heureRetrait", stringHeureRetrait);
		Time heureRetrait = Time.valueOf(stringHeureRetrait);
		
		Timestamp dateHeure = new Timestamp(System.currentTimeMillis());
        
		//insert Commande
		M_Commande commande = new M_Commande(dateHeure, heureRetrait, idUser, typeRetrait, "en cours");
		M_DaoCommande daoCommande = new M_DaoCommande();
		daoCommande.insertCommande(commande);
		
//		//insert comporter
//		int idCommande = daoCommande.getIdCommande(commande);
//		M_Comporter comporter = new M_Comporter(idMenu, idCommande);
//		M_DaoComporter daoComporter = new M_DaoComporter();
//		daoComporter.insertComporter(comporter);
//		
//		//insert posseder * nbProduit
//		M_DaoPosseder daoPosseder = new M_DaoPosseder();
//		for (Integer idProduit : listIdProduits) {
//			M_Posseder posseder = new M_Posseder(idMenu, idProduit);
//			daoPosseder.insertPosseder(posseder);	
//		}
//		
//		//insert assaisonner * nbSauce
//		M_Assaisonner assaisonner = new M_Assaisonner(idProduit, idSauce);
//		M_DaoAssaisonner daoAssaisonner = new M_DaoAssaisonner();
//		daoAssaisonner.insertAssaisonner(assaisonner);
//		
//		//insert contenir * nbIngredient
//		M_Contenir contenir = new M_Contenir(idIngredient, idProduit);
//		M_DaoContenir daoContenir = new M_DaoContenir();
//		daoContenir.insertContenir(contenir);
		
		request.setAttribute("maVue", maVue );
        this.getServletContext().getRequestDispatcher(template).forward(request,response);
	}

}
