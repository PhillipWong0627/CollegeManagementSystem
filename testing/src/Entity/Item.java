package Entity;

public class Item {
	private String itemName;
	private Integer quantity;
	private Double price;
	private Double cost;
	
	public Item(String itemName, Integer quantity, Double price, Double cost) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", quantity=" + quantity + ", price=" + price + ", cost=" + cost + "]";
	} 

	
}
