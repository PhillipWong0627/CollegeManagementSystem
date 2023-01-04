package View.Order;

import java.util.Map.Entry;

import Entity.Cart;
import Entity.Order;
import IView.IView;
import Manager.cartManager;
import Manager.orderManager;

public class OrderDisplayView implements IView {
	private orderManager OrderManager = new orderManager();

	@Override
	public int render() {
		
		for(Entry<String, Order> entry: OrderManager.getAll().entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
			
		}
		
		return 0;
	}

}
