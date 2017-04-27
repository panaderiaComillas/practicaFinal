package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.M_Role;
import metier.M_User;

public class M_DaoUser extends M_DaoGenerique {

	private void objetVersEnregistrement(M_User utilisateur) throws SQLException {
		prepStatement.setString(1, utilisateur.getNomUser());
		prepStatement.setString(2, utilisateur.getPrenomUser());
		prepStatement.setString(3, utilisateur.getEmail());
		prepStatement.setString(4, utilisateur.getTel());
		prepStatement.setString(5, utilisateur.getLogin());
		prepStatement.setString(6, utilisateur.getMdp());
		prepStatement.setInt(7, utilisateur.getRole().getIdRole());
	}

	private M_User enregistrementVersObjet(ResultSet result) throws SQLException {
		M_User utilisateur;
		// récupération rôle
		M_DaoRole daoRole = new M_DaoRole();
		M_Role leRole = daoRole.getRoleByID(result.getInt("idRole"));
		utilisateur = new M_User(
				result.getInt("idUser"), 
				result.getString("nomUser"), 
				result.getString("prenomUser"),
				result.getString("email"), 
				result.getString("tel"), 
				result.getString("login"), 
				result.getString("mdp"),
				leRole);
		return utilisateur;
	}

	public void insertUser(M_User utilisateur) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"INSERT INTO USER(NOMUSER,PRENOMUSER,EMAIL,TEL,LOGIN,MDP,IDROLE) VALUES(?,?,?,?,?,?,?)");
			objetVersEnregistrement(utilisateur);
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

	public M_User getOneById(int id) {
		M_User utilisateur = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM USER U LEFT OUTER JOIN ROLE R ON R.IDROLE = U.IDROLE WHERE U.IDUSER=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			utilisateur = enregistrementVersObjet(result);
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
	
	public M_User getOneByLogin(String login) {
		M_User utilisateur = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM USER U LEFT OUTER JOIN ROLE R ON R.IDROLE = U.IDROLE WHERE U.LOGIN=?");
			prepStatement.setString(1, login);
			result = prepStatement.executeQuery();
			result.next();
			utilisateur = enregistrementVersObjet(result);
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
	
	public static byte[] calculerValeurDeHachage(String algorithme, String monMessage) {
		byte[] digest = null;
		try {
			MessageDigest sha = MessageDigest.getInstance(algorithme);
		    sha.update(monMessage.getBytes());
		    digest = sha.digest();
		    System.out.println("algorithme : " + algorithme);
		    System.out.println(bytesToHex(digest));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return digest;
	}
	
	public static String bytesToHex(byte[] b) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		StringBuffer buffer = new StringBuffer();
		for (int j = 0; j < b.length; j++) {
			buffer.append(hexDigits[(b[j] >> 4) & 0x0f]);
			buffer.append(hexDigits[b[j] & 0x0f]);
		}
		return buffer.toString();
	}
	
	public String stringToSHA1(String text){
		String hashText="";
		byte[] digest = null;
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
		    sha.update(text.getBytes());
		    digest = sha.digest();
		    hashText=bytesToHex(digest).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hashText;
	}
	
	public M_User verifierLogin(String login, String mdp) {
		M_User utilisateur = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM USER U INNER JOIN ROLE R ON U.IDROLE=R.IDROLE WHERE LOGIN = ? AND MDP = ?");
			prepStatement.setString(1, login);
			String mdp_sha1 = stringToSHA1(mdp); 
			prepStatement.setString(2, mdp_sha1);
			result = prepStatement.executeQuery();
			result.next();
			//String mdp_sha1 = stringToSHA1(mdp); 
			if (login.equals(result.getString("login")) && mdp_sha1.equals(result.getString("mdp"))) {
				utilisateur = enregistrementVersObjet(result);
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
		return utilisateur;
    }

	public List<M_User> getAll() {
		List<M_User> utilisateurs = new ArrayList<M_User>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM USER U "
					+ "LEFT OUTER JOIN ROLE R ON R.IDROLE=U.IDROLE");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_User utilisateur = enregistrementVersObjet(result);
				utilisateurs.add(utilisateur);
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
		return utilisateurs;
	}
	
	public List<M_User> getAllByRole(int idRole) {
		List<M_User> utilisateurs = new ArrayList<M_User>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM USER U "
					+ "LEFT OUTER JOIN ROLE R ON R.IDROLE=U.IDROLE "
					+ "WHERE U.IDROLE=?");
			prepStatement.setInt(1, idRole);
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_User utilisateur = enregistrementVersObjet(result);
				utilisateurs.add(utilisateur);
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
		return utilisateurs;
	}

	public M_User updateUser(M_User utilisateur) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"UPDATE USER SET NOMUSER=?,PRENOMUSER=?,EMAIL=?,TEL=?,LOGIN=?,MDP=?,IDROLE=? WHERE IDUSER=?");
			objetVersEnregistrement(utilisateur);
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