package tests;

import models.Store;

public class TestStore {

	public static void main(String[] args) {
		Store store = new Store();
		System.out.println("El hueco");
		store.createProduct("Hamburguesa grande", 7000.0, "grande", 10.0);
		store.createProduct("Perro caliente normal", 4000.0, "mediano", 20.0);
		store.createProduct("Papas fritas pequeñas", 3000.0, "pequeño", 5.0);
		store.createProduct("Batido de fresa mediano", 2000.0, "mediano", 6.0);
		store.createProduct("Ensalada verdura normal", 3500.0, "grande", 9.0);
		store.createProduct("Ensalada fruta normal", 3500.0, "grande", 9.0);
		store.createProduct("Hamburguesa pequeña", 5000.0, "pequeña", 7.0);
		System.out.println(store.showListProducts());
		store.deleteProduct("Hamburguesa pequeña");
		System.out.println("Se chingo la hamburguesa pequeña");
		System.out.println(store.showListProducts());
		
		store.addClient("el brayan", 12);
		store.addClient("el kevin", 13);
		store.addClient("el marcos", 16);
		store.addClient("el jaime", 17);
		store.addClient("el ivan", 18);
		System.out.println(store.showClientsToAttend());
		System.out.println("datos factura");
		store.addProductBill(13, "Papas fritas pequeñas");
		store.addProductBill(13, "Hamburguesa grande");
		store.addProductBill(13, "Batido de fresa mediano");
		store.addProductBill(13, "Ensalada verdura normal");
		
		System.out.println(store.showBill(13));
		
		System.out.println("borra producto factura");
		store.deleteProductBill(13, "Ensalada verdura normal");
		System.out.println(store.showBill(13));
		
		System.out.println("su pedido tarda en hacerse: " + store.seeTimeLeft(13) + " minutos");
		
		System.out.println("su turno es: " + store.getTurn(13));
		
		store.addProductBill(12, "Papas fritas pequeñas");
		store.addProductBill(12, "Hamburguesa grande");
		
		
		store.attendClient();
		store.attendClient();
		System.out.println("clientes por atender:");
		System.out.println(store.showClientsToAttend());
		System.out.println("clientes atendidos:");
		System.out.println(store.showClientsAttend());
		
		System.out.println("total ventas:");
		System.out.println(store.calculateSales());
	}
}
