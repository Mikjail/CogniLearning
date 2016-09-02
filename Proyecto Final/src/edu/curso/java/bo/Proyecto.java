package edu.curso.java.bo;

import java.util.*;

import javax.persistence.*;

@Entity
public class Proyecto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String descripcion;
	@ManyToMany
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private boolean activo;
	@ManyToOne
	private Usuario usuarioPrincipal;

	@OneToMany
	private List<Tarea> tareas = new ArrayList<Tarea>();


	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long b) {
		this.id = b;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public Usuario getUsuarioPrincipal() {
		return usuarioPrincipal;
	}

	public void setUsuarioPrincipal(Usuario usuarioPrincipal) {
		this.usuarioPrincipal = usuarioPrincipal;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}	
}
