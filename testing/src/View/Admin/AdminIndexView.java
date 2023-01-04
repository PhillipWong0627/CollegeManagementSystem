package View.Admin;

import java.util.Scanner;

import IView.IView;

public class AdminIndexView implements IView {

	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("=================ADMIN MENU=================");
		System.out.println("1. MANAGE ADMIN");
		System.out.println("2. MANAGE ITEM");
		System.out.println("3. MANAGE SETTLEMENT");
		System.out.println("4. BACK");

		return keyboard.nextInt();	}

}
