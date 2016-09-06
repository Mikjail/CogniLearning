<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/general/template_top.jsp" />


<div class='page-header'>
  <div class='btn-toolbar pull-right'>
    <div class='btn-group'>
      <a href="listar.html" class="btn btn-default">Volver</a>
    </div>
  </div>
  <h2>Form Proyecto</h2>
</div>
<script type="text/javascript">
$(function() {
	$('#proyectoForm').validate();
	$(".js-example-basic-multiple ").select2();
	
});
</script>


<form:form id="formBuscar" method="post" modelAttribute="buscarNombre" 
         class="navbar-form navbar-left" role="search"
         action="buscarNombre.html">
		  <div class="form-group">
		    <input type="text" class="form-control" placeholder="Search">
		  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		</form:form>

<form:form id="proyectoForm" method="post" modelAttribute="proyectoForm"
	action="guardarproyecto.html">
	<form:input path="id" type="hidden" />
	<div class="form-group">
		<label for="nombre">Nombre</label>
		<form:input path="nombre" class="form-control  required" type="text" />
	</div>

	<div class="form-group">
		<label for="descripcion">Descripcion</label>
		<form:textarea path="descripcion" class="form-control required" type="text" />
	</div>

	<div class="form-group">
		<label for="usuarioPrincipal">Usuario principal</label>
		<form:select path="idUsuarioPrincipal"
			class="js-example-basic-multiple" 
			items="${usuarios}"
			itemLabel="nombreCompleto"
			itemValue="id"
			 />
	</div>

	<div class="form-group">
		<label for="idUsuarios">Usuarios</label>
		<form:select multiple="true" path="idUsuarios" 
			class="js-example-basic-multiple"
			items="${usuarios}"
			itemLabel="nombreCompleto"
			itemValue="id"
			 />
	</div>

	<div class="checkbox">
		<label> <form:checkbox path="activo" /> Activo
		</label>
	</div>

	<input type="submit" class="btn btn-default" value="Guardar">
</form:form>



<c:import url="/general/template_bottom.jsp" />