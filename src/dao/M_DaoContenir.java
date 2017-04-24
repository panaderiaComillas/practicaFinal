package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Contenir;

public class M_DaoContenir extends M_DaoGenerique {

	public void insertContenir(M_Contenir contenir) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO CONTENIR(IDINGREDIENT,IDPRODUIT) VALUES(?,?)");
			prepStatement.setInt(1, contenir.getIdIngredient());
			prepStatement.setInt(2, contenir.getIdProduit());
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

	public M_Contenir getContenirByIdProduit(int idProduit) {
		M_Contenir contenir = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM CONTENIR WHERE IDPRODUIT=?");
			prepStatement.setInt(1, idProduit);
			result = prepStatement.executeQuery();
			result.next();
			contenir = new M_Contenir(result.getInt("idIngredient"), idProduit);
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
		return contenir;
	}

	public M_Contenir updateContenir(M_Contenir contenir) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE COMPORTER SET IDINGREDIENT=? WHERE IDPRODUIT=?");
			prepStatement.setInt(1, contenir.getIdIngredient());
			prepStatement.setInt(2, contenir.getIdProduit());
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
		return contenir;
	}

}