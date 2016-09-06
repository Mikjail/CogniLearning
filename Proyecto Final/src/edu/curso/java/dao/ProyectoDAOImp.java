package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Usuario;

@Repository
public class ProyectoDAOImp implements ProyectoDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public Long crearNuevoProyecto(Proyecto proyecto) {
		return (Long) sessionFactory.getCurrentSession().save(proyecto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> listarProyectos() {
		String hql = "from Proyecto as p order by p.nombre";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
	}

	@Override
	public Proyecto recuperarProyectoPorId(Long id) {
		
		return (Proyecto)sessionFactory.getCurrentSession().load(Proyecto.class,id);
	}

	@Override
	public void actualizarProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(proyecto);
	}



	@Override
	public Long guardarProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return (Long) sessionFactory.getCurrentSession().save(proyecto);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> recuperarProyectosPorNombre(String nombre) {
		// TODO Auto-generated method stub
		String hql = "from Proyecto as p where p.nombre LIKE :nombre";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("nombre","%" + nombre + "%");
		return query.list();
	}
	
	

}
