package View.User;

import java.util.Scanner;

import IView.IView;

public class UserIndexView implements IView {

	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("=================USER MANUAL=================");
		System.out.println("1. DISPLAY ITEM LIST");
		System.out.println("2. ADD ITEM TO CART");
		System.out.println("3. REMOVE ITEM FROM CART");
		System.out.println("4. DISPLAY CART's ITEM");
		System.out.println("5. PLACE ORDER");
		System.out.println("6. BACK");

		return keyboard.nextInt();
	}
	

}
