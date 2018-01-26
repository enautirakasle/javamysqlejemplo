import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		try {
			//se carga el diver
			Class.forName("com.mysql.jdbc.Driver");
			//crear la connexion con la BBDD biblioteca
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
			
			//statement para ejecutar querys
			Statement st = con.createStatement();
			
			//ejecutar query
//			ResultSet rs = st.executeQuery("select * from usuarios");
			
			//imprimir en pantalla el resultado de la consulta
//			while (rs.next()) {
//				System.out.println(rs.getInt("id") + " "
//						+ rs.getString("nombre")
//						+ " " + rs.getString("apellido") + " "
//						+ rs.getInt("edad"));
//			}

			//ejecutar un insert
			//st.execute("INSERT INTO usuarios(nombre, apellido, edad) VALUES ('mauricio', 'diaz', 19)");

			//pedir datos por pantalla
			Scanner scan = new Scanner(System.in);
			System.out.println("Introduce un nombre");
			String nombre = scan.nextLine();
			System.out.println("Introduce un apellido");
			String apellido = scan.nextLine();
			System.out.println("Introduce una edad");
			int edad = Integer.parseInt(scan.nextLine());
			
//			String sql = "INSERT INTO usuarios (nombre, apellido, edad) values('" +nombre+ "','" +apellido+"',"+edad+")";
//			st.execute(sql);
			
			PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios (nombre, apellido, edad) values(?,?,?)");
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setInt(3, edad);
			
			pst.execute();
	

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
