package View.Item;

import java.util.Scanner;

import IView.IView;

public class ItemIndexView implements IView {

	@Override
	public int render() {
		System.out.println("=================Item Management=================");
		System.out.println("1. Create Item");
		System.out.println("2. Remove  Item");
		System.out.println("3. Update Item");
		System.out.println("4. Display all Item");
		System.out.println("5. Back");	
		
		Scanner keyboard = new Scanner(System.in);		
		return keyboard.nextInt();		
	}

}
