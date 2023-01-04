package View.Item;

import java.util.Scanner;

import Entity.Item;
import IView.IView;
import Manager.itemManager;
import core.ItemSource;

public class ItemCreateView implements IView {
	itemManager ItemManager = new itemManager();

	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter Item Name: ");
		String itemsName = keyboard.next();
		
		System.out.println("Enter Item Quantity: ");
		int quantity = keyboard.nextInt();
		
		System.out.println("Enter Item Price: ");
		double price = keyboard.nextDouble();

		System.out.println("Enter Item Cost: ");
		double cost = keyboard.nextDouble();
		
		Item item = new Item(itemsName, quantity, price, cost);
		
		String id = ItemSource.getItemNextId();
				
		ItemManager.create(id, item);
		System.out.println("Items Have Been Created...");
		
		
		System.out.println("Press any key to Continue...");
		keyboard.next();

		return 0;
	}

}
