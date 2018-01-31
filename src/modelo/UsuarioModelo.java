package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioModelo extends Conector{

	public ArrayList<Usuario> selectAll(){
		//crear arrayList
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios");
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setEdad(rs.getInt("edad"));
				
				usuarios.add(usuario);
			}
			return usuarios;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario select(int id){
		//select * from usuarios where id = 7
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from usuarios where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setEdad(rs.getInt("edad"));
				return usuario;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}


	public void delete (int id){
		//delete from usuarios where id = 6
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("delete from usuarios where id = ?");
			pst.setInt(1, id);
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(Usuario usuario){
		//update usuarios set nombre='mikel', apellido='badiola', edad=32 where id=5
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update usuarios set nombre=?, apellido=?, edad=? where id=?");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setInt(3, usuario.getEdad());
			pst.setInt(4, usuario.getId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Usuario usuario) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO usuarios (nombre, apellido, edad) values(?,?,?)");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setInt(3, usuario.getEdad());
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public ArrayList<Usuario> selectPorNombre(String nombre){
		//crear arrayList
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				
				try {
					Statement st = super.conexion.createStatement();
					ResultSet rs = st.executeQuery("select * from usuarios where nombre = '" + nombre + "'");
					while(rs.next()){
						Usuario usuario = new Usuario();
						usuario.setId(rs.getInt("id"));
						usuario.setNombre(rs.getString("nombre"));
						usuario.setApellido(rs.getString("apellido"));
						usuario.setEdad(rs.getInt("edad"));
						
						usuarios.add(usuario);
					}
					return usuarios;
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return usuarios;
	}
	
	public ArrayList<Usuario> selectMenorDeEdad(){
		//crear arrayList
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				
				try {
					Statement st = super.conexion.createStatement();
					ResultSet rs = st.executeQuery("select * from usuarios where edad < 18");
					while(rs.next()){
						Usuario usuario = new Usuario();
						usuario.setId(rs.getInt("id"));
						usuario.setNombre(rs.getString("nombre"));
						usuario.setApellido(rs.getString("apellido"));
						usuario.setEdad(rs.getInt("edad"));
						
						usuarios.add(usuario);
					}
					return usuarios;
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return usuarios;
	}
	
	public ArrayList<Usuario> selectContieneEnApellido(String cadena){
		//SELECT * FROM `usuarios` WHERE apellido like '%za%'
		//crear arrayList
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				
				try {
					Statement st = super.conexion.createStatement();
					ResultSet rs = st.executeQuery("select * from usuarios where apellido like '%" + cadena + "%'");
					while(rs.next()){
						Usuario usuario = new Usuario();
						usuario.setId(rs.getInt("id"));
						usuario.setNombre(rs.getString("nombre"));
						usuario.setApellido(rs.getString("apellido"));
						usuario.setEdad(rs.getInt("edad"));
						
						usuarios.add(usuario);
					}
					return usuarios;
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return usuarios;
	}
	
	
	
	
	
}
