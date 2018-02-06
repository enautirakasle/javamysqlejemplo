package vista;

import java.util.Scanner;

public class PrestamoVista {

	static final int TOMAR_PRESTADO = 1;
	static final int ENTREGAR = 2;
	static final int SALIR = 0;
	
	public void menuPrestamo(){
		int opcion;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("--Prestamos--");
			System.out.println(TOMAR_PRESTADO + " tomar prestado un libro");
			System.out.println(ENTREGAR + " entregar un libro");
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case TOMAR_PRESTADO:
				
				break;
			case ENTREGAR:
				
				break;
			default:
				break;
			}
			
		}while(opcion != SALIR);	
	}
}
