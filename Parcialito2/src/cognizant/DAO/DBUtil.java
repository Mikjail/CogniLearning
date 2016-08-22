package cognizant.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection recuperarConnection() 
			throws ClassNotFoundException, SQLException{
			
		String nombreDriver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3060/parcialito";
		
		Class.forName(nombreDriver);
		
		return DriverManager.getConnection(url, "root", "password");
		
		
	}

	public static void cerrarConnection(Connection connection){
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
