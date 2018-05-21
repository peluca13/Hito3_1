package manejadoresDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class DatabaseManager {
	
	private static Connection databaseConnection;
	
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "PROYECTO";
	private static String CLAVE = "PROYECTO";
	
	static{
		try {
			Locale.setDefault(new Locale("en","EN"));
			databaseConnection = DriverManager.getConnection(CONNECTION_STRING,USUARIO,CLAVE);
		} catch (SQLException e) {
			System.out.println("Error creando la conexi�n a la base de datos");
		} 

	}
	
	public static Connection getConnection() {
		
		return databaseConnection;
		
	}

}
