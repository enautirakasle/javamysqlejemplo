package vista;

import java.util.Comparator;

import modelo.Prestamo;

public class FechaPrestamoComparator implements Comparator<Prestamo> {

	@Override
	public int compare(Prestamo p1, Prestamo p2) {
		return p1.getFechaPrestamo().compareTo(p2.getFechaPrestamo());
	}

}
