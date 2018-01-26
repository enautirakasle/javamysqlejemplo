package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioModelo extends Conector{

	public void insert(Usuario usuario) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO usuarios (nombre, apellido, edad) values(?,?,?)");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setInt(3, usuario.getEdad());
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
