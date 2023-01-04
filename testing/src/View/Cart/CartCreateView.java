package View.Cart;

import java.util.Scanner;

import Entity.Cart;
import Entity.Item;
import IView.IView;
import Manager.cartManager;
import Manager.itemManager;
import core.CartSource;
import core.ItemSource;

public class CartCreateView implements IView{
	cartManager CartManager = new cartManager();
	itemManager ItemManager = new itemManager();
	
	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please Select Item ID: ");
		String id = keyboard.nextLine();
		
		System.out.println("How Many You Want to Purchase: ");
		int quantity = keyboard.nextInt();
		
		if(ItemSource.ITEMSOURCE.get(id) !=null) {
			if(ItemSource.ITEMSOURCE.get(id).getQuantity()>= quantity) {
				
				//Attribute to be Saved in Cart
				String itemName = ItemSource.ITEMSOURCE.get(id).getItemName();
				Double itemPrice = ItemSource.ITEMSOURCE.get(id).getPrice();
				
				
				//Attribute to be update in item Entity...
				String getItemName = ItemSource.ITEMSOURCE.get(id).getItemName();
				int getQuantity = ItemSource.ITEMSOURCE.get(id).getQuantity();
				int stock = getQuantity-quantity;
				
				double getPrice = ItemSource.ITEMSOURCE.get(id).getPrice();
				double getCost =  ItemSource.ITEMSOURCE.get(id).getCost();
				
				
				Item item = new Item(getItemName,stock,getPrice,getCost);
				ItemManager.update(id, item);
				
				
				Cart cart = new Cart(itemName,itemPrice,id, quantity);
				String cartId = CartSource.getCartNextId();
				CartManager.create(cartId, cart);
				System.out.println("Item Sucessfully add to cart");

				
				
				
			}else {
				System.out.println("ITEM OUT OF STOCK!");

			}
				
		}else {
			System.out.println("ITEM ID Not Exist..");
		}
		
		return 0;
	}

}
