<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="table-responsive">
              <table class="table table-condensed table-hover table-striped table-bordered">
                    <thead>
		              <tr>
                        <th style="text-align: center;">Id</th>
                        <th style="text-align: center;">Descripcion</th>
                        <th style="text-align: center;">Usuarios</th>
                        <th style="text-align: center;">Usuario Ppal</th>
                        <th style="text-align: center;">Tareas</th>                      	
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${proyectos}" var="p">
                    <tr>
                    	<td>${p.id}</td>
                    	<td>${p.descripcion}</td>
                    	<td>
                    	<c:forEach items="${p.usuarios}" var="u">
                    	 <ul>
	                    	 <li>
	                    		 ${u.nombreCompleto}
	                    	 </li>
                    	 </ul>
                    	</c:forEach>
                    	</td>
                    	<td>${p.usuarioPrincipal.nombreCompleto}</td>
                    	<td>
                    	<c:forEach items="${proyecto.tareas}" var="t">
                    	 <ul>
	                    	 <li>
	                    		 ${t.titulo}
	                    	 </li>
                    	 </ul>
                    	</c:forEach>
                    	</td>
                    </tr>
                    </c:forEach>
                 </tbody>
              </table>