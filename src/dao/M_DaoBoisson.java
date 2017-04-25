package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.M_Boisson;

public class M_DaoBoisson extends M_DaoGenerique {

	private void objetVersEnregistrement(M_Boisson boisson) throws SQLException {
		prepStatement.setString(1, boisson.getNomProduit());
		prepStatement.setFloat(2, boisson.getVolume());
	}

	private M_Boisson enregistrementVersObjet(ResultSet result) throws SQLException {
		M_Boisson boisson = new M_Boisson(result.getInt("idProduit"), result.getString("nomProduit"),
				result.getFloat("volume"));
		return boisson;
	}

	public void insertBoisson(M_Boisson boisson) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO BOISSON(NOMPRODUIT,VOLUME) VALUES(?,?)");
			objetVersEnregistrement(boisson);
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

	public M_Boisson getBoissonByName(String nomProduit) {
		M_Boisson boisson = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT P.IDPRODUIT, NOMPRODUIT, VOLUME FROM PRODUIT P "
					+ "INNER JOIN BOISSON B ON P.IDPRODUIT=B.IDPRODUIT "
					+ "WHERE NOMPRODUIT=?");
			prepStatement.setString(1, nomProduit);
			result = prepStatement.executeQuery();
			result.next();
			boisson = enregistrementVersObjet(result);
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

	public List<M_Boisson> getBoissons() {
		List<M_Boisson> boissons = new ArrayList<M_Boisson>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM BOISSON B "
					+ "INNER JOIN PRODUIT P ON B.IDPRODUIT=P.IDPRODUIT");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Boisson boisson = enregistrementVersObjet(result);
				boissons.add(boisson);
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
		return boissons;
	}

	public M_Boisson updateBoisson(M_Boisson boisson) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE BOISSON SET NOMPRODUIT=?, VOLUME=? WHERE IDPRODUIT=?");
			objetVersEnregistrement(boisson);
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