package models;

import java.util.ArrayList;
import java.util.List;

import structures.BinaryTree;

public class Bill {
	
	private int turn;
	private int id;
	private String nameOwnerBill;
	private BinaryTree<Product> order;

	public Bill(int turn, int id, String nameOwnerBill) {
		this.turn = turn;
		this.id = id;
		this.nameOwnerBill = nameOwnerBill;
		this.order = new BinaryTree<Product>(new ComparatorProduct());
	}
	
	public Product addProduct(Product product) {
		return order.getData(product);
	}
	
	public void deleteProduct(Product product) {
		order.delete(product);
	}
	
	public double calculateValue() {
		double totalSales = 0;
		List<Product> list = new ArrayList<Product>();
		for(Product product: list) {
			totalSales += product.getPrice();
		}
		return totalSales;
	}
	
	public double calculateTime() {
		double totalTime = 0;
		List<Product> list = new ArrayList<Product>();
		for(Product product: list) {
			totalTime += product.getTimeToCook();
		}
		return totalTime;
	}

	public String getNameOwnerBill() {
		return nameOwnerBill;
	}

	public void setNameOwnerBill(String nameOwnerBill) {
		this.nameOwnerBill = nameOwnerBill;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Factura: nombre: " + nameOwnerBill + " turno: " + turn + " id: " + id + "\n";
	}

}
