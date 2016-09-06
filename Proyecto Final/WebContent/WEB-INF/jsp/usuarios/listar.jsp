<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/general/template_top.jsp" />

<script type="text/javascript">
$(".js-example-basic-multiple").select2();

</script>


<div class="row">	
<h1>Usuarios</h1>
 
<form id="miForm" style="float: left;" method="post" onsubmit="buscar(); return false;" class="navbar-form navbar-left" role="search">
  <div class="form-group">
    <input type="text" name="nombre" class="form-control" placeholder="Search">
  </div>
  <button type="submit" class="btn btn-success">Buscar</button>
</form>

    <div class='btn btn-default'>
      <a href="nuevousuario.html" class="btn btn-default">Nuevo</a>
    </div>

    <div id="resultado">
    </div>

</div>
<c:import url="/general/template_bottom.jsp" />