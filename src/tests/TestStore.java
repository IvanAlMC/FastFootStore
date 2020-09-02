package tests;

import models.Product;
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
		store.deleteProduct(new Product("Hamburguesa pequeña", 0, null, 0));
		System.out.println("Se chingo la hamburguesa pequeña");
		System.out.println(store.showListProducts());
		
		store.addClient("el brayan", 12);
		store.addClient("el kevin", 13);
		store.addClient("el marcos", 16);
		store.addClient("el jaime", 17);
		store.addClient("el ivan", 18);
		System.out.println(store.showClientsToAttend());
	}
}
