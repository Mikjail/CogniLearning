var id = 0;
function agregarProducto() {

	var producto = $("#producto").val();
	var cantidad = $("#cantidad").val();
	var precio = $("#precio").val();
	var subtotal = parseInt(cantidad) * parseInt(precio);
	
	if(id == 0){
		id=1;
	}else{
		id++;
	}
	subtotal = subtotal.toString();
	id= id.toString();
  // Grab the template script
  var theTemplateScript = $("#address-template").html();

  // Compile the template
  var theTemplate = Handlebars.compile(theTemplateScript);

  // Define our data object
  var context={
    "id" : id,
	"producto": producto,
    "precio": precio,
    "cantidad": cantidad,
    "subtotal": subtotal
  };

  // Pass our data to the template
  var theCompiledHtml = theTemplate(context);

  // Add the compiled html to the page
  $('#content-placeholder').append(theCompiledHtml);
}

function borrar(numero){
	$("#producto"+numero).remove();
	
}