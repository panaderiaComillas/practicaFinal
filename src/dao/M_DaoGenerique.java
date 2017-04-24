package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class M_DaoGenerique {

	protected static String url = "jdbc:mysql://localhost:3306/boulangeriePA";
	protected static String user = "root";
	protected static String password = "";

	protected Connection connection = null;
	protected PreparedStatement prepStatement = null;
	
	public M_DaoGenerique() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}