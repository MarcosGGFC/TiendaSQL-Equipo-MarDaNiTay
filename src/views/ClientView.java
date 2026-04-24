package views;

import java.util.Scanner;

public class ClientView {
	private Scanner sc = new Scanner(System.in);
	
	public ClientView() {}
	
	public void iniciar() {
		int opcion;
		do {
			opcion = this.mostrarMenu();
					
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
	
}
