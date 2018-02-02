package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Usuario;
import modelo.UsuarioModelo;

public class UsuarioVista {

	static final int LISTAR = 1;
	static final int INSERTAR = 2;
	static final int SALIR = 0;

	public void menuDeUsuario() {
		Scanner scan = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("--Menu de usuarios--");
			System.out.println(LISTAR + " - listar");
			System.out.println(INSERTAR + " - insertar");
			System.out.println(SALIR + " - salir");
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case LISTAR:
				UsuarioModelo usuarioModelo = new UsuarioModelo();
				ArrayList<Usuario> usuarios = usuarioModelo.selectAll();
				this.mostrarUsuarios(usuarios);
				break;
			case INSERTAR:

				break;
			default:
				break;
			}
		} while (opcion != SALIR);
	}
	
	public void mostrarUsuarios(ArrayList<Usuario> usuarios){
		Iterator<Usuario> i = usuarios.iterator();
		while(i.hasNext()){
			Usuario usuario = i.next();
			this.mostrarUsuario(usuario);
		}
		
	}
	
	public void mostrarUsuario(Usuario usuario){
		System.out.println(usuario.getId()+ "\t - "+
				usuario.getApellido()+ "\t - "+
				usuario.getApellido()+ "\t - "+
				usuario.getEdad());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
