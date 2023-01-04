package View.Item;

import java.util.Scanner;

import Entity.Item;
import IView.IView;
import Manager.itemManager;
import core.ItemSource;

public class ItemUpdateView implements IView{
	private itemManager ItemManager = new itemManager();

	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter exisitng item ID: ");
		String id = keyboard.nextLine();
		
		if(ItemSource.ITEMSOURCE.get(id) != null) {
			
			System.out.println("Enter Item Name: ");
			String itemsName = keyboard.next();
			
			System.out.println("Enter Item Quantity: ");
			int quantity = keyboard.nextInt();
			
			System.out.println("Enter Item Price: ");
			double price = keyboard.nextDouble();

			System.out.println("Enter Item Cost: ");
			Double cost = keyboard.nextDouble();
			
			Item inventory = new Item(itemsName, quantity, price,cost);
			ItemManager.update(id, inventory);
			
			System.out.println("Items Have Been Updated...");
		
		}

		
		System.out.println("Press any key to Continue...");
		keyboard.next();
		
		return 0;		
	}

}
