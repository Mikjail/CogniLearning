package edu.curso.java.services;

import java.util.List;

import edu.curso.java.bo.Usuario;

public interface UsuarioService {

	long crearNuevoUsuario(Usuario usuario);

	List<Usuario> recuperarUsuarios();

	Usuario recuperarUsuarioPorID(Long id);

	void actualizarUsuario(Usuario usuario);

	void borrarUsuario(Long id);

	List<Usuario> buscarPorNombre(String nombre);

}