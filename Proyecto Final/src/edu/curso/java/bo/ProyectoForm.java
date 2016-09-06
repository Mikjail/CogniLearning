package edu.curso.java.bo;

public class ProyectoForm {

	private Long id;
	private String nombre;
	private String descripcion;
	private Long idUsuarioPrincipal;
	private boolean activo;
	private Long[] idUsuarios;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Long getIdUsuarioPrincipal() {
		return idUsuarioPrincipal;
	}
	public void setIdUsuarioPrincipal(Long idUsuarioPrincipal) {
		this.idUsuarioPrincipal = idUsuarioPrincipal;
	}
	public Long[] getIdUsuarios() {
		// TODO Auto-generated method stub
		return idUsuarios;
	}	
	public void setIdUsuarios(Long[] idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	
}
