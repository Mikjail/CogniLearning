package edu.curso.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.bo.*;
import edu.curso.java.dao.ProyectoDAO;
import edu.curso.java.dao.UsuarioDAO;

@Service
@Transactional
public class ProyectoServiceImp implements ProyectoService {

	@Autowired
	ProyectoDAO proyectoDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	
	@Override
	public List<Proyecto> listarProyectos() {
		return proyectoDAO.listarProyectos();
	}

	@Override
	public Proyecto recuperarProyectoPorId(Long id) {
		// TODO Auto-generated method stub
		return proyectoDAO.recuperarProyectoPorId(id);
	}

	@Override
	public Long crearNuevoProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return proyectoDAO.crearNuevoProyecto(proyecto);
	}

	@Override
	public void actualizarProyecto(Proyecto proyecto) {
		proyectoDAO.actualizarProyecto(proyecto);
	}
	
	@Override
	public Long guardarProyecto(Proyecto proyecto, Long idUsuarioPrincipal, Long[] idUsuarios) {
		// TODO Auto-generated method stub
		Usuario usuarioPrincipal = usuarioDAO.recuperarUsuarioPorId(idUsuarioPrincipal);
				
		for (Long idUsuario : idUsuarios) {
			proyecto.getUsuarios().add(usuarioDAO.recuperarUsuarioPorId(idUsuario));
		}
		
		proyecto.setUsuarioPrincipal(usuarioPrincipal);
		proyecto.setId(proyectoDAO.guardarProyecto(proyecto));
		return proyecto.getId();
		
	}

	@Override
	public void actualizarProyecto(Proyecto proyecto, Long idUsuarioPrincipal, Long[] idUsuarios) {
		// TODO Auto-generated method stub
		Usuario usuarioPrincipal = usuarioDAO.recuperarUsuarioPorId(idUsuarioPrincipal);
		proyecto.getUsuarios().clear();
		
		for (Long idUsuario : idUsuarios) {
			proyecto.getUsuarios().add(usuarioDAO.recuperarUsuarioPorId(idUsuario));
		}
		
		proyecto.setUsuarioPrincipal(usuarioPrincipal);
		proyectoDAO.actualizarProyecto(proyecto);
	}

	@Override
	public List<Usuario> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stu
		return proyectoDAO.recuperarProyectosPorNombre(nombre);
		
		
	}

	
}
