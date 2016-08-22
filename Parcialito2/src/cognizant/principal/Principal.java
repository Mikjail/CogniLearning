package cognizant.principal;

import java.util.ArrayList;

import cognizant.BO.*;
import cognizant.DAO.GestorDePedidos;
import cognizant.DAO.GestorExcepciones;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorDePedidos gestorPed = new GestorDePedidos();
		
		Pedido nuevoPedido = new Pedido();
	
		nuevoPedido.getListaPedidos().add(new Articulo(1, 203,9));
		nuevoPedido.getListaPedidos().add(new Articulo(4,345,8));
		
		try {
			gestorPed.altaPedido(nuevoPedido);
		} catch (GestorExcepciones e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		try {
			listaPedidos = gestorPed.recuperarPedidos();
				
		} catch (GestorExcepciones e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for (Pedido pedido : listaPedidos) {
			System.out.println("**************PEDIDO**************");
			System.out.println("Precio: "+ pedido.CalcularTotal());
			for (Articulo articulo : pedido.getListaPedidos()) {
				System.out.println(articulo.toString());
			}
		}
	}

}
