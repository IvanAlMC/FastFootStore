package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import views.MyJFramePpal;

public class ClientStore implements ActionListener {
	private final static String HOST = "localhost";
	private final static int PORT = 24910;
	private MyJFramePpal framePpal;
	private DataInputStream input;
	private DataOutputStream output;
	private Socket socket;

	public ClientStore() throws UnknownHostException, IOException {
		try {
			socket = new Socket(HOST, PORT);
			if (socket.isConnected()) {
				this.framePpal = new MyJFramePpal(this);
				this.output = new DataOutputStream(socket.getOutputStream());
				this.input = new DataInputStream(socket.getInputStream());
			}
		} catch (ConnectException e) {
			System.out.println("Conexion rechazada");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			switch (e.getActionCommand()) {
			case Actions.ADMIN:
				showWelcomeA();
				break;
			case Actions.CLIENT:
				showWelcomeC();
				break;
			case Actions.SHOW_LIST:
				getMenu();
				break;
			case Actions.TIME:
				if (this.input != null && this.output != null)
					openDialogTime();
				break;
			case Actions.ACCEPT_CC_TIME:
				if (this.input != null && this.output != null)
					getTime();
				closeDialogTime();
				break;
			case Actions.CANCEL_CC_TIME:
				closeDialogTime();
			case Actions.CREATE_PRODUCT:
				openDialogCreate();
				break;
			case Actions.ACCEPT_CREATE:
				if (this.input != null && this.output != null)
					insertNewProduct();
				closeDialogCreate();
				break;
			case Actions.CANCEL_CREATE:
				closeDialogCreate();
				break;
			case Actions.REGISTER:
				openDialogRegister();
				break;
			case Actions.ACCEPT_REGISTER:
				if (this.input != null && this.output != null)
					registryClient();
				closeDialogRegister();
				break;
			case Actions.CANCEL_REGISTER:
				closeDialogRegister();
				break;
			case Actions.TURN:
				framePpal.openDialogTurn();
				break;
			case Actions.ACCEPT_CC_TURN:
				if (this.input != null && this.output != null)
					getTurn();
				framePpal.closeDialogTurn();
				break;
			case Actions.ADD_PRODUCT:
				openDialogAdd();
				break;
			case Actions.ACCEPT_ADD:
				if (this.input != null && this.output != null)
					addProduct();
				closeDialogAdd();
				break;
			case Actions.CANCEL_ADD:
				closeDialogAdd();
				break;
			case Actions.DELETE_PRODUCT:
				openDialogDelete();
				break;
			case Actions.ACCEPT_DELETE:
				if (this.input != null && this.output != null)
					deleteProduct();
				closeDialogDelete();
				break;
			case Actions.CANCEL_DELETE:
				closeDialogDelete();
				break;
			case Actions.BILL:
				framePpal.openDialogBill();
				break;
			case Actions.ACCEPT_CC_BILL:
				if (this.input != null && this.output != null)
					showBill();
				framePpal.closeDialogBill();
				break;
			case Actions.CANCEL_CC_BILL:
				framePpal.closeDialogBill();
				break;
			case Actions.DELETE_PRODUCT_MENU:
				framePpal.openDialogErase();
				break;
			case Actions.ACCEPT_ERASE:
				if (this.input != null && this.output != null)
					deleteProductMenu();
				framePpal.closeDialogErase();
				break;
			case Actions.CANCEL_ERASE:
				framePpal.closeDialogErase();
				break;
			case Actions.CLIENTS_TO_ATTEND:
				if (this.input != null && this.output != null)
					showClientsToAttend();
				break;
			case Actions.CLIENTS_ATTENDED:
				if (this.input != null && this.output != null)
					showClientsAttended();
				break;
			case Actions.SALES:
				if (this.input != null && this.output != null)
					showSales();
				break;
			case Actions.ATTEND:
				if (this.input != null && this.output != null)
					attendClient();
				break;
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	private void attendClient() throws IOException {
		output.writeUTF(Actions.ATTEND);
		JOptionPane.showMessageDialog(null, "Cliente Atendido");
	}
	
	private void showSales() throws IOException {
		output.writeUTF(Actions.SALES);
		String sales = "El total de ventas es: $" + String.valueOf(input.readDouble());
		JOptionPane.showMessageDialog(null, sales);
	}
	
	private void showClientsToAttend() throws IOException {
		output.writeUTF(Actions.CLIENTS_TO_ATTEND);
		String list = input.readUTF();
		JOptionPane.showMessageDialog(null, list);
	}
	
	private void showClientsAttended() throws IOException {
		output.writeUTF(Actions.CLIENTS_ATTENDED);
		String list = input.readUTF();
		JOptionPane.showMessageDialog(null, list);
	}
	
	private void deleteProductMenu() throws IOException {
		output.writeUTF(Actions.ACCEPT_ERASE);
		output.writeUTF(framePpal.getNameProductErase());
	}
	
	private void showBill() throws IOException {
		output.writeUTF(Actions.ACCEPT_CC_BILL);
		output.write(framePpal.getCCBill());
		String bill = "Factura: "  + "\n " + input.readUTF();
		JOptionPane.showMessageDialog(null, bill);
	}

	private void deleteProduct() throws IOException {
		output.writeUTF(Actions.ACCEPT_DELETE);
		output.write(framePpal.getCCDelete());
		output.writeUTF(framePpal.getNameProductDelete());
	}

	private void addProduct() throws IOException {
		output.writeUTF(Actions.ACCEPT_ADD);
		output.write(framePpal.getCCAdd());
		output.writeUTF(framePpal.getNameProductAdd());
	}

	private void getTurn() throws IOException {
		output.writeUTF(Actions.ACCEPT_CC_TURN);
		output.write(framePpal.getCCTurn());
		String turn = "Su turno es: " + String.valueOf(input.read());
		JOptionPane.showMessageDialog(null, turn);
	}

	private void registryClient() throws IOException {
		output.writeUTF(Actions.ACCEPT_REGISTER);
		output.writeUTF(framePpal.getNameClient());
		output.write(framePpal.getCCRegister());
	}

	private void getMenu() throws IOException {
		output.writeUTF(Actions.SHOW_LIST);
		String menu = input.readUTF();
		JOptionPane.showMessageDialog(null, menu);
	}

	private void getTime() throws IOException {
		output.writeUTF(Actions.ACCEPT_CC_TIME);
		output.write(framePpal.getCC());
		String time = "Su pedido tarda: " + String.valueOf(input.readDouble()) + " minutos en preparar";
		JOptionPane.showMessageDialog(null, time);
	}

	private void insertNewProduct() throws IOException {
		output.writeUTF(Actions.ACCEPT_CREATE);
		output.writeUTF(framePpal.getNameProduct());
		output.writeDouble(framePpal.getPrice());
		output.writeUTF(framePpal.getSizeP());
		output.writeDouble(framePpal.getTimeP());
	}

	private void showWelcomeA() {
		framePpal.showAdminPanel();
	}

	private void showWelcomeC() {
		framePpal.showClientPanel();
	}

	private void openDialogTime() {
		framePpal.openDialogTime();
	}

	private void closeDialogTime() {
		framePpal.closeDialogTime();
	}

	private void openDialogRegister() {
		framePpal.openDialogRegister();
	}

	private void closeDialogRegister() {
		framePpal.closeDialogRegister();
	}

	private void openDialogCreate() {
		framePpal.openDialogCreate();
	}

	private void closeDialogCreate() {
		framePpal.closeDialogCreate();
	}

	private void openDialogAdd() {
		framePpal.openDialogAdd();
	}

	private void closeDialogAdd() {
		framePpal.closeDialogAdd();
	}

	private void openDialogDelete() {
		framePpal.openDialogDelete();
	}

	private void closeDialogDelete() {
		framePpal.closeDialogDelete();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new ClientStore();
	}

}
