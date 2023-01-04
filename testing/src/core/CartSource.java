package core;

import java.util.LinkedHashMap;
import java.util.Map;

import Entity.Cart;

public class CartSource {
	
	public static final Map<String, Cart> CARTSOURCE = new LinkedHashMap<>();
	
	public static Integer CART_INCREMENT_ID=0;
	
	public static String getCartNextId() {
		CART_INCREMENT_ID+=1;
		
		return "CART-"+ CART_INCREMENT_ID;

	}
	
}
