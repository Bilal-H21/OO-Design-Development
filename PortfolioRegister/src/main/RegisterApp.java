package main;

import lib.Name;
import lib.Register;

public class RegisterApp {

	public static String execute(Register regst, Name n) {
		System.out.println("\033[1;4mRegister App Initialised\033[0m" + "\n");
		if (regst.registerSize() > 1) {
			System.out.println("Removing name present at index 1");
			regst.removeName(1);
		}
		
		regst.addName(n);
		System.out.println("Adding a new name to the Register: " + n.getFirstName() + " " + n.getFamilyName() + "\n");




		String emailList = "";
		
		for (int i = 0; i < regst.registerSize(); i++) {
			Name CurrentName = regst.getNameAt(i);
			String FirstName = CurrentName.getFirstName().toLowerCase();
			String LastName =  CurrentName.getFamilyName().toLowerCase();
			System.out.println("Register Name look-up:" + FirstName + " " + LastName);

			if (FirstName.contains("a") || FirstName.contains("e")) {
				String email = FirstName.charAt(0) + "." +
						LastName.substring(0,3) + "@email.com";
				System.out.println("Email Address of stated Name:" + " " + email + "\n");



				emailList += email + "\n";
			} else {
				System.out.println("Firstname does not have the letter A or E - Email Address has not been created" + "\n");
			}
			

		}
		System.out.println("List of shown emails:" + "\n" +emailList);
		return emailList;
	}
}