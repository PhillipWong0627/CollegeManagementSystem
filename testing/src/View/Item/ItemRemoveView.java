package View.Item;

import java.util.Scanner;

import IView.IView;
import Manager.itemManager;
import core.ItemSource;

public class ItemRemoveView implements IView{
	private itemManager ItemManager = new itemManager();


	@Override
	public int render() {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter exisitng item ID: ");

		String id = keyboard.nextLine();
		
		if(ItemSource.ITEMSOURCE.get(id) != null) {
			ItemManager.remove(id);
			
			System.out.println("Product Have Been Removed...");
		}else {
			System.out.println("ID not exist...");
		}
		
		System.out.println("Press Any Key To Continue...");
		
		keyboard.nextLine();

		return 0;
	}

}
