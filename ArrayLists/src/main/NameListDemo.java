package main;

import lib.Name;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class NameListDemo {

	public static void main(String[] args) {
		//create a new arraylist of type Name
		List<Name> register = new ArrayList<>();
		Scanner scanner = new Scanner (System.in);
		
		for (int i=0; i < 4; i++) {
			System.out.println("Enter Your First Name: ");
			String firstName = scanner.nextLine();
			System.out.println("Enter Your Family Name: ");
			String familyName = scanner.nextLine();
			
			register.add(new Name(firstName, familyName));

		}
			
		//print using forEach method (added in Java 8)
		System.out.println("Using forEach method");
		//passes a lambda expression to the method
		register.forEach(name -> System.out.println(name.getFullName()));
		
		boolean exists = register.stream()
				.anyMatch(name -> name.getFamilyName()
				.equals("Smith"));
		if (exists) {
			System.out.println("There is a person with family name 'Smith' in the register");
		}else {
			System.out.println("There is no one with the family name 'Smith'");
		}
		
		
		System.out.println("Printing Name Longer than 10 Characters: ");
		register.stream()
		.filter(name -> name.getFullName().length() > 10)
		.forEach(name -> System.out.println(name.getFullName()));
		
		Name existingName = new Name("Bilal", "Hussen");
		
		boolean Contains = register.contains(existingName);
		System.out.println("Does register already have the name 'Bilal Hussen'? " + Contains);
		scanner.close();

		}


}
