package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import models.Store;

public class ClientThread extends Thread{
	private Socket socket;
	private Store store;
	private DataOutputStream output;
	private DataInputStream input;
	public ClientThread(Socket socket,Store store) throws Throwable {
		this.socket=socket;
		this.store =store;
		output= new DataOutputStream(socket.getOutputStream());
		input = new DataInputStream(socket.getInputStream());
	}
	public void run () {
	

	}
}
