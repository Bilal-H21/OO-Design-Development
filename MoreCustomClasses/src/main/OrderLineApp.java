package main;

import lib.OrderLine;

public class OrderLineApp {

	public static void main(String[] args) {
		
		var o1 = new OrderLine();
		var o2 = new OrderLine("Tuna (4 Pack)");
		var o3 = new OrderLine("Tuna (4 Pack)", 399,2);
		
		System.out.println("1: " + o1. toString());
		System.out.println("2: " + o2. toString());
		System.out.println("3: " + o3. toString());
		System.out.println("");
		
		OrderLine Order1 = new OrderLine();
		o1.setId("Tuna (4 Pack)");
		o1.setUnitPrice(399);
		o1.setQuantity(2);
		
		o2.setUnitPrice(10);
		o2.setQuantity(25);
		
		o3.setId("Orange");
		
		//show new state
		System.out.println("1: " + o1.toString());
		System.out.println("2: " + o2.toString());
		System.out.println("3: " + o3.toString());
		System.out.println();
		
		//work out total cost
		int totalCost = o1.getCost() + o2.getCost() + o3.getCost();
				
		//Print order
		System.out.println("1:\t" + o1.getQuantity() 
				+ " * " + o1.getId()
				+ "\t@ " + o1.getUnitPrice() + "p"
				+ "\t" + o1.getCost() + "p");
		
		System.out.println("2:\t" + o2.getQuantity() 
				+ " * " + o2.getId()
				+ "\t@ " + o2.getUnitPrice() + "p"
				+ "\t" + o2.getCost() + "p");

		System.out.println("3:\t" + o3.getQuantity() 
				+ " * " + o3.getId()
				+ "\t@ " + o3.getUnitPrice() + "p"
				+ "\t" + o3.getCost() + "p");

		System.out.println("Total cost = " + totalCost + "p");

		

		
		
		
		
	
	}

}
