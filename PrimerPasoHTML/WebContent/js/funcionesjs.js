function operar(){
	
	var operacion = $("#operacion").val();
	var numeroUno = $("#numeroUno").val();
	var numeroDos = $("#numeroDos").val();
	
	numeroUno = parseFloat(numeroUno);
	numeroDos = parseFloat(numeroDos);
	
	
		switch (operacion) {
		case "Sumar":
			$("#resultado").val(numeroUno + numeroDos);
			
			break;
	
		case "Restar":
			
			$("#resultado").val(numeroUno - numeroDos);
			
			break;
			
		case "Multiplicar":
			
			$("#resultado").val(numeroUno * numeroDos);
			
			break;
			
		case "Dividir":
			if(numeroDos == 0){
				$("#resultado").val("No puede realizar operaciones con el divisor = 0")
			}
			$("#resultado").val(numeroUno / numeroDos);
			
			break;
		default:
			break;
		}
}