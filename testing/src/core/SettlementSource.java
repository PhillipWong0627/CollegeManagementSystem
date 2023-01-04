package core;

import java.util.LinkedHashMap;
import java.util.Map;

import Entity.Settlement;

public class SettlementSource {
	public static final Map<String, Settlement> SETTLEMENTSOURCE = new LinkedHashMap<>();
	
	public static Integer AUTO_INCREMENT_ID = 0;
	
	public static String getSettlementNextId() {
		AUTO_INCREMENT_ID+=1;
		return "SETTLEMENT-"+ AUTO_INCREMENT_ID;
		
	}
	
	
}
