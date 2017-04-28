package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.M_Sauce;

public class M_DaoSauce extends M_DaoGenerique {
	
	private void objetVersEnregistrement(M_Sauce sauce) throws SQLException {
		prepStatement.setString(1, sauce.getNomSauce());
	}
	
	private M_Sauce enregistrementVersObjet(ResultSet result) throws SQLException {
		M_Sauce sauce;
		sauce = new M_Sauce(result.getInt("idSauce"), result.getString("nomSauce"));
		return sauce;
	}

	public void insertSauce(M_Sauce sauce) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO SAUCE(NOMSAUCE) VALUES(?)");
			objetVersEnregistrement(sauce);
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
			sauce = enregistrementVersObjet(result);
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
	
	public M_Sauce getSauceByName(String nomSauce) {
		M_Sauce sauce = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM SAUCE WHERE NOMSAUCE=?");
			prepStatement.setString(1, nomSauce);
			result = prepStatement.executeQuery();
			result.next();
			sauce = enregistrementVersObjet(result);
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
	
	public List<M_Sauce> getSauces() {
		List<M_Sauce> sauces = new ArrayList<M_Sauce>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM SAUCE");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Sauce sauce = enregistrementVersObjet(result);
				sauces.add(sauce);
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
		return sauces;
	}

	public M_Sauce updateSauce(M_Sauce sauce) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE SAUCE SET NOMSAUCE=? WHERE IDSAUCE=?");
			objetVersEnregistrement(sauce);
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