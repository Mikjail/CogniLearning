<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />
<div class='page-header'>
  <div class='btn-toolbar pull-right'>
    <div class='btn-group'>
      <a href="listar.html" class="btn btn-default">Volver</a>
    </div>
  </div>
  <h2>Usuario Modificado</h2>
</div>

		<table class="table table-condensed table-hover table-striped table-bordered">
                    <thead>
                      <tr>
                        <th style="text-align: center;">Id</th>
                        <th style="text-align: center;">Usuario</th>
                        <th style="text-align: center;">Nombre Completo</th>
                        <th style="text-align: center;">Activo</th>
                      </tr>
                    </thead>
                    <tbody>
                    <tr>
                    	<td>${usuario.id}</td>
                    	<td>${usuario.usuario}</td>
                    	<td>${usuario.nombreCompleto}</td>
                    	<td>${usuario.activo}</td>
                    </tr>
                 </tbody>
              </table>
		
			

<c:import url="/general/template_bottom.jsp" />