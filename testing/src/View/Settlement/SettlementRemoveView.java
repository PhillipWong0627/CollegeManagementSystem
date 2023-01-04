package View.Settlement;

import java.util.Scanner;

import IView.IView;
import Manager.settlementManager;
import core.SettlementSource;

public class SettlementRemoveView implements IView {
	private settlementManager SettlementManager = new settlementManager();

	@Override
	public int render() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please Enter Exisiting Id: ");
		String setId = keyboard.nextLine();
		
		if(SettlementSource.SETTLEMENTSOURCE.get(setId) != null) {
			SettlementManager.remove(setId);
			
			System.out.println("Settlement Report Have been removed..");

		}else {
			System.out.println("Settlement ID not exist...");
		}
		
		System.out.println("Press any key to continue...");
		keyboard.nextLine();
	
		return 0;
	}

}
