package edu.curso.java.services;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.bo.Usuario;
import edu.curso.java.dao.UsuarioDAO;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	private static final Logger log = Logger.getLogger(UsuarioService.class);
	
	/* (non-Javadoc)
	 * @see edu.curso.java.services.UsuarioService#crearNuevoUsuario(edu.curso.java.bo.Usuario)
	 */
	@Override
	public long crearNuevoUsuario(Usuario usuario){
		log.info("Creando usuario");
		usuario.setActivo(true);
		return usuarioDAO.guardarUsuario(usuario);
	}
	
	/* (non-Javadoc)
	 * @see edu.curso.java.services.UsuarioService#recuperarUsuarios()
	 */
	@Override
	public List<Usuario> recuperarUsuarios(){
		return usuarioDAO.recuperarUsuarios();
	}
	
	/* (non-Javadoc)
	 * @see edu.curso.java.services.UsuarioService#recuperarUsuarioPorID(java.lang.Long)
	 */
	@Override
	public Usuario recuperarUsuarioPorID(Long id){
		log.info("Ingresando a recuperar datos por id");
		return usuarioDAO.recuperarUsuarioPorId(id);
	}
	
	@Override
	public void actualizarUsuario(Usuario usuario) {
		usuarioDAO.actualizarUsuario(usuario);
	}

	@Override
	public void borrarUsuario(Long id) {
		// TODO Auto-generated method stub
		
		usuarioDAO.borrarUsuario(id);
	}

	@Override
	public List<Usuario> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return usuarioDAO.buscarPorNombre(nombre);
	}

	
	
	
}
