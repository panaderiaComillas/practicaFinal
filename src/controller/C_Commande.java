package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.M_DaoCommande;
import metier.M_Commande;

/**
 * Servlet implementation class C_Commande
 */
@WebServlet("/C_Commande")
public class C_Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_Commande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String maVue = "/view/utilisateur/misPedidos.jsp";
		
        M_DaoCommande daoCommande = new M_DaoCommande();
        List<M_Commande> commandes = daoCommande.getCommandesByLogin((String) session.getAttribute("login"));
        request.setAttribute("listCommandes", commandes);
        
//        M_DaoProduit daoProduit = new M_DaoProduit();
//        List<M_Produit> listProduits = daoProduit.getProduitsCommandeByIdCommande(uneCommande.getIdCommande());
//        request.setAttribute("listProduits", listProduits);
//        
		this.getServletContext().getRequestDispatcher(maVue).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
