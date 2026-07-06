package main;

import java.util.ArrayList;
import java.util.Scanner;

import lib.OrderLine;

public class OrderLineListDemo {

	public static void main(String[] args) {
		var orders = new ArrayList<OrderLine>();
		
		var in = new Scanner(System.in);
		
		String id;
		int price, quantity;
		
		for (int i = 0; i < 4; i++) {
			
			System.out.println("Input an id");
			id = in.nextLine();
			
			System.out.println("Input an price");
			price = in.nextInt();
			
			System.out.println("Input an quantity");
			quantity = in.nextInt();
			
			in.nextLine(); //skips past new line for next iteration
			
			orders.add(new OrderLine(id, price, quantity));		
		}
		
		in.close();
		
		
		for (OrderLine x : orders) {
			System.out.println(x.toString());
		}
		
		
		int total = orders.stream().mapToInt(o -> o.getCost()).sum();
		
		double avg = orders.stream().mapToInt(o -> o.getCost()).average().getAsDouble();
			
		System.out.println("Total cost of all orders is " + total);
		
		System.out.println("Average cost of all orders is " + avg);
		
		
		
	}

}
