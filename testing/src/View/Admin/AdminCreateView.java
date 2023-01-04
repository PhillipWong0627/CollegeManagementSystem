package View.Admin;

import java.util.Scanner;

import Entity.Admin;
import IView.IView;
import Manager.adminManager;
import core.AdminSource;

public class AdminCreateView implements IView{
	private adminManager AdminManager = new adminManager();
	AdminDisplayView adminDisplayView = new AdminDisplayView();
	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Admin Name: ");
		String adminName = keyboard.nextLine();
		
		System.out.println("Password: ");
		String password = keyboard.nextLine();
		
		String adminId = AdminSource.getAdminNextId();
		Admin admin = new Admin(adminName,password);
		
		AdminManager.create(adminId, admin);
		
		System.out.println("Admin Created..");
//		adminDisplayView.render();
		
		System.out.println("Press Any Key To Continue...");
		keyboard.next();
		
		return 0;
	}

}
