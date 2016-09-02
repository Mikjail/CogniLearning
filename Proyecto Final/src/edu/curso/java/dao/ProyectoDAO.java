package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Proyecto;

public interface ProyectoDAO {

	public Long crearNuevoProyecto(Proyecto proyecto);
	public List<Proyecto> listarProyectos();
	public Proyecto recuperarProyectoPorId(Long id);
	public void actualizarProyecto(Proyecto proyecto);
	public Long guardarProyecto(Proyecto proyecto);
	
	
}
