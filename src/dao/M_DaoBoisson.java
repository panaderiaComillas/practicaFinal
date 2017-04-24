package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Boisson;

public class M_DaoBoisson extends M_DaoGenerique {

	public void insertBoisson(M_Boisson boisson) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO BOISSON(NOMPRODUIT,VOLUME) VALUES(?,?)");
			prepStatement.setString(1, boisson.getNomProduit());
			prepStatement.setFloat(2, boisson.getVolume());
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

	public M_Boisson getBoissonByID(int id) {
		M_Boisson boisson = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM BOISSON WHERE IDPRODUIT=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			boisson = new M_Boisson(id, result.getString("nomProduit"), result.getFloat("volume"));
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
		return boisson;
	}

	public M_Boisson updateBoisson(M_Boisson boisson) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE BOISSON SET NOMPRODUIT=?, VOLUME=? WHERE IDPRODUIT=?");
			prepStatement.setString(1, boisson.getNomProduit());
			prepStatement.setFloat(2, boisson.getVolume());
			prepStatement.setInt(3, boisson.getIdProduit());
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
		return boisson;
	}

}