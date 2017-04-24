package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Sauce;

public class M_DaoSauce extends M_DaoGenerique {

	public void insertSauce(M_Sauce sauce) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO SAUCE(NOMSAUCE) VALUES(?)");
			prepStatement.setString(1, sauce.getNomSauce());
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

	public M_Sauce getSauceByID(int id) {
		M_Sauce sauce = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM SAUCE WHERE IDSAUCE=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			sauce = new M_Sauce(id, result.getString("nomSauce"));
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
		return sauce;
	}

	public M_Sauce updateSauce(M_Sauce sauce) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE SAUCE SET NOMSAUCE=? WHERE IDSAUCE=?");
			prepStatement.setString(1, sauce.getNomSauce());
			prepStatement.setInt(2, sauce.getIdSauce());
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
		return sauce;
	}

}