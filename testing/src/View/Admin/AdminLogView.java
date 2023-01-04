package View.Admin;

import java.util.Scanner;

import IView.IView;

public class AdminLogView implements IView{

	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("1. Register");
		System.out.println("2. Log in");
		System.out.println("3. Back");

		return keyboard.nextInt();
	}

}
