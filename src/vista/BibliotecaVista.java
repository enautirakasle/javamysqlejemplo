package vista;

import java.util.Scanner;

public class BibliotecaVista {
	static final int GESTIONAR_USUARIOS = 1;
	static final int GESTIONAR_LIBROS = 2;
	static final int GESTIONAR_PRESTAMOS = 3;
	static final int SALIR = 0;
	
	public void menuBiblioteca(){
		LibroVista libroVista = new LibroVista();
		UsuarioVista usuarioVista = new UsuarioVista();
		PrestamoVista prestamoVista = new PrestamoVista();
		
		int opcion;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("--Biblioteca--");
			System.out.println(GESTIONAR_LIBROS + " gestor de libros");
			System.out.println(GESTIONAR_USUARIOS + " gestor de usuarios");
			System.out.println(GESTIONAR_PRESTAMOS + " gestor de prestamos");
			
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case GESTIONAR_LIBROS:
//				LibroVista libroVista = new LibroVista();
				libroVista.menuDeUsuario();
				break;
			case GESTIONAR_USUARIOS:
//				UsuarioVista usuarioVista = new UsuarioVista();
				usuarioVista.menuDeUsuario();
				break;
			case GESTIONAR_PRESTAMOS:
//				PrestamoVista prestamoVista = new PrestamoVista();
				prestamoVista.menuPrestamo();
				break;
			default:
				break;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}while(opcion != SALIR);
	}
}
