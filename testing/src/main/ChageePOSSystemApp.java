package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.text.DecimalFormat;
import java.util.Scanner;

import Entity.Admin;
import Entity.Cart;
import Entity.Order;
import IView.IView;
import Manager.adminManager;
import Manager.cartManager;
import Manager.orderManager;
import View.Admin.AdminCreateView;
import View.Admin.AdminDisplayView;
import View.Admin.AdminIndexView;
import View.Admin.AdminLogView;
import View.Admin.AdminManageView;
import View.Admin.AdminRemoveView;
import View.Admin.AdminUpdateView;
import View.Cart.CartCreateView;
import View.Cart.CartDisplayView;
import View.Cart.CartRemoveView;
import View.Item.ItemCreateView;
import View.Item.ItemDisplayView;
import View.Item.ItemIndexView;
import View.Item.ItemRemoveView;
import View.Item.ItemUpdateView;
import View.Order.OrderDisplayView;
import View.Settlement.SettlementCreateView;
import View.Settlement.SettlementDisplayView;
import View.Settlement.SettlementIndexView;
import View.Settlement.SettlementRemoveView;
import View.User.UserIndexView;
import core.AdminSource;
import core.CartSource;
import core.OrderSource;

public class ChageePOSSystemApp implements IView {
	
	public static void main(String[] args) {
		ChageePOSSystemApp chageePOSSystemApp = new ChageePOSSystemApp();
		
		System.out.println("================霸王茶姬================"+"\n");
		System.out.println("Welcome On Board 霸王茶姬 Vending Machine!!!");
		System.out.println("\n\n");
		
		boolean run = true;
		
		while(run == true) {
			var menuId = chageePOSSystemApp.render();
			
			switch (menuId) {
			case 1:
				System.out.println("Admin..");
				chageePOSSystemApp.adminMenu();
				break;
			case 2:
				System.out.println("User...");
				chageePOSSystemApp.userMenu();
				break;
			case 3:
				run = false;
				break;
			}

		}
	}
	
	public void checkout() {
		cartManager CartManager = new cartManager();
		
		int checkEmpty = CartSource.CARTSOURCE.size();
		
		if(checkEmpty !=0) {
			
			double total = 0;
			
			
			for(Entry<String, Cart> e: CartManager.getAll().entrySet()) {
				
				total = total + e.getValue().getPrice();
				//System.out.println(total);
				
			}
			System.out.println("Total = " + total);
			calculate(total);
		}else {
			System.out.println("The Cart Is Empty\nPlease Add some item to cart...");
		}

	
	
	}
	
	public void calculate(Double total) {
		orderManager OrderManager = new orderManager();
		OrderDisplayView orderDisplayView = new OrderDisplayView();
		
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#0.00	");
		
		System.out.println("Please Insert Available Cash: ");
		double cash = keyboard.nextDouble();
		//Tax Percentage
		final double tax = 0.06;
		double taxAmount;
		double subtotal = 0; 
		double change = 0;
		
		taxAmount = total*tax;
		System.out.println("Tax Amount = " + df.format(taxAmount));
		
		subtotal = total + taxAmount;
		System.out.println("Subtotal = " + df.format(subtotal));

		
		if(cash >= subtotal) {
			
			change = cash - subtotal;
			
			System.out.println("Your subtotal is: " + df.format(subtotal) + "\nYour balance is: "+ df.format(change));
			System.out.println("Payment Sucessful!!"
					+ "\nHope You Enjoy Our Foods and Drinks :D");
			
			List<Cart> carts = new ArrayList<Cart>(CartSource.CARTSOURCE.values());
			
			Order order = new Order(carts);
			String orderId = OrderSource.getOrderNextId();

			//System.out.println(AdminSource.ADMIN_SOURCE.values());
			
			
			OrderManager.create(orderId, order);
			orderDisplayView.render();
			
			//clear shopping cart....
			CartSource.CARTSOURCE.clear();

			
			
			
			
		
		}else {
			System.out.println("Insufficeint Cash..");
		}
		return;
		
	
	}
	
	public void userMenu() {
		UserIndexView userIndexView = new UserIndexView();
		ItemDisplayView itemDisplayView = new ItemDisplayView();
		CartCreateView cartCreateView = new CartCreateView();
		CartRemoveView cartRemoveView = new CartRemoveView();
		CartDisplayView cartDisplayView = new CartDisplayView();
		OrderDisplayView orderDisplayView = new OrderDisplayView();
		
		boolean run = true;
		
		while(run == true) {
			var menuId = userIndexView.render();
			switch(menuId) {
			case 1:
				System.out.println("Displaying Item...");
				itemDisplayView.render();
				break;
			case 2:
				System.out.println("Adding Item...");
				cartCreateView.render();
				break;
			case 3:
				System.out.println("Removing...");
				cartRemoveView.render();
				break;
			case 4:
				System.out.println("Displaying Cart...");
				cartDisplayView.render();
				break;
			case 5:
				System.out.println("Checking Out...");
				checkout();
				break;
			case 6:
				run = false;
				break;
			case 7:
				System.out.println("Displaying current order...");
				orderDisplayView.render();
				break;
				
			
			}
		}
		
	}
	
