package models;

import java.util.Iterator;

import structures.BinaryTree;
import structures.QueuList;

public class Store {
	
	private BinaryTree<Product> products;
	private QueuList<Bill> bills;
	private int turn;
	
	public Store() {
		products = new BinaryTree<Product>(new ComparatorProduct());
		bills = new QueuList<Bill>(new ComparatorBill());
		turn = 0;
	}

	public void createProduct(String name, double price, String size, double timeToCook) {
		products.insert(new Product(name, price, size, timeToCook));
	}
	
	public Product addProduct(Product product) {
		return products.getData(product);
	}
	
	public void deleteProduct(Product product) {
		products.delete(product);
	}
	
	public void addClient(String nameOwnerBill, int id) {
		assingTurn();
		Bill bill = new Bill(this.turn, id, nameOwnerBill);
		bills.push(bill);
	}
	
	public void attendClient(Bill bill) {
		bills.push(bill);
	}
	
	public String showListProducts(){
		return products.showInOrder();
	}
	
	public void getBill(Bill bill) {
//		bills.search(bill).addProduct();
	}
	
	
	public void assingTurn() {
		turn++;
	}
	
	public String showClientsToAttend() {
		return bills.show();
	}
	
	public boolean acceptOrder() {
		boolean flag = false;
		
		return flag;
	}
	
	public boolean registrySucessfulSale() {
		boolean flag = false;
		
		return flag;
	}
	
	public double calculateSales() {
		double sales = 0;
		Iterator<Bill> iterador = bills.iterator();
		while(iterador.hasNext()) {
			Bill bill = iterador.next();
			sales += bill.calculateValue();
		}
		return sales;
	}
	
	public double getTotalTimeToWait() {
		double time = 0;
		Iterator<Bill> iterador = bills.iterator();
		while(iterador.hasNext()) {
			Bill bill = iterador.next();
			time += bill.calculateTime();
		}
		return time;
	}
	
	public int getTurn(Bill bill) {
		return bills.search(bill).getTurn();
	}
	
}