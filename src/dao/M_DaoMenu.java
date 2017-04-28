package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.M_Menu;

public class M_DaoMenu extends M_DaoGenerique {

	private void objetVersEnregistrement(M_Menu menu) throws SQLException {
		prepStatement.setFloat(1, menu.getPrixMenu());
		prepStatement.setString(2, menu.getNomMenu());
	}

	private M_Menu enregistrementVersObjet(ResultSet result) throws SQLException {
		M_Menu menu;
		menu = new M_Menu(result.getInt("idMenu"), result.getFloat("prixMenu"), result.getString("nomMenu"));
		return menu;
	}

	public void insertMenu(M_Menu menu) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO MENU(PRIXMENU, NOMPRODUIT) VALUES(?,?)");
			objetVersEnregistrement(menu);
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
			menu = enregistrementVersObjet(result);
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
	
	public M_Menu getMenuByName(String nomMenu) {
		M_Menu menu = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM MENU WHERE NOMMENU=?");
			prepStatement.setString(1, nomMenu);
			result = prepStatement.executeQuery();
			result.next();
			menu = enregistrementVersObjet(result);
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
	
	public List<M_Menu> getMenus() {
		List<M_Menu> menus = new ArrayList<M_Menu>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM MENU");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Menu menu = enregistrementVersObjet(result);
				menus.add(menu);
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
		return menus;
	}

	public M_Menu updateMenu(M_Menu menu) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE MENU SET PRIXMENU=?, NOMMENU=? WHERE IDMENU=?");
			objetVersEnregistrement(menu);
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