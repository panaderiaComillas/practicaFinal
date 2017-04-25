package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.M_Produit;

public class M_DaoProduit extends M_DaoGenerique {

	private void objetVersEnregistrement(M_Produit produit) throws SQLException {
		prepStatement.setString(1, produit.getNomProduit());
	}

	private M_Produit enregistrementVersObjet(ResultSet result) throws SQLException {
		M_Produit produit = new M_Produit(result.getInt("idProduit"), result.getString("nomProduit"));
		return produit;
	}

	public void insertProduit(M_Produit produit) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO PRODUIT(NOMPRODUIT) VALUES(?)");
			objetVersEnregistrement(produit);
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepStatement != null) {
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public M_Produit getProduitByID(int id) {
		M_Produit produit = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM PRODUIT WHERE IDPRODUIT=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			produit = enregistrementVersObjet(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepStatement != null) {
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return produit;
	}

	public M_Produit getProduitByName(String nomProduit) {
		M_Produit produit = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM PRODUIT WHERE NOMPRODUIT=?");
			prepStatement.setString(1, nomProduit);
			result = prepStatement.executeQuery();
			result.next();
			produit = enregistrementVersObjet(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepStatement != null) {
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return produit;
	}

	public List<M_Produit> getProduits() {
		List<M_Produit> produits = new ArrayList<M_Produit>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM PRODUIT");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Produit produit = enregistrementVersObjet(result);
				produits.add(produit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepStatement != null) {
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return produits;
	}
	
	public List<M_Produit> getProduitsCommandeByIdCommande(int idCommande) {
		List<M_Produit> produits = new ArrayList<M_Produit>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT P.NOMPRODUIT,P.IDPRODUIT FROM PRODUIT P "
					+ "INNER JOIN POSSEDER PO ON PO.IDPRODUIT=P.IDPRODUIT "
					+ "INNER JOIN MENU M ON PO.IDMENU=M.IDMENU "
					+ "INNER JOIN COMPORTER COMP ON M.IDMENU=COMP.IDMENU "
					+ "INNER JOIN COMMANDE C ON COMP.IDCOMMANDE=C.IDCOMMANDE "
					+ "INNER JOIN USER U ON C.IDUSER=U.IDUSER "
					+ "WHERE C.IDCOMMANDE = ?");
			prepStatement.setInt(1, idCommande);
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Produit produit = enregistrementVersObjet(result);
				produits.add(produit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepStatement != null) {
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return produits;
	}

	public M_Produit updateProduit(M_Produit produit) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE PRODUIT SET NOMPRODUIT=? WHERE IDPRODUIT=?");
			objetVersEnregistrement(produit);
			prepStatement.setInt(3, produit.getIdProduit());
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepStatement != null) {
				try {
					prepStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return produit;
	}

}