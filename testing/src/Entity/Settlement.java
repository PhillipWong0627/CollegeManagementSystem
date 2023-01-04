package Entity;

import java.util.List;

public class Settlement {
	private String date;
	private String adminId;
	private List<Order> cart;
	
	public Settlement(String date, String adminId, List<Order> order) {
		this.date = date;
		this.adminId = adminId;
		this.cart = order;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public List<Order> getCart() {
		return cart;
	}

	public void setCart(List<Order> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Settlement [date=" + date + ", adminId=" + adminId + ", cart=" + cart + "]";
	}


}