	public void settlementMenu() {
		SettlementIndexView settlementIndexView = new SettlementIndexView();
		SettlementCreateView settlementCreateView = new SettlementCreateView();
		SettlementDisplayView settlementDisplayView = new SettlementDisplayView();
		SettlementRemoveView settlementRemoveView = new SettlementRemoveView();
		
		boolean run = true;
		
		while(run == true) {
			var menuId = settlementIndexView.render();
			switch(menuId) {
			case 1: 
				System.out.println("Creating...");
				settlementCreateView.render();
				
				break;
			case 2:
				System.out.println("Removing...");
				settlementRemoveView.render();
				break;
			case 3:
				System.out.println("Displaying...");
				settlementDisplayView.render();
				break;
			case 4: 
				run = false;
				break;		
			}
		}
	}
	
	public void itemMenu() {
		ItemIndexView itemIndexView = new ItemIndexView();
		ItemCreateView itemCreateView = new ItemCreateView();
		ItemDisplayView itemDisplayView = new ItemDisplayView();
		ItemRemoveView itemRemoveView = new ItemRemoveView();
		ItemUpdateView itemUpdateView = new ItemUpdateView();
		
		boolean run = true;
		
		while(run == true) {
			var itemMenuId = itemIndexView.render();
			switch(itemMenuId) {
			
			case 1:
				System.out.println("Creating...");
				itemCreateView.render();
				break;
			case 2:
				System.out.println("Removing...");
				itemRemoveView.render();
				break;
			case 3:
				System.out.println("Updating...");
				itemUpdateView.render();
				break;
			case 4:
				System.out.println("Displaying...");
				itemDisplayView.render();
				break;
			case 5:
				run = false;
				break;
			
			
			}
		}
	}
	

	/*
	 * =============================ADMIN===========================
	 */

	public void adminManage() {
		AdminIndexView adminIndexView = new AdminIndexView();

		boolean run = true;
		
		while(run == true) {
			var menuId = adminIndexView.render();			
			
			switch(menuId) {
			case 1:
				System.out.println("MANAGING ADMIN...");
				//adminManageView.render();
				//leading to manage admin
				adminManageMenu();
				break;
			case 2:
				System.out.println("MANAGING ITEM..");
				//leading to manage item
				itemMenu();
				break;
			case 3: 
				System.out.println("MANAGING SETTLEMENT...");
				//leading to manage settlement
				settlementMenu();
				break;
			case 4:
				run = false;
				break;
				
			}
		}
	}
	
	public void adminManageMenu() {
		AdminManageView adminManageView = new AdminManageView();
		AdminCreateView adminCreateView = new AdminCreateView();
		AdminDisplayView adminDisplayView = new AdminDisplayView();
		AdminRemoveView adminRemoveView = new AdminRemoveView();
		AdminUpdateView adminUpdateView = new AdminUpdateView();
		
		Scanner keyboard = new Scanner(System.in);

		boolean run = true;
		
		while(run == true) {
			var adminMenuId = adminManageView.render();
			
			switch(adminMenuId) {
			case 1:
				System.out.println("Creating...");
				adminCreateView.render();
				break;
			case 2:
				System.out.println("Removing...");
				adminRemoveView.render();
				break;
			case 3:
				System.out.println("Updating...");
				adminUpdateView.render();
				break;
			case 4:
				System.out.println("Displaying...");
				adminDisplayView.render();
				break;
			case 5:
				run = false;
				break;
			
			}
		}
	}
	
	
	public void adminSignin() {
		adminManager AdminManager = new adminManager();
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Admin Name: ");
		String adminName = keyboard.nextLine();
		
		System.out.println("Admin Passowrd: ");
		String password = keyboard.nextLine();
		
		boolean flag = false;
		
		for(Entry<String, Admin> entry: AdminManager.getAll().entrySet()) {
			
			if(entry.getValue().getAdminName().equals(adminName)  && entry.getValue().getPassword().equals(password)) {
				flag = true;
				break;
			}else {
				flag = false;
			}
			
		}
		if(flag ==true) {
			System.out.println("Log In Sucessful...");
			//Lead to AdminIndexView Page...
			//Create a Menthod
			//adminIndexView.render();
			
			adminManage();

			
		}else {
			System.out.println("Username/password incorrect...");
		}
		
		
	}
	
	public void adminMenu() {
		AdminLogView adminLogView = new AdminLogView();
		AdminCreateView adminCreateView = new AdminCreateView();
		
		boolean run = true;
		
		while(run == true) {
			var menuId = adminLogView.render();
			
			switch(menuId) {
			case 1:
				System.out.println("Registering Admin...");
				adminCreateView.render();
				break;
			case 2:
				System.out.println("Signing in...");
				adminSignin();
				break;
			case 3:
				run = false;
				break;

			}
		}
	}
	
	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("==========*霸王茶几*===========");
		System.out.println("1. Admin");
		System.out.println("2. User");
		System.out.println("3. Exit");
		
		return keyboard.nextInt();	
	}

}
