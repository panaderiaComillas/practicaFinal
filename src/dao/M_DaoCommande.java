package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import metier.M_Commande;
import metier.M_TypeRetrait;

public class M_DaoCommande extends M_DaoGenerique {

	private void objetVersEnregistrement(M_Commande commande) throws SQLException {
		prepStatement.setTimestamp(1, (Timestamp) commande.getDateHeure());
		prepStatement.setTime(2, (Time) commande.getHeureRetrait());
		prepStatement.setInt(3, commande.getIdUser());
		prepStatement.setInt(4, commande.getTypeRetrait().getIdTypeRetrait());
		prepStatement.setString(5, commande.getEtatCommande());
	}

	private M_Commande enregistrementVersObjet(ResultSet result) throws SQLException {
		M_DaoTypeRetrait daoTypeRetrait = new M_DaoTypeRetrait();
		M_TypeRetrait leTypeRetrait = daoTypeRetrait.getTypeRetraitByID(result.getInt("idTypeRetrait"));
		M_Commande commande = new M_Commande(result.getInt("idCommande"), result.getTimestamp("dateHeure"),
				result.getTime("heureRetrait"), result.getInt("idUser"), leTypeRetrait,
				result.getString("etatCommande"));
		return commande;
	}

	public void insertCommande(M_Commande commande) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"INSERT INTO COMMANDE(DATEHEURE, HEURERETRAIT, IDUSER, IDTYPERETRAIT, ETATCOMMANDE) "
					+ "VALUES(?,?,?,?,?)");
			objetVersEnregistrement(commande);
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
			commande = enregistrementVersObjet(result);
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

	public List<M_Commande> getCommandesByLogin(String login) {
		List<M_Commande> commandes = new ArrayList<M_Commande>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM COMMANDE C "
					+ "INNER JOIN USER U ON C.IDUSER=U.IDUSER "
					+ "INNER JOIN TYPERETRAIT TR ON C.IDTYPERETRAIT=TR.IDTYPERETRAIT "
					+ "WHERE U.LOGIN=?");
			prepStatement.setString(1, login);
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Commande commande = enregistrementVersObjet(result);
				commandes.add(commande);
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
		return commandes;
	}

	public List<M_Commande> getCommandesEnCours(String etatCommande) {
		List<M_Commande> commandes = new ArrayList<M_Commande>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection
					.prepareStatement(
							"SELECT * FROM COMMANDE C "
							+ "INNER JOIN USER U ON C.IDUSER=U.IDUSER "
							+ "INNER JOIN TYPERETRAIT TR ON C.IDTYPERETRAIT=TR.IDTYPERETRAIT "
							+ "INNER JOIN MENU M ON C.IDCOMMANDE=M.IDCOMMANDE "
							+ "INNER JOIN PRODUIT P ON M.IDPRODUIT=P.IDPRODUIT "
							+ "INNER JOIN INGREDIENT I ON I.IDPRODUIT=P.IDPRODUIT "
							+ "INNER JOIN SAUCE S ON S.IDPRODUIT=P.IDPRODUIT "
							+ "WHERE ETATCOMMANDE=?");
			prepStatement.setString(1, etatCommande);
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Commande commande = enregistrementVersObjet(result);
				commandes.add(commande);
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
		return commandes;
	}

	public List<M_Commande> getCommandes() {
		List<M_Commande> commandes = new ArrayList<M_Commande>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM COMMANDE C INNER JOIN TYPERETRAIT TR ON C.IDTYPERETRAIT=TR.IDTYPERETRAIT");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Commande commande = enregistrementVersObjet(result);
				commandes.add(commande);
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
		return commandes;
	}

	public M_Commande updateCommande(M_Commande commande) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"UPDATE COMMANDE SET DATEHEURE=?, HEURERETRAIT=?, IDUSER=?, IDTYPERETRAIT=?, ETATCOMMANDE=? "
					+ "WHERE IDCOMMANDE=?");
			objetVersEnregistrement(commande);
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