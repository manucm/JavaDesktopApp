package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.manuelprg.app.util.AppConstants;

public class Conexion {

	private Connection connection;
	private static Conexion conexion;

	public Conexion() throws ClassNotFoundException, SQLException {
		
		

		Class.forName(AppConstants.DB_DRIVERS_MYSQL);
		setConnection(DriverManager.getConnection(StringConnectionBuilder(),
												 AppConstants.DB_USER,
												 AppConstants.DB_PASSWORD));
	}
	
	public static Conexion getInstanceConnection() throws ClassNotFoundException, SQLException {
		
		if (conexion == null) {
			conexion = new Conexion();
		}
		return conexion;
		
	}
	
	private String StringConnectionBuilder() {
		
		return new StringBuilder().append(AppConstants.MYSQL)
								  .append(AppConstants.DB_HOST)
								  .append("/")
								  .append(AppConstants.DATABASE_NAME).toString();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}


}
