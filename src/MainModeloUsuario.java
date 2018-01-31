import java.util.Scanner;

import modelo.Usuario;
import modelo.UsuarioModelo;

public class MainModeloUsuario {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Inserte un nombre");
		String nombre = scan.nextLine();
		
		String apellido = "Badiola";
		
		int edad = 33;
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEdad(edad);
		
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		usuarioModelo.insert(usuario);

	}

}
