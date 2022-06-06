package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	public static final String DRIVER_CLASS = "org.postgresql.Driver"; 
	public static final String URL = "jdbc:postgresql://localhost/db_briefe5";
	public static final String USER = "postgres";
	public static final String PASSWORD = "nawan";
	
	//private constructor
   public Connexion() {
        try {
            //Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    public static Connection createConnection() {
 
    	Connection connection = null;
        try {
            //Step 3: Establish Java MySQL connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERREUR : Imposssible de se connecter a la base de donnee.");
        }
        return connection;
    }   
     
	public static Connection getConnection() {
		try {
			//System.out.println("Connexion a la base de donnee reussie");
			return Connexion.createConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

}
