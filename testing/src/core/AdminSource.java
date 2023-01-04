package core;

import java.util.LinkedHashMap;
import java.util.Map;

import Entity.Admin;

public class AdminSource {
	
	public static final Map<String, Admin> ADMIN_SOURCE = new LinkedHashMap<>();
	
	public static Integer ADMIN_INCREMENT_ID = 0;
	
	public static String getAdminNextId() {
		ADMIN_INCREMENT_ID+=1;
		return "ADMIN-"+ADMIN_INCREMENT_ID;
		
	}

}
