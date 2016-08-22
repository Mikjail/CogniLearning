package cognizant.BO;

import java.util.*;
import java.sql.Date;


public class Pedido {

	private ArrayList<Articulo> listaPedidos;
	private String estado;
	private java.sql.Date fecha;
	private int idPedido;

	
	public ArrayList<Articulo> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(ArrayList<Articulo> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public Pedido(){
		this.listaPedidos = new ArrayList<>();
		this.setFecha(Date.valueOf(java.time.LocalDate.now()));
		this.setEstado("Activo");
	}
	
	public Pedido(String estado, ArrayList<Articulo> articulos){
		
		this.setEstado(estado);
		this.setFecha(Date.valueOf(java.time.LocalDate.now()));
		this.setListaPedidos(articulos);
	}
	
	public double CalcularTotal(){
		double total= 0;
		
		for (Articulo item : listaPedidos) {
			total += (item.getCantidad() * item.getPrecio());
		}
		
		return total;
	}

}
