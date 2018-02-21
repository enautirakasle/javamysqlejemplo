package comparador;

import java.util.Comparator;

import modelo.Prestamo;

public class TituloComparator implements Comparator<Prestamo> {

	@Override
	public int compare(Prestamo p1, Prestamo p2) {
		return p1.getLibro().getTitulo().compareTo(p2.getLibro().getTitulo());
	}

}
