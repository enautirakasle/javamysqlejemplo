package vista;

import java.util.Scanner;

import controlador.UsuarioControlador;
import modelo.Usuario;
import modelo.UsuarioModelo;

public class MenuUsuario {
	final static int SALIR = 0;
	final static int CREAR = 1;
	final static int LISTAR = 2;
	final static int EDITAR = 3;
	final static int ELIMINAR = 4;
	
	Scanner scan = new Scanner(System.in);
	UsuarioControlador usuariocontrolador = new UsuarioControlador();

	public void menuPrincipal() {
		int opcion;
		
		do {
			System.out.println("-- Menu principal --");
			System.out.println(CREAR + " - crear usuario");
			System.out.println(LISTAR + " - listar usuarios");
			System.out.println(EDITAR + " - editar datos de usuario");
			System.out.println(ELIMINAR + " - eliminar usuario");

			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case CREAR:
				Usuario usuario = this.menuInsertarUsuario();
				UsuarioModelo usuarioModelo = new UsuarioModelo();
				usuarioModelo.insert(usuario);
				break;
			case LISTAR:

				break;

			case EDITAR:

				break;

			case ELIMINAR:

				break;

			default:
				break;
			}
		} while (opcion != SALIR);
	}

	private Usuario menuInsertarUsuario() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un nombre");
		String nombre = scan.nextLine();
		System.out.println("Introduce un apellido");
		String apellido = scan.nextLine();
		System.out.println("Introduce una edad");
		int edad = Integer.parseInt(scan.nextLine());
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEdad(edad);
		return usuario;
		
	}
	
	
	
}
