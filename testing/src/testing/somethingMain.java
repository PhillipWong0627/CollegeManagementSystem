package testing;

import java.util.Scanner;

public class somethingMain {
	public static void main(String[] args) {
		something signin = new something();
		SetAndGet setAndGet = new SetAndGet();
		
		setAndGet = signin.names();
		System.out.println(setAndGet.getName());

		
	}

}

class something {
	public SetAndGet names() {
		SetAndGet tell = new SetAndGet();
		
		Scanner keyboard = new Scanner(System.in);
		
		String adminName = keyboard.nextLine();
		
		//System.out.println(adminName);

		tell.setName(adminName);
		
		return tell;	
	}
}

class SetAndGet {
	private String adminInfo;
	
	String getName() {
		return adminInfo;
	}
	
	public void setName(String adminName) {
		adminInfo = adminName;
	}
}
