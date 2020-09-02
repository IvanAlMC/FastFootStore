package models;

import structures.BinaryTree;
import structures.QueuList;

public class Store {
	
	private BinaryTree<Product> products;
	private QueuList<Bill> bills;
	private BinaryTree<Bill> clientsAttend;
	private int turn;
	
	public Store() {
		products = new BinaryTree<Product>(new ComparatorProduct());
		bills = new QueuList<Bill>(new ComparatorBill());
		clientsAttend = new BinaryTree<Bill>(new ComparatorBill());
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
	
	public void attendClient() {
		clientsAttend.insert(bills.peek());
		bills.poll();
	}
	
	public String showBill(Bill bill) {
		return bills.search(bill).showDatas();
	}
	
	public String showListProducts(){
		return products.showInOrder();
	}
	
	public void addProductBill(int id, String name) {
		Bill bill = null;
		for(Bill b: bills) {
			if(b.getId()==id) {
				bill = b;
			}
		}
		Product product = null;
		for(Product p: products.getInOrder()) {
			if(p.getName()==name) {
				product = p;
			}
		}
		bill.addProduct(product);
	}
	
	public void deleteProductBill(int id, String name) {
		Bill bill = null;
		for(Bill b: bills) {
			if(b.getId()==id) {
				bill = b;
			}
		}
		Product product = null;
		for(Product p: products.getInOrder()) {
			if(p.getName()==name) {
				product = p;
			}
		}
		bill.deleteProduct(product);
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
	
	public String showClientsAttend() {
		return clientsAttend.showInOrder();
	}
	
	public double calculateSales() {
		double sales = 0;
		for(Bill b: clientsAttend.getInOrder()) {
			sales += b.calculateValue();
		}
		return sales;
	}
	
	public int getTurn(int id) {
		Bill bill = null;
		for(Bill b: bills) {
			if(b.getId()==id) {
				bill = b;
			}
		}
		return bill.getTurn();
	}
	
	public double seeTimeLeft(int id) {
		Bill bill = null;
		for(Bill b: bills) {
			if(b.getId()==id) {
				bill = b;
			}
		}
		return bill.calculateTime();
	}
	
}