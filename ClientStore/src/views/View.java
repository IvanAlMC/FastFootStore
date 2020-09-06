package views;

import java.util.Scanner;

public class View {
	
	private Scanner scanner;
	
	public View() {
		scanner = new Scanner(System.in);
	}
	
	public void showTurn(int turn) {
		System.out.println(MyMessage.SHOW_TURN);
		System.out.println(turn);
	}
	
	public void showTime(double time) {
		System.out.println(MyMessage.SHOW_TIME);
		System.out.println(time + MyMessage.MINUTES);
	}
	
	public double getTime() {
		System.out.println(MyMessage.IN_TIME);
		return Double.parseDouble(scanner.nextLine());
	}
	
	public String getSize() {
		System.out.println(MyMessage.IN_SIZE);
		return scanner.nextLine();
	}
	
	public void showMenu() {
		System.out.println(MyMessage.MENU);
	}
	
	public void showMenuA() {
		System.out.println(MyMessage.MENU_A);
	}
	
	public void showAttendClient() {
		System.out.println(MyMessage.ATTEND_CLIENT);
	}

	public void showMenuAC() {
		System.out.println(MyMessage.MENU_AC);
	}
	
	public void showNoImplemented() {
		System.out.println(MyMessage.NOT_IMPLEMENTED);
	}
	
	public void showTotalSales(double sales) {
		System.out.println(MyMessage.TOTAL_SALES);
		System.out.println("$"+sales);
	}
	
	public void showClientsToAttend(String clientsToAttend) {
		System.out.println(MyMessage.SINGS_RIGHT + MyMessage.CLIENTS_TO_ATTEND + MyMessage.SINGS_LEFT);
		System.out.println(clientsToAttend);
	}
	
	public void showClientsAttend(String clientsAttend) {
		System.out.println(MyMessage.SINGS_RIGHT + MyMessage.CLIENTS_ATTEND + MyMessage.SINGS_LEFT);
		System.out.println(clientsAttend);
	}
	
	public void showMenuProducts(String menu) {
		System.out.println(MyMessage.SINGS_RIGHT + MyMessage.MENU_PRODUCTS + MyMessage.SINGS_LEFT);
		System.out.println(menu);
	}
	
	public void showInformationContact(String contact) {
		System.out.println(MyMessage.SINGS_RIGHT + MyMessage.INFORMATION + MyMessage.SINGS_LEFT);
		System.out.println(contact);
	}
	
	public String getName() {
		System.out.println(MyMessage.IN_NAME);
		return scanner.nextLine();
	}
	
	public String getNameProduct() {
		System.out.println(MyMessage.IN_NAME_PRODUCT);
		return scanner.nextLine();
	}
	
	public int getOption() {
		int option = 0;
		System.out.println(MyMessage.GET_OPTION);
		try {
			option = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
			showMessageInvalidOption();
		}
		return option;
	}
	
	public int getOptionAC() {
		int option = 0;
		System.out.println(MyMessage.GET_OPTION);
		try {
			option = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
			showMessageInvalidOption();
		}
		return option;
	}
	
	public void showMessageInvalidOption() {
		System.out.println(MyMessage.INVALID_OPTION);
	}
	
	public void showMessageFinish() {
		System.out.println(MyMessage.THANKS);
	}
	
	public int getCC() {
		int number = 0;
		System.out.println(MyMessage.IN_CC);
		String string = scanner.nextLine();
		if(string.equals("")) {
			string = "0";
		}
		number = Integer.parseInt(string);
		return number;
	}
	
	public Double getPrice() {
		System.out.println(MyMessage.IN_PRICE);
		return Double.parseDouble(scanner.nextLine());
	}

}
