package core;

import java.util.LinkedHashMap;
import java.util.Map;

import Entity.Item;

public class ItemSource {
	
	public static final Map<String, Item> ITEMSOURCE = new LinkedHashMap<>();
	
	public static Integer ITEM_INCREMENT_ID = 0;
	
	public static String getItemNextId() {
		ITEM_INCREMENT_ID+=1;
		return "ITEM-"+ITEM_INCREMENT_ID;
		
	}

}
