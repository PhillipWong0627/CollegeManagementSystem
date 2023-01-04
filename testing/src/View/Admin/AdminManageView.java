package View.Admin;

import java.util.Scanner;

import IView.IView;

public class AdminManageView implements IView {
	
	

	@Override
	public int render() {
		System.out.println("=================Admin Management=================");
		System.out.println("1. Create Admin");
		System.out.println("2. Remove  Admin");
		System.out.println("3. Update Admin");
		System.out.println("4. Display all Admin");
		System.out.println("5. Back");	
		
		Scanner keyboard = new Scanner(System.in);		
		return keyboard.nextInt();
	}

}
