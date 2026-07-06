package strings;

import java.util.Scanner;

public class Initials {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please input a name");
		String name = in.nextLine(); //input in format Joe Bloggs
		
		char initial1 = name.charAt(0);
		
		int space = name.indexOf(" ");
		
		char initial2 = name.charAt(space+1);

		String lowerInitials = (initial1 + "" + initial2).toLowerCase();
		
		String email = lowerInitials + "@dmu.ac.uk";
		
		System.out.println(email);
		
		in.close();
	}

}

