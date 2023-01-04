package View.Settlement;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import Entity.Admin;
import Entity.Cart;
import Entity.Order;
import Entity.Settlement;
import IView.IView;
import Manager.adminManager;
import Manager.orderManager;
import Manager.settlementManager;
import core.AdminSource;
import core.ItemSource;

public class SettlementDisplayView implements IView {
	private orderManager OrderManager = new orderManager();
	private settlementManager SettlementManager = new settlementManager();
	private adminManager AdminManager = new adminManager();
	DecimalFormat df = new DecimalFormat("#0.00	");

	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);

		for(java.util.Map.Entry<String, Settlement> entry:SettlementManager.getAll().entrySet()) {
			
			double sigmaCost = 0;
			double sigmaSellingPrice = 0;
			double sigmaSales = 0;
			double sigmaProfit = 0;
	
			double profit =0;
			
			System.out.println("=======================SETTLEMENT-"+entry.getValue().getDate()+"=======================");
			System.out.println("Settlement ID: " + entry.getKey());
			System.out.println("Settlement Datetime: " + java.time.LocalTime.now());
			
			//Get Admin ID..
			String getAdminId = entry.getValue().getAdminId();
			//System.out.println(getAdminId);
			
			//Get Admin Name by ID...
			String adminName = AdminSource.ADMIN_SOURCE.get(getAdminId).getAdminName();

			System.out.println("Settled By: " + adminName);
			System.out.println("");
			
			System.out.println("===================================================================");
			System.out.println("No. \t Item Name \t Cost Price \t Selling Price \t Sales \t Profit ");
			System.out.println("===================================================================");
			
			//Tipss
			
			
			for(Order order: entry.getValue().getCart()) {
				
				List<Cart> something = order.getOrders();
				
				for(Cart e:something) {
					String returnItemId = e.getItemId();
//					
					int sales = e.getQuantity();
					String itemId = e.getItemId();
					String itemName = e.getItemName();
					Double itemCost = ItemSource.ITEMSOURCE.get(returnItemId).getCost();
					Double itemPrice = e.getPrice();
					
					profit = (itemPrice - itemCost)*sales;
//					
					System.out.println(returnItemId + "\t " + itemName + "\t\t " + itemCost
							+"\t\t " + itemPrice + "\t\t " + sales +"\t " + df.format(profit));
					
					sigmaCost+=itemCost;
					sigmaSellingPrice+=itemPrice;
					sigmaSales+=sales;
					sigmaProfit+=profit;

					
//					System.out.println(e.getItemId());
//					System.out.println(e.getItemName());
//					System.out.println(e.getPrice());
//					System.out.println(e.getQuantity());

				}
				
				//System.out.println(something);
				
			}
			OrderManager.getAll().clear();
	
//			for(Order order: entry.getValue().getCart()) {
//				
//				String returnItemId = order.getItemId();
//				
//				int sales = order.getQuantity();
//				String itemId = order.getItemId();
//				String itemName = order.getItemName();
//				Double itemCost = ItemSource.ITEMSOURCE.get(returnItemId).getCost();
//				Double itemPrice = order.getPrice();
//				
//				profit = (itemPrice - itemCost)*sales;
//				
//				System.out.println(returnItemId + "\t " + itemName + "\t\t " + itemCost
//						+"\t\t " + itemPrice + "\t\t " + sales +"\t " + df.format(profit));
//				
//				sigmaCost+=itemCost;
//				sigmaSellingPrice+=itemPrice;
//				sigmaSales+=sales;
//				sigmaProfit+=profit;
//				
//			}


			System.out.println("===================================================================");
			System.out.println("\t \t \t " + sigmaCost + "\t\t "
					+ sigmaSellingPrice + "\t \t " + sigmaSales + "\t "
					+ df.format(sigmaProfit));
			System.out.println();
			
			
			System.out.println("Press Any Key To Continue...");
			keyboard.nextLine();

		}
		
		return 0;
	}

}
