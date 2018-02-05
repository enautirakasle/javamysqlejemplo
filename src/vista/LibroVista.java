package vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Libro;
import modelo.LibroModelo;

public class LibroVista {
	static final int LISTAR = 1;
	static final int INSERTAR = 2;
	static final int SALIR = 0;

	public void menuDeUsuario() {
		Scanner scan = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("--Menu de Libros--");
			System.out.println(LISTAR + " - listar");
			System.out.println(INSERTAR + " - insertar");
			System.out.println(SALIR + " - salir");
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case LISTAR:
				LibroModelo libroModelo = new LibroModelo();
				ArrayList<Libro> libros = libroModelo.selectAll();
				this.mostrarLibros(libros);
				break;
			case INSERTAR:
				Libro libro = scanLibro(scan);
				libroModelo = new LibroModelo();
				libroModelo.insert(libro);
				break;
			default:
				break;
			}
		} while (opcion != SALIR);
	}
	
	private Libro scanLibro(Scanner scan) {
		
		Libro libro = new Libro();
		System.out.println("Introduce titulo");
		libro.setTitulo(scan.nextLine());
		
		System.out.println("Introduce autor");
		libro.setAutor(scan.nextLine());
		
	
		
		return libro;
	}

	public void mostrarLibros(ArrayList<Libro> libros){
		Iterator<Libro> i = libros.iterator();
		while(i.hasNext()){
			Libro libro = i.next();
			this.mostrarLibro(libro);
		}
		
	}
	
	public void mostrarLibro(Libro libro){
		System.out.println(libro.getId()+ "\t - "+
				libro.getTitulo()+ "\t - "+
				libro.getAutor());
	}
}
