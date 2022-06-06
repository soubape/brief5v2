package briefe5;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexion {
	public static final String DRIVER_CLASS = "org.postgresql.Driver"; 
	public static final String URL = "jdbc:postgresql://localhost/db_briefe5";
	public static final String USER = "postgres";
	public static final String PASSWORD = "nawan";
	private static Connection connexion;
	
	static {
		try {
			Class.forName(DRIVER_CLASS);
			connexion = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Connexion a la base de donnees reussie");
	}
	catch(Exception e){
		e.getStackTrace();
	}
}
	public static Connection getConnection() {
		return connexion;
	}
		
}
