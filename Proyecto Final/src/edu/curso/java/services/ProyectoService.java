package edu.curso.java.services;

import java.util.List;

import edu.curso.java.bo.Proyecto;

public interface ProyectoService {

	List<Proyecto> listarProyectos();

	Proyecto recuperarProyectoPorId(Long id);

	Long crearNuevoProyecto(Proyecto proyecto);

	void actualizarProyecto(Proyecto proyecto);

	Long guardarProyecto(Proyecto proyecto, Long idUsuarioPrincipal, Long[] idUsuarios);

	void actualizarProyecto(Proyecto proyecto, Long idUsuarioPrincipal, Long[] idUsuarios);

}