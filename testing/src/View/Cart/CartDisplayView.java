package View.Cart;

import java.util.Scanner;
import java.util.Map.Entry;

import Entity.Cart;
import IView.IView;
import Manager.cartManager;

public class CartDisplayView implements IView {
	private cartManager CartManager = new cartManager();

	@Override
	public int render() {
		for(Entry<String, Cart> entry: CartManager.getAll().entrySet()) {
			System.out.println("=============CART==============");
			System.out.println("Cart ID: " +entry.getKey());
			System.out.println("Item Name: " +entry.getValue().getItemName());
			System.out.println("Item Price: " +entry.getValue().getPrice());
			System.out.println("Item ID: " + entry.getValue().getItemId() );
			System.out.println("Quantity: " + entry.getValue().getQuantity() );
			System.out.println("===============================");
			
			
		}
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Press any key to Continue...");
		keyboard.nextLine();
		
		return 0;
	}

}
