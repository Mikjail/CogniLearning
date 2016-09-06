function buscar() {
	var datos = $("#miForm").serialize();
	$.post("buscarNombreUsuario.html", datos, function(resp) {
		$("#resultado").html(resp);
	});
}