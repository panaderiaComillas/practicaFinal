package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.M_Ingredient;

public class M_DaoIngredient extends M_DaoGenerique {

	private void objetVersEnregistrement(M_Ingredient ingredient) throws SQLException {
		prepStatement.setString(1, ingredient.getNomIngredient());
	}

	private M_Ingredient enregistrementVersObjet(ResultSet result) throws SQLException {
		M_Ingredient ingredient;
		ingredient = new M_Ingredient(result.getInt("idIngredient"), result.getString("nomIngredient"));
		return ingredient;
	}

	public void insertBoisson(M_Ingredient ingredient) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO INGREDIENT(NOMINGREDIENT) VALUES(?)");
			objetVersEnregistrement(ingredient);
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
			prepStatement = connection.prepareStatement("SELECT * FROM INGREDIENT WHERE IDINGREDIENT=?");
			prepStatement.setInt(1, id);
			result = prepStatement.executeQuery();
			result.next();
			ingredient = enregistrementVersObjet(result);
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

	public List<M_Ingredient> getIngredients() {
		List<M_Ingredient> ingredients = new ArrayList<M_Ingredient>();
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("SELECT * FROM INGREDIENT");
			result = prepStatement.executeQuery();
			while (result.next()) {
				M_Ingredient ingredient = enregistrementVersObjet(result);
				ingredients.add(ingredient);
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
		return ingredients;
	}

	public M_Ingredient updateIngredient(M_Ingredient ingredient) {
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("UPDATE INGREDIENT SET NOMINGREDIENT=? WHERE IDINGREDIENT=?");
			objetVersEnregistrement(ingredient);
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