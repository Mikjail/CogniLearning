package cognizant.BO;

public class Articulo {
	
	private int idItem;
	private int idArticulo;
	private int cantidad;
	private double precio;
	private int idPedido;
	
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	
	public int getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Articulo(){}
	
	public Articulo(int cantidad, double precio, int idArticulos){
		this.setCantidad(cantidad);
		this.setPrecio(precio);
		this.setIdArticulo(idArticulos);
	}
	
	@Override
	public String toString() {
		return "Articulo [idItem=" + idItem + ", idArticulo=" + idArticulo + ", cantidad=" + cantidad + ", precio="
				+ precio + " idPedido=" + idPedido + "]";
	}
	
	
	
}
