package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_TypeRetrait;

public class M_DaoTypeRetrait extends M_DaoGenerique {

	public void insertTypeRetrait(M_TypeRetrait typeRetrait) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO TYPERETRAIT(NOMTYPERETRAIT) VALUES(?)");
			prepStatement.setString(1, typeRetrait.getNomTypeRetrait());
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
			typeRetrait = new M_TypeRetrait(id, result.getString("nomTypeRetrait"));
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

	public M_TypeRetrait updateTypeRetrait(M_TypeRetrait typeRetrait) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection
					.prepareStatement("UPDATE TYPERETRAIT SET NOMTYPERETRAIT=? WHERE IDTYPERETRAIT=?");
			prepStatement.setString(1, typeRetrait.getNomTypeRetrait());
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