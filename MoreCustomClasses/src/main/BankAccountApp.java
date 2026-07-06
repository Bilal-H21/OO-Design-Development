package main;

import lib.BankAccount;

import java.util.Scanner;

public class BankAccountApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		var BankAccount2 = new BankAccount();
		
		System.out.println("Welcome, Dear Account Holder" + BankAccount2);
		
		while(true){
			System.out.println("Choose an option from the below List: ");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Get Bank Info");
			System.out.println("5. Exit ");
			
			int opt = scanner.nextInt();
			
			switch (opt){
				case 1:
					System.out.println("Enter amount to Deposit: ");
					int amountIn = scanner.nextInt();
					BankAccount2.deposit(amountIn);
					if (amountIn < 0) {
						System.out.println("Invalid amount");
					}  else {
						System.out.println("Deposited: " + amountIn);
					break;
					}
				
				case 2 :
					System.out.println("Enter amount to withdraw: ");
					int amountOut = scanner.nextInt();
					BankAccount2.withdraw(amountOut);
					if (amountOut < 0) {
						System.out.println("Invalid amount");
					}  else {
						System.out.println("Withdrawn: " + amountOut);
					break;
					}
					
				case 3:
					System.out.println("Current Balance for " + BankAccount2 );
					break;
					
				case 4:
					System.out.println(BankAccount2.toString());
					break;
					
				case 5: 
					System.out.println("Thank You for using the *** Bank!");
					scanner.close();
					return;
					
				default :
					System.out.println("Invalid option try again choose from the option");


			}
			
		}

	}

}

