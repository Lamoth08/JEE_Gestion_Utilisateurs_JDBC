package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	
	private static final String DATABASE = "jdbc:mysql://localhost:3306/ecole";
	private static final String USER = "root";
	private static final String PASSWORD ="";
	
	private static Connection conn = null ;
	
	public static Connection getConnexion() {
		if(conn == null){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(DATABASE,USER,PASSWORD);
				System.out.println("Connected");
			} catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.out.println("Echec de connexion");
				
			}
		}
		
		return conn ;
	}
	
	public static void closeConnexion() throws SQLException {
		conn.close();
	}
	
	
	  /*public static void main(String []args) {
	  		Connection conn = Connexion.getConnexion(); }
	  */
	 
}
