package controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import models.Store;

public class ClientThread extends Thread {

	private Socket clientSocket;
	private Store store;

	public ClientThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
		store = new Store();
		test();
	}

	public void test() {
		System.out.println("El hueco");
		store.addClient("el brayan", 12);
		store.addClient("el kevin", 13);
		store.addClient("el marcos", 16);
		store.createProduct("Hamburguesa grande", 7000.0, "grande", 10.0);
		store.createProduct("Perro caliente normal", 4000.0, "mediano", 20.0);
		store.createProduct("Papas fritas pequeñas", 3000.0, "pequeño", 5.0);
		store.createProduct("Batido de fresa mediano", 2000.0, "mediano", 6.0);
		store.createProduct("Ensalada verdura normal", 3500.0, "grande", 9.0);
		store.createProduct("Ensalada fruta normal", 3500.0, "grande", 9.0);
		store.createProduct("Hamburguesa pequeña", 5000.0, "pequeña", 7.0);
		store.addProductBill(12, "Perro caliente normal");
		store.addProductBill(13, "Perro caliente normal");
		store.addProductBill(13, "Hamburguesa grande");
		store.addProductBill(13, "Batido de fresa mediano");
		store.addProductBill(16, "Ensalada fruta normal");
		store.addProductBill(16, "Batido de fresa mediano");
	}

	public void run() {
		try {
			DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
			DataInputStream input = new DataInputStream(clientSocket.getInputStream());
			String message = input.readUTF();
			System.out.println("recibido ... " + message);
			boolean exit = false;
			int optionAC = input.read();
			output.writeUTF(store.showListProducts());
			do {
				if (optionAC == 1) {
					do {
						System.out.println("Esperando el tipo de operacion...");
						int option = input.read();
						System.out.println("El tipo de operacion es: " + option);
						if (option == 1) {
							output.writeUTF(store.showListProducts());
						} else if (option == 2) {
							int cc = input.read();
							String nameProduct = input.readUTF();
							store.addProductBill(cc, nameProduct);
						} else if (option == 3) {
							int cc = input.read();
							String nameProduct = input.readUTF();
							store.deleteProductBill(cc, nameProduct);
						} else if (option == 4) {
							int cc = input.read();
							output.writeUTF(store.showBill(cc));
						} else if (option == 5) {
							int cc = input.read();
							int turn = store.getTurn(cc);
							output.write(turn);
						} else if (option == 6) {
							int cc = input.read();
							output.writeDouble(store.seeTimeLeft(cc));
						} else if (option == 7) {
							exit = true;
						} else {
							System.out.print("Error");
						}
					} while (!exit);
				}
				if (optionAC == 2) {
					do {
						System.out.println("Esperando el tipo de operacion...");
						int option = input.read();
						System.out.println("El tipo de operacion es: " + option);
						if (option == 1) {
							output.writeUTF(store.showListProducts());
						} else if (option == 2) {
							String nameProduct = input.readUTF();
							double price = input.readDouble();
							String size = input.readUTF();
							double time = input.readDouble();
							store.createProduct(nameProduct, price, size, time);
						} else if (option == 3) {
							String nameProduct = input.readUTF();
							store.deleteProduct(nameProduct);
						} else if (option == 4) {
							output.writeUTF(store.showClientsToAttend());
						} else if (option == 5) {
							output.writeUTF(store.showClientsAttend());
						} else if (option == 6) {
							output.writeDouble(store.calculateSales());
						}else if(option == 7) {
							store.attendClient();
						} else if (option == 8) {
							exit = true;
						} else {
							System.out.print("Error");
						}
					} while (!exit);
				}
			} while (!exit);
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
