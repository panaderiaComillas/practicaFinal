package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Comporter;

public class M_DaoComporter extends M_DaoGenerique {

	public void insertComporter(M_Comporter comporter) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO COMPORTER(IDMENU,IDCOMMANDE) VALUES(?,?)");
			prepStatement.setInt(1, comporter.getIdMenu());
			prepStatement.setInt(2, comporter.getIdCommande());
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

	public M_Comporter getComporterByIdCommande(int idCommande) {
		M_Comporter comporter = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM COMPORTER WHERE IDCOMMANDE=?");
			prepStatement.setInt(1, idCommande);
			result = prepStatement.executeQuery();
			result.next();
			comporter = new M_Comporter(idCommande, result.getInt("idMenu"));
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
		return comporter;
	}

	public M_Comporter updateComporter(M_Comporter comporter) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE COMPORTER SET IDMENU=? WHERE IDCOMMANDE=?");
			prepStatement.setInt(1, comporter.getIdMenu());
			prepStatement.setInt(2, comporter.getIdCommande());
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
		return comporter;
	}

}