package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Produit;

public class M_DaoProduit extends M_DaoGenerique {

	public void insertProduit(M_Produit produit) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO BOISSON(NOMPRODUIT) VALUES(?)");
			prepStatement.setString(1, produit.getNomProduit());
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
			produit = new M_Produit(id, result.getString("nomProduit"));
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

	public M_Produit updateProduit(M_Produit produit) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE BOISSON SET NOMPRODUIT=? WHERE IDPRODUIT=?");
			prepStatement.setString(1, produit.getNomProduit());
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