package View.Admin;

import java.util.Scanner;

import Entity.Admin;
import IView.IView;
import Manager.adminManager;
import core.AdminSource;

public class AdminUpdateView implements IView{
private adminManager AdminManager = new adminManager();
	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter Exisitng Admin ID: ");
		String adminId = keyboard.nextLine();
		
		if(AdminSource.ADMIN_SOURCE.get(adminId) != null) {
			
			System.out.println("Admin Name: ");
			String adminName = keyboard.nextLine();
			
			System.out.println("Password: ");
			String password = keyboard.nextLine();

			Admin admin = new Admin(adminName,password);
			
			AdminManager.update(adminId, admin);
			
			System.out.println("Admin Updated..");
		}else {
			System.out.println("Admin ID Not Exist...");
		}

		
		System.out.println("Press Any Key To Continue...");
		keyboard.nextLine();		
		return 0;
	}

}
