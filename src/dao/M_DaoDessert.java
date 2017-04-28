package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.M_Dessert;

public class M_DaoDessert extends M_DaoGenerique {

	private void objetVersEnregistrement(M_Dessert dessert) throws SQLException {
		prepStatement.setString(1, dessert.getNomProduit());
	}

	private M_Dessert enregistrementVersObjet(ResultSet result) throws SQLException {
		M_Dessert dessert;
		dessert = new M_Dessert(result.getInt("idProduit"), result.getString("nomProduit"));
		return dessert;
	}

	public void insertDessert(M_Dessert dessert) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO DESSERT(NOMPRODUIT) VALUES(?)");
			objetVersEnregistrement(dessert);
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
			dessert = enregistrementVersObjet(result);
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
	
	public M_Dessert getDessertByName(String nomDessert) {
		M_Dessert dessert = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM DESSERT WHERE NOMPRODUIT=?");
			prepStatement.setString(1, nomDessert);
			result = prepStatement.executeQuery();
			result.next();
			dessert = enregistrementVersObjet(result);
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

	public List<M_Dessert> getDesserts() {
		List<M_Dessert> desserts = new ArrayList<M_Dessert>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM DESSERT D INNER JOIN PRODUIT P ON D.IDPRODUIT=P.IDPRODUIT");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Dessert dessert = enregistrementVersObjet(result);
				desserts.add(dessert);
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
		return desserts;
	}

	public M_Dessert updateDessert(M_Dessert dessert) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(""
					+ "UPDATE DESSERT SET NOMPRODUIT=? "
					+ "INNER JOIN PRODUIT P ON D.IDPRODUIT=P.IDPRODUIT "
					+ "WHERE IDPRODUIT=?");
			objetVersEnregistrement(dessert);
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