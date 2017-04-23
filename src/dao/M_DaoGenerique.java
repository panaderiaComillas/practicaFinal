package dao;

public class M_DaoGenerique {

	protected static String url = "jdbc:mysql://localhost:3306/boulangeriePA";
	protected static String user = "root";
	protected static String password = "";

	public M_DaoGenerique() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}