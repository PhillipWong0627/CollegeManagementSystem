package View.Cart;

import java.util.Scanner;

import Entity.Item;
import IView.IView;
import Manager.cartManager;
import Manager.itemManager;
import core.CartSource;
import core.ItemSource;

public class CartRemoveView implements IView{
	private itemManager ItemManager = new itemManager();
	private cartManager CartManager = new cartManager();


	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
	
		System.out.println("Pls Enter exisitng Cart ID: ");

		String id = keyboard.nextLine();
		
		
		if(CartSource.CARTSOURCE.get(id) !=null) {
			
			String itemId = CartSource.CARTSOURCE.get(id).getItemId();
			
			String itemName = ItemSource.ITEMSOURCE.get(itemId).getItemName();
			int store = ItemSource.ITEMSOURCE.get(itemId).getQuantity();
			store = store +1;
			Double price = ItemSource.ITEMSOURCE.get(itemId).getPrice();
			Double cost = ItemSource.ITEMSOURCE.get(itemId).getCost();
			
			//Return the quantity back
			Item item = new Item(itemName, store, price, cost);
			
			ItemManager.update(itemId, item);
			
			CartManager.remove(id);
			System.out.println("Product Have Been Removed...");

		}else {
			System.out.println("ID Not Exist...");
		}
		
		System.out.println("Press Any Key To Continue...");
		keyboard.nextLine();
		return 0;

	}
}

