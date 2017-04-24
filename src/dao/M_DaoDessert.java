package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Dessert;

public class M_DaoDessert extends M_DaoGenerique{

	public void insertDessert(M_Dessert dessert) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO DESSERT(NOMPRODUIT) VALUES(?)");
			prepStatement.setString(1, dessert.getNomProduit());
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

	public M_Dessert getDessertByID(int id) {
		M_Dessert dessert = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM DESSERT WHERE IDPRODUIT=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			dessert = new M_Dessert(id, result.getString("nomProduit"));
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
		return dessert;
	}

	public M_Dessert updateDessert(M_Dessert dessert) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE DESSERT SET NOMPRODUIT=? WHERE IDPRODUIT=?");
			prepStatement.setString(1, dessert.getNomProduit());
			prepStatement.setInt(2, dessert.getIdProduit());
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
		return dessert;
	}

}