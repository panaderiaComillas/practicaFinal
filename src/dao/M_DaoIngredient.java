package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.M_Ingredient;

public class M_DaoIngredient extends M_DaoGenerique{

	public void insertBoisson(M_Ingredient ingredient) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO INGREDIENT(NOMINGREDIENT) VALUES(?)");
			prepStatement.setString(1, ingredient.getNomIngredient());
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

	public M_Ingredient getIngredientByID(int id) {
		M_Ingredient ingredient = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM BOISSON WHERE IDPRODUIT=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			ingredient = new M_Ingredient(id, result.getString("nomIngredient"));
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
		return ingredient;
	}

	public M_Ingredient updateIngredient(M_Ingredient ingredient) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE BOISSON SET NOMPRODUIT=? WHERE IDPRODUIT=?");
			prepStatement.setString(1, ingredient.getNomIngredient());
			prepStatement.setInt(2, ingredient.getIdIngredient());
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
		return ingredient;
	}

}