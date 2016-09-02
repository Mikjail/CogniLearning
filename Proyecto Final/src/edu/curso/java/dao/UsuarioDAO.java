package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Usuario;

public interface UsuarioDAO {

	Long guardarUsuario(Usuario usuario);

	Usuario recuperarUsuarioPorId(Long id);

	List<Usuario> recuperarUsuarios();

	void actualizarUsuario(Usuario usuario);

	void borrarUsuario(Long id);
}