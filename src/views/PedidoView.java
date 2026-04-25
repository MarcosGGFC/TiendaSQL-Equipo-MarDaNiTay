package views;

import java.util.List;
import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;
import dao.PedidoDAO;
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
        String emailCliente = sc.next();
        sc.nextLine();

        Date fechaActual = Date.valueOf(LocalDate.now());
        
        Pedido nuevoPedido = new Pedido(emailCliente, fechaActual);
        
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
    	System.out.println("Introduce el email del cliente del que quieres borrar su pedido: ");
    	String emailBorrar = sc.next();
    	
    	if(this.pedidoDAO.delete(emailBorrar)) {
			System.out.println("Pedido eliminado");
		}else {
			System.out.println("Error el email no existe o no tiene pedidos asociados.");
		}
    }
}