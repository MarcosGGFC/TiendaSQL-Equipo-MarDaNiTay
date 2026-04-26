package views;

import dao.PedidoDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import models.Pedido;

public class PedidoView {
    private Scanner sc = new Scanner(System.in);
    private PedidoDAO pedidoDAO = new PedidoDAO();
    
    public PedidoView() {}
    
    public void iniciar() {
        int opcion;
        do {
            opcion = this.mostrarMenu();
            switch(opcion) {
                case 1 -> {
                	this.addPedido();
            }
                case 2 -> { 
                	this.listarPedidos(); 
            }
                case 3 -> {
                	this.borrarPedidos();
                }
                
            }               
        } while (opcion != 4);
    }

    private int mostrarMenu() {
        System.out.println("-- Gestión de Pedidos --");
        System.out.println("1. Crear nuevo pedido");
        System.out.println("2. Ver pedidos");
        System.out.println("3. Salir");       
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }
    
    private void addPedido() {
        System.out.print("Introduce el email del cliente que hace el pedido: ");
        int idCliente = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce la cantidad del producto elegido: ");
        int cantidad = sc.nextInt();
        System.out.println("Introduce el id del producto: ");
        int idProducto = sc.nextInt();

        Date fechaActual = Date.valueOf(LocalDate.now());
        
        Pedido nuevoPedido = new Pedido(idCliente, fechaActual, cantidad, idProducto);
        
        if (pedidoDAO.add(nuevoPedido)) {
            System.out.println("Pedido registrado correctamente.");
        } else {
            System.out.println("No se ha podido registrar el pedido.");
        }
    }
    
    private void listarPedidos() {
		List<Pedido> pedidos = this.pedidoDAO.getAll();

		for (Pedido p :  pedidos) {
			System.out.println(p);
		}
		
	}
    
    private void borrarPedidos() {
    	System.out.println("Introduce el id del pedido del que quieres borrar el pedido: ");
    	int idCliente = sc.nextInt();
    	
    	if(this.pedidoDAO.delete(idCliente)) {
			System.out.println("Pedido eliminado");
		}else {
			System.out.println("Error el email no existe o no tiene pedidos asociados.");
		}
    }
}