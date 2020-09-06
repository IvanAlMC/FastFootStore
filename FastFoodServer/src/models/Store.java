package models;

import java.util.List;
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
	
	public void deleteProduct(String name) {
		Product product = null;
		for(Product p: products.getInOrder()) {
			if(p.getName()==name) {
				product = p;
			}
		}
		products.delete(product);
	}
	
	public void addClient(String nameOwnerBill, int id) {
		assingTurn();
		bills.push(new Bill(this.turn, id, nameOwnerBill));
	}
	
	public void attendClient() {
		clientsAttend.insert(bills.peek());
		bills.poll();
	}
	
	public String showBill(int id) {
		Bill bill = null;
		for(Bill b: bills) {
			if(b.getId()==id) {
				bill = b;
			}
		}
		return bill.showDatas();
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
		List<Product> list = products.getInOrder();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				bill.addProduct((list.get(i)));
			}
		}
	}
	
	public void deleteProductBill(int id, String name) {
		Bill bill = null;
		for(Bill b: bills) {
			if(b.getId()==id) {
				bill = b;
			}
		}
		List<Product> list = products.getInOrder();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				bill.deleteProduct((list.get(i)));
			}
		}
	}
	
	
	public void assingTurn() {
		turn++;
	}
	
	public String showClientsToAttend() {
		return bills.show();
	}
	
	public String showClientsAttend() {
		return clientsAttend.showInOrder();
	}
	
	public double calculateSales() {
		double sales = 0;
		List<Bill> list = clientsAttend.getInOrder();
		for(int i = 0; i < list.size(); i++) {
			sales += list.get(i).calculateValue();
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