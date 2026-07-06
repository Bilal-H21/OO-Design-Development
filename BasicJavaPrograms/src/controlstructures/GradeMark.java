package controlstructures;

import java.util.Scanner;

public class GradeMark {

	public static void main(String[] args) {

		//read a number from the keyboard in the console
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please input a mark");
		int mark = sc.nextInt();
		
		sc.close();
		
		if (mark >= 40) {
			if (mark >= 70) {
				System.out.println("Distinction.");
			} else if (mark >= 60) {
				System.out.println("Merit.");
			} else {
				System.out.println("Pass.");
			}
		} else {
			System.out.println("You failed.");
		}
		
	}

}
