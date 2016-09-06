<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/general/template_top.jsp" />
<form class="navbar-form navbar-left" role="search">
  <div class="form-group">
    <input type="text" class="form-control" placeholder="Search">
  </div>
  <button type="submit" class="btn btn-success">Submit</button>
</form>
<div class='btn-toolbar pull-right'>
    <div class='btn-group'>
      <a href="nuevousuario.html" class="btn btn-default">Nuevo</a>
    </div>
  </div>
<h1>Listado de Usuarios</h1>
            <div class="table-responsive">
              <table class="table table-condensed table-hover table-striped table-bordered">
                    <thead>
                      <tr>
                        <th style="text-align: center;">Id</th>
                        <th style="text-align: center;">Usuario</th>
                        <th style="text-align: center;">Nombre Completo</th>
                        <th style="text-align: center;">Activo</th>
                      	<th style="text-align: center;">Mostrar</th>
                      	<th style="text-align: center;">Editar</th>
                      	<th style="text-align: center;">Borrar</th>
                      	
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${usuarios}" var="u">
                    <tr>
                    	<td>${u.id}</td>
                    	<td>${u.usuario}</td>
                    	<td>${u.nombreCompleto}</td>
                    	<td>${u.activo}</td>
                    	<td><a href="verusuario.html?id=${u.id}" class="btn btn-default">Ver</a></td>
                   		<td><a href="editarusuario.html?id=${u.id}" class="btn btn-success">Editar</a></td>
                   		<td><a href="borrarusuario.html?id=${u.id}" class="btn btn-danger">Borrar</a></td>
                    </tr>
                    </c:forEach>
                 </tbody>
              </table>
			</div>
			
<c:import url="/general/template_bottom.jsp" />