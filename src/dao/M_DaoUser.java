package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Role;
import metier.M_User;

import dao.M_DaoRole;

public class M_DaoUser extends M_DaoGenerique {

	public void insertUser(M_User utilisateur) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"INSERT INTO USER(NOMUSER,PRENOMUSER,EMAIL,TEL,LOGIN,MDP,IDROLE) VALUES(?,?,?,?,?,?,?)");
			prepStatement.setString(1, utilisateur.getNomUser());
			prepStatement.setString(2, utilisateur.getPrenomUser());
			prepStatement.setString(3, utilisateur.getEmail());
			prepStatement.setString(4, utilisateur.getTel());
			prepStatement.setString(5, utilisateur.getLogin());
			prepStatement.setString(6, utilisateur.getMdp());
			prepStatement.setInt(7, utilisateur.getRole().getIdRole());
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

	public M_User getUserByID(int id) {
		M_User utilisateur = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);

			prepStatement = connection.prepareStatement(
					"SELECT * FROM USER U LEFT OUTER JOIN ROLE R ON R.IDROLE = U.IDROLE WHERE IDUSER=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();

			// récupération rôle
			M_DaoRole daoRole = new M_DaoRole();
			M_Role leRole = daoRole.getRoleByID(result.getInt("idRole"));

			utilisateur = new M_User(id, result.getString("nomUser"), result.getString("prenomUser"),
					result.getString("email"), result.getString("tel"), result.getString("login"),
					result.getString("mdp"), leRole);
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
		return utilisateur;
	}

	public M_User updateUser(M_User utilisateur) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"UPDATE USER SET NOMUSER=?,PRENOMUSER=?,EMAIL=?,TEL=?,LOGIN=?,MDP=?,IDROLE=? WHERE IDUSER=?");
			prepStatement.setString(1, utilisateur.getNomUser());
			prepStatement.setString(2, utilisateur.getPrenomUser());
			prepStatement.setString(3, utilisateur.getEmail());
			prepStatement.setString(4, utilisateur.getTel());
			prepStatement.setString(5, utilisateur.getLogin());
			prepStatement.setString(6, utilisateur.getMdp());
			prepStatement.setInt(7, utilisateur.getRole().getIdRole());
			prepStatement.setInt(8, utilisateur.getIdUser());
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
		return utilisateur;
	}

}