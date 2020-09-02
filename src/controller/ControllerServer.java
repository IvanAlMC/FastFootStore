package controller;
 
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import models.Store;


public class ControllerServer {
	public static final String CLIENT_CONNECT = "cliente conectado al puerrto ";
	
	private final static int PORT =24910;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private Store store;
	
	public ControllerServer() {
		try {
			serverSocket= new ServerSocket(PORT);
			store=new Store();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void start() throws Throwable {
		while (true) {
			try {
				clientSocket= serverSocket.accept();
				System.out.println(CLIENT_CONNECT+ clientSocket.getPort());
				attend(clientSocket);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	private void attend(Socket socket) throws Throwable {
		new ClientThread(socket,store).start();
	}
	
	public static void main(String[] args) throws Throwable {
		new ControllerServer().start();
	}
}
