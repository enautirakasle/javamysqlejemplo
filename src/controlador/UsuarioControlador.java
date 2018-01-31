package controlador;

import java.sql.SQLException;
import java.sql.Statement;

import modelo.Usuario;
import modelo.UsuarioModelo;
import vista.UsuarioVista;

public class UsuarioControlador {
	private UsuarioModelo usuarioModelo;
	private UsuarioVista usuarioVista;

	public UsuarioControlador(UsuarioModelo usuarioModelo, UsuarioVista usuarioVista) {
		this.usuarioModelo = usuarioModelo;
		this.usuarioVista = usuarioVista;
	}

	public void insertar(Usuario usuario) {
		usuarioModelo.insert(usuario);
		
	}
}
