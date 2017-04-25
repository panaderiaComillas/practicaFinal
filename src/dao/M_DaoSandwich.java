package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.M_Sandwich;

public class M_DaoSandwich extends M_DaoGenerique {

	private void objetVersEnregistrement(M_Sandwich sandwich) throws SQLException {
		prepStatement.setString(1, sandwich.getNomProduit());
		prepStatement.setBoolean(2, sandwich.isTemperaturePain());
	}

	private M_Sandwich enregistrementVersObjet(ResultSet result) throws SQLException {
		M_Sandwich sandwich;
		sandwich = new M_Sandwich(result.getInt("idProduit"), result.getString("nomProduit"),
				result.getBoolean("temperaturePain"));
		return sandwich;
	}

	public void insertSandwich(M_Sandwich sandwich) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO SANDWICH(NOMPRODUIT,TEMPERATUREPAIN) VALUES(?,?)");
			objetVersEnregistrement(sandwich);
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
			sandwich = enregistrementVersObjet(result);
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

	public List<M_Sandwich> getSandwichs() {
		List<M_Sandwich> sandwichs = new ArrayList<M_Sandwich>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM SANDWICH S INNER JOIN PRODUIT P ON S.IDPRODUIT=P.IDPRODUIT");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Sandwich sandwich = enregistrementVersObjet(result);
				sandwichs.add(sandwich);
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
		return sandwichs;
	}

	public M_Sandwich updateSandwich(M_Sandwich sandwich) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection
					.prepareStatement("UPDATE SANDWICH SET NOMPRODUIT=?, TEMPERATUREPAIN=? WHERE IDPRODUIT=?");
			objetVersEnregistrement(sandwich);
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