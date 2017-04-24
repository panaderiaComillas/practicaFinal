package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Sandwich;

public class M_DaoSandwich extends M_DaoGenerique {

	public void insertSandwich(M_Sandwich sandwich) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO BOISSON(NOMPRODUIT,TEMPERATUREPAIN) VALUES(?,?)");
			prepStatement.setString(1, sandwich.getNomProduit());
			prepStatement.setBoolean(2, sandwich.isTemperaturePain());
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

	public M_Sandwich getSandwichByID(int id) {
		M_Sandwich sandwich = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM SANDWICH WHERE IDPRODUIT=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			sandwich = new M_Sandwich(id, result.getString("nomProduit"), result.getBoolean("temperaturePain"));
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
		return sandwich;
	}

	public M_Sandwich updateSandwich(M_Sandwich sandwich) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection
					.prepareStatement("UPDATE BOISSON SET NOMPRODUIT=?, TEMPERATUREPAIN=? WHERE IDPRODUIT=?");
			prepStatement.setString(1, sandwich.getNomProduit());
			prepStatement.setBoolean(2, sandwich.isTemperaturePain());
			prepStatement.setInt(3, sandwich.getIdProduit());
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
		return sandwich;
	}

}