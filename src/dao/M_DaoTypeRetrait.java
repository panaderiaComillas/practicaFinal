package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.M_TypeRetrait;

public class M_DaoTypeRetrait extends M_DaoGenerique {
	
	private void objetVersEnregistrement(M_TypeRetrait typeRetrait) throws SQLException {
		prepStatement.setString(1, typeRetrait.getNomTypeRetrait());
	}

	private M_TypeRetrait enregistrementVersObjet(ResultSet result) throws SQLException {
		M_TypeRetrait typeRetrait;
		typeRetrait = new M_TypeRetrait(result.getInt("idTypeRetrait"), result.getString("nomTypeRetrait"));
		return typeRetrait;
	}
	
	public void insertTypeRetrait(M_TypeRetrait typeRetrait) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO TYPERETRAIT(NOMTYPERETRAIT) VALUES(?)");
			objetVersEnregistrement(typeRetrait);
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

	public M_TypeRetrait getTypeRetraitByID(int id) {
		M_TypeRetrait typeRetrait = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM TYPERETRAIT WHERE IDTYPERETRAIT=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			typeRetrait = enregistrementVersObjet(result);
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
		return typeRetrait;
	}
	
	public List<M_TypeRetrait> getTypesRetrait() {
		List<M_TypeRetrait> typesRetrait = new ArrayList<M_TypeRetrait>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement(
					"SELECT * FROM SANDWICH S INNER JOIN PRODUIT P ON S.IDPRODUIT=P.IDPRODUIT");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_TypeRetrait typeRetrait = enregistrementVersObjet(result);
				typesRetrait.add(typeRetrait);
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
		return typesRetrait;
	}

	public M_TypeRetrait updateTypeRetrait(M_TypeRetrait typeRetrait) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection
					.prepareStatement("UPDATE TYPERETRAIT SET NOMTYPERETRAIT=? WHERE IDTYPERETRAIT=?");
			objetVersEnregistrement(typeRetrait);
			prepStatement.setInt(2, typeRetrait.getIdTypeRetrait());
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
		return typeRetrait;
	}
}