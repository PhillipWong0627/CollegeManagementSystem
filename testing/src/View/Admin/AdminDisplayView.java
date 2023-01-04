package View.Admin;

import java.util.Scanner;
import java.util.Map.Entry;

import Entity.Admin;
import IView.IView;
import Manager.adminManager;

public class AdminDisplayView implements IView {
	private adminManager AdminManager = new adminManager();
	@Override
	public int render() {
		for(Entry<String, Admin> entry: AdminManager.getAll().entrySet()) {
			//System.out.println(entry.getValue());
			System.out.println("=================ADMIN================");
			System.out.println("Admin ID: " + entry.getKey());
			System.out.println("Admin Name: " + entry.getValue().getAdminName());
			System.out.println("Admin Password: "+ entry.getValue().getPassword());
		}
		System.out.println("Press Any Key To Continue...");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
		return 0;
	}

}
