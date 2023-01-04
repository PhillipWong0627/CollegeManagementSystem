package View.Settlement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entity.Cart;
import Entity.Order;
import Entity.Settlement;
import IView.IView;
import Manager.settlementManager;
import core.AdminSource;
import core.CartSource;
import core.OrderSource;
import core.SettlementSource;
import main.ChageePOSSystemApp;

public class SettlementCreateView implements IView{
	private settlementManager SettlementManager = new settlementManager();

	
	@Override
	public int render() {

		
		Scanner keyboard = new Scanner(System.in);
		
		//Get A Real Time Date...
		System.out.println("Enter Today's date: ");
		String date = keyboard.nextLine();
		
		//Get Admin Name.. 

		System.out.println("Enter Your Admin ID: ");
		String adminId = keyboard.nextLine();
		
		if(AdminSource.ADMIN_SOURCE.get(adminId)!=null) {
			
			String adminName = 	AdminSource.ADMIN_SOURCE.get(adminId).getAdminName();
			//System.out.println(adminName);

			//List<Cart> cart = new ArrayList<Cart>(CartSource.CARTSOURCE.values());	
			List<Order> order = new ArrayList<Order>(OrderSource.ORDERSOURCE.values());
			//System.out.println(order);
			
			/*Saving Cart Data Like itemName, price, itemId, quantity in to 
			 * list variable cart...
			*/
			Settlement settlement = new Settlement(date,adminId,order);
			//System.out.println(settlement);
			
			String id = SettlementSource.getSettlementNextId();
			SettlementManager.create(id, settlement);
			
			System.out.println("Settlement have been Created...");
			
		}else {
			System.out.println("Please Enter Correct AdminID!!!");
		}

		
		System.out.println("Press Any Key to Continue...");
		keyboard.next();
		return 0;
		
	}

}
