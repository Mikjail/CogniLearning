<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" /> 
  <div class='btn-toolbar pull-right'>
    <div class='btn-group'>
      <a href="listar.html" class="btn btn-default">Volver</a>
    </div>
  </div>
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
                    
                    	<td>${proyecto.id}</td>
                    	<td>${proyecto.descripcion}</td>
                    	<td>
                    	<c:forEach items="${proyecto.usuarios}" var="u">
                    	 <ul>
	                    	 <li>
	                    		 ${u.nombreCompleto}
	                    	 </li>
                    	 </ul>
                    	</c:forEach>
                    	</td>
                    	<td>${proyecto.usuarioPrincipal.nombreCompleto}</td>
                    	<td>
                    	<c:forEach items="${proyecto.tareas}" var="t">
                    	 <ul>
	                    	 <li>
	                    		 ${t.titulo}
	                    	 </li>
                    	 </ul>
                    	</c:forEach>
                    	</td>
                    
                    </tbody>
                    
<c:import url="/general/template_bottom.jsp" />