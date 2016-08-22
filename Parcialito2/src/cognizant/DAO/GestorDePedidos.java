package cognizant.DAO;
import java.sql.*;
import java.util.ArrayList;

import cognizant.BO.*;

public class GestorDePedidos {
	

	public void altaPedido(Pedido pedido) throws GestorExcepciones{
		
		Connection connection = null;
			try {
 				connection = DBUtil.recuperarConnection();
				
				String sql = "INSERT INTO pedidos(estado,fecha)"+
							 " VALUES (?,?)";
				
				PreparedStatement insertCommand = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				
				
				insertCommand.setString(1, pedido.getEstado());
				insertCommand.setDate(2, pedido.getFecha());
				insertCommand.execute();
				
				
				ResultSet rs = insertCommand.getGeneratedKeys();
				if (rs.next()){
				  pedido.setIdPedido( rs.getInt(1));
				 
				}
				
				for (Articulo articulo : pedido.getListaPedidos()) {		
					
					String sqlArt = "INSERT INTO items(idarticulos, cantidad, precio, idpedido)"+
							 " VALUES (?,?,?,?)";


					PreparedStatement insertCommandArt = connection.prepareStatement(sqlArt,Statement.RETURN_GENERATED_KEYS);
					insertCommandArt.setInt(1, articulo.getIdArticulo());
					insertCommandArt.setInt(2, articulo.getCantidad());
					insertCommandArt.setDouble(3, articulo.getPrecio());
					insertCommandArt.setInt(4, pedido.getIdPedido());
					insertCommandArt.execute();
					
					ResultSet rsArt = insertCommandArt.getGeneratedKeys();
					if (rsArt.next()){
					  articulo.setIdItem( rsArt.getInt(1));
					}

				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				throw new GestorExcepciones("Hubo un error en el alta de pedidos", e.getCause());
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new GestorExcepciones("Hubo un error en el alta de pedidos", e.getCause());
			}finally{
				DBUtil.cerrarConnection(connection);
			}

			return;
		}
		
	
	
	public ArrayList<Pedido> recuperarPedidos() throws GestorExcepciones{
		Connection connection = null;
		Pedido nuevoPedido = null;
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		try {
			connection = DBUtil.recuperarConnection();
			
			String sql = "SELECT idpedidos, estado FROM pedidos";
			
		    PreparedStatement selectCommand = connection.prepareStatement(sql);
		    
		    ResultSet resultado = selectCommand.executeQuery();
		   
		
			while(resultado.next() == true) {
				nuevoPedido = new Pedido();
				nuevoPedido.setIdPedido(resultado.getInt("idpedidos"));
				nuevoPedido.setEstado(resultado.getString("estado"));
				listaPedidos.add(nuevoPedido);
			}
			
			for (Pedido pedido : listaPedidos) {
				
				String sqlArt = "SELECT idItem, idarticulos, cantidad, precio, idpedido FROM items"
						+ " WHERE idpedido = ?";
			    PreparedStatement selectCommandArt = connection.prepareStatement(sqlArt);
			    
			    selectCommandArt.setInt(1, pedido.getIdPedido());
				   
			    ResultSet resultadoArt = selectCommandArt.executeQuery();
			  
			    
			   	while(resultadoArt.next() == true) {
			   	 Articulo nuevoArticulo = new Articulo();
			   	 			nuevoArticulo.setIdItem(resultadoArt.getInt("idItem"));
			   	 			nuevoArticulo.setIdArticulo(resultadoArt.getInt("idarticulos"));
							nuevoArticulo.setCantidad(resultadoArt.getInt("cantidad"));
							nuevoArticulo.setPrecio(resultadoArt.getDouble("precio"));
							nuevoArticulo.setIdPedido(resultadoArt.getInt("idpedido"));
							pedido.getListaPedidos().add(nuevoArticulo);
			   	}
						    
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new GestorExcepciones("Hubo un error en la recuperacion de datos", e.getCause());
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			throw new GestorExcepciones("Hubo un error la recuperacion de datos", e.getCause());
		}finally{
			DBUtil.cerrarConnection(connection);
		}
		
			return listaPedidos;
		
	}	
		
	
	
}
