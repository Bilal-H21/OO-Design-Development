package lib;

public class BankAccount {
	
	//Fields
	private String accountNo;
	private int balance;
	
	//Constructors
	public BankAccount(){
		this.accountNo = "1234567";
		this.balance = 0;
	}
	
	public BankAccount( String accountNo, int balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public void deposit (int amountIn) {
		if (amountIn >= 0) {
			balance = balance +amountIn;
		}
	}
	
	public void withdraw (int amountOut) {
		if (amountOut >= 0) {
			balance = balance - amountOut;
		}
	}
	
	public int getBalance() {
		return balance;
	}
	
	public String toString() {
		return "Bank Account :[account no =" + accountNo + ", balance= " + balance + "]";  
	}
}
