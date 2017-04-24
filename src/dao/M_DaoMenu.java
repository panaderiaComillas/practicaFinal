package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Menu;

public class M_DaoMenu extends M_DaoGenerique {

	public void insertMenu(M_Menu menu) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO MENU(PRIXMENU, NOMPRODUIT) VALUES(?,?)");
			prepStatement.setFloat(1, menu.getPrixMenu());
			prepStatement.setString(2, menu.getNomMenu());
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

	public M_Menu getMenuByID(int id) {
		M_Menu menu = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM MENU WHERE IDMENU=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			menu = new M_Menu(id, result.getFloat("prixMenu"), result.getString("nomMenu"));
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
		return menu;
	}

	public M_Menu updateMenu(M_Menu menu) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE MENU SET PRIXMENU=?, NOMMENU=? WHERE IDMENU=?");
			prepStatement.setFloat(1, menu.getPrixMenu());
			prepStatement.setString(2, menu.getNomMenu());
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
		return menu;
	}

}