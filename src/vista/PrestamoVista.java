package vista;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import javax.management.modelmbean.ModelMBeanOperationInfo;

import comparador.TituloComparator;
import modelo.Libro;
import modelo.LibroModelo;
import modelo.Prestamo;
import modelo.PrestamoModelo;
import modelo.Usuario;
import modelo.UsuarioModelo;

public class PrestamoVista {

	static final int TOMAR_PRESTADO = 1;
	static final int ENTREGAR = 2;
	static final int LISTAR = 3;
	static final int SALIR = 0;
	static final int TITULO = 1;
	private static final int FECHA_PRESTAMO = 3;

	public void menuPrestamo() {
		int opcion;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("--Prestamos--");
			System.out.println(TOMAR_PRESTADO + " tomar prestado un libro");
			System.out.println(ENTREGAR + " entregar un libro");
			System.out.println(LISTAR + " listar prestamos");
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case TOMAR_PRESTADO:
				realizarPrestamo(scan);
				break;
			case ENTREGAR:
				entregarLibro(scan);
			case LISTAR:
				PrestamoModelo prestamoModelo = new PrestamoModelo();
				ArrayList<Prestamo> prestamos = prestamoModelo.selectAll();
				mostrarPrestamos(prestamos);
				menuOrdenacionPrestamos(scan, prestamos);

				break;
			default:
				break;
			}

		} while (opcion != SALIR);
	}

	private void menuOrdenacionPrestamos(Scanner scan, ArrayList<Prestamo> prestamos) {
		System.out.println("Ordenar por:");
		System.out.println(TITULO + "- titulo: "+FECHA_PRESTAMO + "-fecha prestamo" + SALIR + "- salir");
		int opcion = Integer.parseInt(scan.nextLine());
		do {
			switch (opcion) {
			case TITULO:
				prestamos.sort(new TituloComparator());
				this.mostrarPrestamos(prestamos);
				break;
			case FECHA_PRESTAMO:
				prestamos.sort(new FechaPrestamoComparator());
				this.mostrarPrestamos(prestamos);
				break;
			default:
				break;
			}
		} while (opcion != SALIR);

	}

	private void mostrarPrestamos(ArrayList<Prestamo> prestamos) {
		Iterator<Prestamo> i = prestamos.iterator();
		while (i.hasNext()) {
			mostrarPrestamo(i.next());
		}

	}

	private void mostrarPrestamo(Prestamo prestamo) {
		System.out.println(prestamo.getLibro().getTitulo() + " : " + prestamo.getUsuario().getNombre() + " : "
				+ prestamo.getUsuario().getApellido() + " : " + prestamo.getFechaPrestamo() + " : "
				+ prestamo.getFechaLimite());

	}

	private void entregarLibro(Scanner scan) {
		// pedir el dni
		System.out.println("Introduce el dni del usuario");
		String dni = scan.nextLine();
		// conseguir el usuario
		UsuarioModelo usuarioModelo = new UsuarioModelo();
		Usuario usuario = usuarioModelo.selectPorDni(dni);
		// pedir el titulo
		System.out.println("Introduce el titulo del libro");
		String tituloLibro = scan.nextLine();
		// conseguir el libro
		LibroModelo libroModelo = new LibroModelo();
		Libro libro = libroModelo.selectPorTitulo(tituloLibro);

		// conseguir el prestamo de la BBDD
		PrestamoModelo prestamoModelo = new PrestamoModelo();
		Prestamo prestamo = prestamoModelo.prestamoNoFinalizado(libro, usuario);
		// cambiar el objeto prestamo a entregado
		prestamo.setEntregado(true);

		// hacer el update en la BBDD
		prestamoModelo.update(prestamo);

		System.out.println("El libro " + libro.getTitulo() + " ha sido entregado.");
	}

	private void realizarPrestamo(Scanner scan) {
		System.out.println("Introduce el titulo del libro");
		String titulo = scan.nextLine();
		LibroModelo libroModelo = new LibroModelo();
		Libro libro = libroModelo.selectPorTitulo(titulo);

		if (libro != null) {// el libro existe
			System.out.println("Introduce el DNI");
			String dni = scan.nextLine();
			UsuarioModelo usuarioModelo = new UsuarioModelo();
			Usuario usuario = usuarioModelo.selectPorDni(dni);

			// crear el objeto prestamo
			Prestamo prestamo = new Prestamo();

			prestamo.setLibro(libro);
			prestamo.setUsuario(usuario);

			Date fechaPrestamo = new Date();
			// limite es el dia de hoy mas 21 dias
			Date fechaLimite = new Date(fechaPrestamo.getTime() + (21 * 24 * 60 * 60 * 1000));
			prestamo.setFechaPrestamo(fechaPrestamo);
			prestamo.setFechaLimite(fechaLimite);

			// Calendar calendario = Calendar.getInstance();
			// calendario.setTime(fechaPrestamo);
			// calendario.add(Calendar.DATE, 21);
			// fechaLimite = calendario.getTime();

			prestamo.setEntregado(false);

			// crear el objeto modeloprestamo
			PrestamoModelo prestamoModelo = new PrestamoModelo();
			// insertar prestamo utilizando modeloPrestamo
			prestamoModelo.insertar(prestamo);
			System.out.println("Prestamo realizado");

		} else {// el libro no existe
			System.out.println("Prestamo no realizado, el libro no existe");
		}

	}

}
