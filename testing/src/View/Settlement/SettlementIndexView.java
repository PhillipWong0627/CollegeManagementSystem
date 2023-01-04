package View.Settlement;

import java.util.Scanner;

import IView.IView;

public class SettlementIndexView implements IView{

	@Override
	public int render() {
		System.out.println("=================Settlement Management=================");
		System.out.println("1. Create Settlement");
		System.out.println("2. Remove  Settlement");
		System.out.println("3. Display all Settlement");
		System.out.println("4. Back");	
		
		Scanner keyboard = new Scanner(System.in);		
		return keyboard.nextInt();	
	}

}
