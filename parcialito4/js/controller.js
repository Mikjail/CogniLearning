var app = angular.module('starter', []);
app.controller("productosCtrl", function($scope) {
	
$scope.productos = [
	{ 
		nombre : "Carne Mechada", 
		id: 1, 
		precio : 30 },
	{ 
		nombre : "producto2", 
		id: 2, 
		precio : 400
	},
	{ 
		nombre : "producto3", 
		id: 3, 
		precio : 359
	},
	{ 
		nombre : "producto4", 
		id: 4, 
		precio : 450
	}
	];
	
	$scope.producto= {
		nombre : "",
		id : "",
		precio : "",
		cantidad : ""
	};


	$scope.saveToCarrito = function(id){
		alert(id);

		$scope.producto.push({ 
							nombre : $scope.producto.cantidad, 
						    id: $("#id").val(),
			 				precio : $("#precio").val(),
			  				cantidad : $("#cantidad").val()
			   				});

	    var carritoJson = JSON.stringify($scope.carrito);
	    localStorage.setItem("carrito",carritoJson);
	}
	
});

