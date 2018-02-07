package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroModelo extends Conector {

	public ArrayList<Libro> selectAll() {

		ArrayList<Libro> libros = new ArrayList<Libro>();

		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros");
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));

				libros.add(libro);
			}
			return libros;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public Libro select(int id) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from libros where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Libro libro = new Libro();
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				return libro;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Libro selectPorTitulo(String titulo) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from libros where titulo = ?");
			pst.setString(1, titulo);
			ResultSet rs = pst.executeQuery();

			//si hemos recibido alguna fila
			if (rs.next()) {
				Libro libro = new Libro();
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				return libro;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int id) {

		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("delete from libros where id = ?");
			pst.setInt(1, id);

			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Libro libro) {

		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update libros set titulo=?, autor=? where id=?");
			pst.setString(1, libro.getTitulo());
			pst.setString(2, libro.getAutor());
			pst.setInt(3, libro.getId());

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Libro libro) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO libros (titulo, autor) values(?,?)");
			pst.setString(1, libro.getTitulo());
			pst.setString(2, libro.getAutor());

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
