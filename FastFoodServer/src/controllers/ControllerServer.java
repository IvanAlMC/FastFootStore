package controllers;
 
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ControllerServer {
	public static final String CLIENT_CONNECT = "cliente conectado al puerrto ";
	
	private final static int PORT =24910;
	private ServerSocket serverSocket;
	private Socket clientSocket;

	public ControllerServer() {
		try {
			serverSocket= new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void start() throws Throwable {
		System.out.println("Este es el servidor");
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
		new ClientThread(socket).start();
	}
	
	public static void main(String[] args) throws Throwable {
		new ControllerServer().start();
	}
}
