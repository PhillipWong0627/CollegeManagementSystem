package Entity;

public class Cart {
	//CartID
	private String itemName;
	private Double price;
	private String itemId;
	private Integer quantity;
	
	//When Creating, it will keep asking user to purchase

	public Cart(String itemName, Double price, String itemId, Integer quantity) {
		this.itemName = itemName;
		this.price = price;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [itemName=" + itemName + ", price=" + price + ", itemId=" + itemId + ", quantity=" + quantity
				+ "]";
	}
	

	

}
