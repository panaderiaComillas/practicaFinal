package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.M_Role;

public class M_DaoRole extends M_DaoGenerique {
	
	private void objetVersEnregistrement(M_Role role) throws SQLException {
		prepStatement.setString(1, role.getNomRole());
	}
	
	private M_Role enregistrementVersObjet(ResultSet result) throws SQLException {
		M_Role role;
		role = new M_Role(result.getInt("idRole"), result.getString("nomRole"));
		return role;
	}

	public void insertRole(M_Role role) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO ROLE(NOMROLE) VALUES(?)");
			objetVersEnregistrement(role);
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

	public M_Role getRoleByID(int id) {
		M_Role role = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM ROLE WHERE IDROLE=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			role = enregistrementVersObjet(result);
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
		return role;
	}
	
	public List<M_Role> getRoles() {
		List<M_Role> roles = new ArrayList<M_Role>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM PRODUIT");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Role role = enregistrementVersObjet(result);
				roles.add(role);
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
		return roles;
	}

	public M_Role updateRole(M_Role role) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE ROLE SET NOMROLE=? WHERE IDROLE=?");
			objetVersEnregistrement(role);
			prepStatement.setInt(2, role.getIdRole());
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
		return role;
	}
}