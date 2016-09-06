<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />
<c:choose>
	<c:when test="${usuarioBuscado.size() > 0}" >             
	<div class="table-responsive col-md-8">
	        		<table class="table table-condensed table-hover table-striped table-bordered">
	                    <thead>
	                      <tr>
	                        <th style="text-align: center;">Id</th>
	                        <th style="text-align: center;">Usuario</th>
	                        <th style="text-align: center;">Nombre Completo</th>
	                        <th style="text-align: center;">Activo</th>                        
	                      	<th style="text-align: center;">Mostrar</th>
	                      	<th style="text-align: center;">Editar</th>
	                      	<th style="text-align: center;">Borrar</t>
	                      </tr>
	                    </thead>
	                    <tbody>
	                    <c:forEach items="${usuarioBuscado}" var="uB">
	                    <tr>
	                    	<td>${uB.id}</td>
	                    	<td>${uB.usuario}</td>
	                    	<td>${uB.nombreCompleto}</td>
	                    	<td>${uB.activo}</td>
	                    	<td><a href="verusuario.html?id=${uB.id}" class="btn btn-default">Ver</a></td>
	                   		<td><a href="editarusuario.html?id=${uB.id}" class="btn btn-success">Editar</a></td>
	                   		<td><a href="borrarusuario.html?id=${uB.id}" class="btn btn-danger">Borrar</a></td>
	                    </tr>
	                    </c:forEach>
	                 </tbody>
	              </table>
	        	</div>
	       </div>
	 </c:when>
	  <c:otherwise>
	   <h3>Usuario no encontrado</h3>	
	  </c:otherwise>
</c:choose> 