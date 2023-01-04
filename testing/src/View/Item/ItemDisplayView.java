package View.Item;

import java.util.Scanner;
import java.util.Map.Entry;

import Entity.Item;
import IView.IView;
import Manager.itemManager;

public class ItemDisplayView implements IView{
	private itemManager ItemManager = new itemManager();

	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		
		for(Entry<String, Item> entry:ItemManager.getAll().entrySet()) {
			System.out.println("=======================ITEMS====================");
			System.out.println("ITEM ID: " + entry.getKey());
			System.out.println("ITEM Name: " + entry.getValue().getItemName());
			System.out.println("ITEM Quantity: " + entry.getValue().getQuantity());
			System.out.println("ITEM Price: " + entry.getValue().getPrice());
			System.out.println("ITEM Cost: " + entry.getValue().getCost());


		}
		
		System.out.println("Press Any Key to Continue...");
		keyboard.nextLine();
		return 0;
	}

}
