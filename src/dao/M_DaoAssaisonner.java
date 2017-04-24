package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Assaisonner;

public class M_DaoAssaisonner extends M_DaoGenerique {

	public void insertAssaisonner(M_Assaisonner assaisonner) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO ASSAISONNER(idProduit,idSauce) VALUES(?,?)");
			prepStatement.setInt(1, assaisonner.getIdProduit());
			prepStatement.setInt(2, assaisonner.getIdSauce());
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

	public M_Assaisonner getAssaisonnerByIdProduit(int idProduit) {
		M_Assaisonner assaisonner = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM ASSAISONNER WHERE IDPRODUIT = ?");
			prepStatement.setInt(1, idProduit);
			result = prepStatement.executeQuery();
			result.next();
			assaisonner = new M_Assaisonner(idProduit, result.getInt("idsauce"));
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
		return assaisonner;
	}

	public M_Assaisonner updateAssaisonner(M_Assaisonner assaisonner) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE ASSAISONNER SET IDSAUCE=? WHERE IDPRODUIT=?");
			prepStatement.setInt(1, assaisonner.getIdSauce());
			prepStatement.setInt(2, assaisonner.getIdProduit());
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
		return assaisonner;
	}

}