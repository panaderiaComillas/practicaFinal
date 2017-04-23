package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class M_DaoUser extends M_DaoGenerique{

	public void insertContador(Contador contador) {
		Connection connection = null;
		PreparedStatement prepStatement = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			prepStatement = connection.prepareStatement("INSERT INTO ANTOINE.CONTADOR(ID,ESTILO) VALUES(?,?)");
			prepStatement.setString(1, contador.getId());
			prepStatement.setInt(2, contador.getEstilo());
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

	public Contador getContadorByID(String id) {
		Connection connection = null;
		PreparedStatement prepStatement = null;
		Contador contador = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection("jdbc:derby:C:/eclipse-jee-neon-2-win32/MyDB");
			prepStatement = connection.prepareStatement("SELECT ESTILO, VISITAS FROM ANTOINE.CONTADOR WHERE ID=?");
			prepStatement.setString(1, id);
			result = prepStatement.executeQuery();
			result.next();
			contador = new Contador(id, result.getInt("estilo"), result.getInt("visitas"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contador;
	}
	
	public Contador updateContador(Contador contador){
		Connection connection=null;
		PreparedStatement prepStatement=null;
		try {
			connection=DriverManager.getConnection("jdbc:derby:C:/eclipse-jee-neon-2-win32/MyDB");
			prepStatement=connection.prepareStatement("UPDATE ANTOINE.CONTADOR SET VISITAS=? WHERE ID=?");
			prepStatement.setInt(1, contador.getVisitas());
			prepStatement.setString(1, contador.getId());
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contador;
	}

}