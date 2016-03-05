package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class main {

	public static void main(String[] args) {
		Connection conexion=null;

		try
		{
			conexion= Conexion.getInstanceConnection().getConnection();
			
			String sqlQuery = "select * from usuario where id_usuario = ?";
			PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(sqlQuery);
			ps.setString(1, "1");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("apellidos"));
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString(1));
				int inte = Integer.parseInt(rs.getString(1));
				++inte;
				System.out.println(inte);
			}
			
		}
		catch(ClassNotFoundException ex)
		{
			JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			conexion=null;
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			conexion=null;
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
			conexion=null;
		}
		finally
		{
			System.out.println("bloque finally");
		}
	}
}

