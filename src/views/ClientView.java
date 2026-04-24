package views;

import java.util.List;
import java.util.Scanner;
import dao.ClienteDAO;
import models.Cliente;

public class ClientView {
	private Scanner sc = new Scanner(System.in);
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	public ClientView() {}
	
	public void iniciar() {
		int opcion;
		do {
			opcion = this.mostrarMenu();
			switch(opcion) {
			
				case 1 -> this.listarClientes();
				case 2 -> this.addCliente();
	
			}				
		} while (opcion != 5);
	}

	private int mostrarMenu() {
		System.out.println("-- Gestión de clientes --");
		System.out.println("1. Ver todos los clientes");
		System.out.println("2. Añadir cliente");
		System.out.println("3. Actualizar cliente");
		System.out.println("4. Borrar cliente");
		System.out.println("5. Salir");		
		int opcion = sc.nextInt();
		sc.nextLine();
		
		return opcion;
	}
	
	private void listarClientes() {
		List<Cliente> clientes = this.clienteDAO.getAll();

		for (Cliente c : clientes) {
			System.out.println(c);
		}
		
	}
	
	private void addCliente() {
	    
	    System.out.print("Nombre: ");
	    String nombre = sc.nextLine();
	    
	    System.out.print("Email: ");
	    String email = sc.nextLine();
	    
	    System.out.print("Teléfono: ");
	    String telefono = sc.nextLine();
	    
	    System.out.print("Dirección: ");
	    String direccion = sc.nextLine();

	    Cliente nuevoCliente = new Cliente(nombre, email, telefono, direccion);
	    
	    if (clienteDAO.add(nuevoCliente)) {
	        System.out.println("Cliente insertado correctamente.");
	    } else {
	        System.out.println("No se pudo guardar el cliente.");
	    }
	}
	
}
