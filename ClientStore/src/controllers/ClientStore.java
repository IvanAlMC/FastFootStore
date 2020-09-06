package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import views.MyJFramePpal;
import views.View;

public class ClientStore implements ActionListener {
	private final static String HOST = "localhost";
	private final static int PORT = 24910;
	private Socket socket;
	private View view;
	private MyJFramePpal framePpal;

	public ClientStore() throws UnknownHostException, IOException {
		socket = new Socket(HOST, PORT);
		view = new View();
		framePpal = new MyJFramePpal(this);
	}

	public void run() throws IOException {
		System.out.println("Este es el cliente");
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		DataInputStream input = new DataInputStream(socket.getInputStream());
		output.writeUTF("Saludos desde el cliente");
		boolean exit = false;
		do {
			view.showMenuAC();
			int optionAC = view.getOptionAC();
			output.write(optionAC);
			if (optionAC == 1) {
				do {
					System.out.println("Que tipo de operacion quieres");
					view.showMenu();
					int option = view.getOption();
					output.write(option);
					if (option == 1) {
						String menu = input.readUTF();
						view.showMenuProducts(menu);
					} else if (option == 2) {
						output.write(view.getCC());
						output.writeUTF(view.getNameProduct());
					} else if (option == 3) {
						output.write(view.getCC());
						output.writeUTF(view.getNameProduct());
					} else if (option == 4) {
						output.write(view.getCC());
						String list = input.readUTF();
						view.showMenuProducts(list);
					} else if (option == 5) {
						output.write(view.getCC());
						int turn = input.read();
						view.showTurn(turn);
					} else if (option == 6) {
						output.write(view.getCC());
						double time = input.readDouble();
						view.showTime(time);
					} else if (option == 7) {
						view.showMessageFinish();
						exit = true;
					} else {
						view.showMessageInvalidOption();
					}
				} while (!exit);
			} else if (optionAC == 2) {
				do {
					System.out.println("Que tipo de operacion quieres");
					view.showMenuA();
					int option = view.getOption();
					output.write(option);
					if (option == 1) {
						String menu = input.readUTF();
						view.showMenuProducts(menu);
					} else if (option == 2) {
						output.writeUTF(view.getNameProduct());
						output.writeDouble(view.getPrice());
						output.writeUTF(view.getSize());
						output.writeDouble(view.getTime());
					} else if (option == 3) {
						output.writeUTF(view.getNameProduct());
					} else if (option == 4) {
						String list = input.readUTF();
						view.showClientsToAttend(list);
					} else if (option == 5) {
						String list = input.readUTF();
						view.showClientsAttend(list);
					} else if (option == 6) {
						double sales = input.readDouble();
						view.showTotalSales(sales);
					}else if(option == 7) {
						view.showAttendClient();
					} else if (option == 8) {
						view.showMessageFinish();
						exit = true;
					} else {
						view.showMessageInvalidOption();
					}
				} while (!exit);
			}
		} while (!exit);
		socket.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new ClientStore().run();
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
    	case SHOW_LIST:
            
            break;
    	case ADMIN:
    		framePpal.showAdminPanel();
    		break;
    	case CLIENT:
    		framePpal.showClientPanel();
    		break;
		}
		
	}
}
