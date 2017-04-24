package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Posseder;

public class M_DaoPosseder extends M_DaoGenerique {

	public void insertPosseder(M_Posseder posseder) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO POSSEDER(IDMENU,IDPRODUIT) VALUES(?,?)");
			prepStatement.setInt(1, posseder.getIdMenu());
			prepStatement.setInt(2, posseder.getIdProduit());
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

	public M_Posseder getPossederByIdMenu(int idMenu) {
		M_Posseder posseder = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM POSSEDER WHERE IDMENU=?");
			prepStatement.setInt(1, idMenu);
			result = prepStatement.executeQuery();
			result.next();
			posseder = new M_Posseder(idMenu, result.getInt("idProduit"));
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
		return posseder;
	}

	public M_Posseder updatePosseder(M_Posseder posseder) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE BOISSON SET IDPRODUIT=? WHERE IDMENU=?");
			prepStatement.setInt(1, posseder.getIdProduit());
			prepStatement.setInt(2, posseder.getIdMenu());
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
		return posseder;
	}

}