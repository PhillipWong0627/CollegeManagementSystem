package core;

import java.util.LinkedHashMap;
import java.util.Map;

import Entity.Order;

public class OrderSource {
	public static final Map<String, Order> ORDERSOURCE = new LinkedHashMap<>();
	
	public static Integer ORDER_AUTO_INCREMENT = 0;
	
	public static String getOrderNextId() {
		ORDER_AUTO_INCREMENT+=1;
		return "ORDER-"+ORDER_AUTO_INCREMENT;
		
	}
}
