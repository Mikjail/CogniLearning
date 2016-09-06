package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Usuario;

public interface ProyectoDAO {

	public Long crearNuevoProyecto(Proyecto proyecto);
	public List<Proyecto> listarProyectos();
	public Proyecto recuperarProyectoPorId(Long id);
	public void actualizarProyecto(Proyecto proyecto);
	public Long guardarProyecto(Proyecto proyecto);
	public List<Usuario> recuperarProyectosPorNombre(String nombre);
	
	
}
