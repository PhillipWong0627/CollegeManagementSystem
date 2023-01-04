package Entity;

import java.util.List;

public class Order {
	private List<Cart> orders;

	public Order(List<Cart> orders) {
		super();
		this.orders = orders;
	}

	public List<Cart> getOrders() {
		return orders;
	}

	public void setOrders(List<Cart> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Order [orders=" + orders + "]";
	}


}
