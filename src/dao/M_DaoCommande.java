package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import metier.M_Commande;
import metier.M_TypeRetrait;

public class M_DaoCommande extends M_DaoGenerique {

	public void insertCommande(M_Commande commande) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"INSERT INTO COMMANDE(DATEHEURE, HEURERETRAIT, IDUSER, IDTYPERETRAIT, ETATCOMMANDE) VALUES(?,?,?,?,?)");
			prepStatement.setTimestamp(1, (Timestamp) commande.getDateHeure());
			prepStatement.setTime(2, (Time) commande.getHeureRetrait());
			prepStatement.setInt(3, commande.getIdUser());
			prepStatement.setInt(4, commande.getTypeRetrait().getIdTypeRetrait());
			prepStatement.setString(5, commande.getEtatCommande());
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

	public M_Commande getCommandeByID(int id) {
		M_Commande commande = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM COMMANDE WHERE ID=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();

			// récupération TypeRetrait
			M_DaoTypeRetrait daoTypeRetrait = new M_DaoTypeRetrait();
			M_TypeRetrait leTypeRetrait = daoTypeRetrait.getTypeRetraitByID(result.getInt("idTypeRetrait"));

			commande = new M_Commande(id, result.getTimestamp("dateHeure"), result.getTime("heureRetrait"),
					result.getInt("idUser"), leTypeRetrait, result.getString("etatCommande"));
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
		return commande;
	}

	public M_Commande updateCommande(M_Commande commande) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"UPDATE COMMANDE SET DATEHEURE=?, HEURERETRAIT=?, IDUSER=?, IDTYPERETRAIT=?, ETATCOMMANDE=? WHERE IDCOMMANDE=?");
			prepStatement.setTimestamp(1, (Timestamp) commande.getDateHeure());
			prepStatement.setTime(2, (Time) commande.getHeureRetrait());
			prepStatement.setInt(3, commande.getIdUser());
			prepStatement.setInt(4, commande.getTypeRetrait().getIdTypeRetrait());
			prepStatement.setString(5, commande.getEtatCommande());
			prepStatement.setInt(6, commande.getIdCommande());
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
		return commande;
	}

}