package View.Admin;

import java.util.Scanner;

import IView.IView;
import Manager.adminManager;
import core.AdminSource;

public class AdminRemoveView implements IView {
	private adminManager AdminManager = new adminManager();

	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter Exisitng Admin ID: ");
		String adminId = keyboard.nextLine();
		
		if(AdminSource.ADMIN_SOURCE.get(adminId) !=null) {
			AdminManager.remove(adminId);
			System.out.println("Admin Have been removed...");
		}else {
			System.out.println("ID not exist...");
		}
		
		return 0;
	}

}
