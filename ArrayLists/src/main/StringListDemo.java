package main;

import java.util.ArrayList;
import java.util.List;


public class StringListDemo {
	
	public static void main(String[] args) {
		//create a new arraylist of strings
		List<String> fruit = new ArrayList<String>();
		
		//add some strings to the array list
		fruit.add("Apple");
		fruit.add("Pear");
		fruit.add("Orange");
		fruit.add("Banana");
		fruit.add("Strawberry");
		fruit.add("Grape");
		
		//output contents of the arraylist
		System.out.println(fruit.toString());
		
		//using set method
		fruit.set(0, "Kiwi");
		fruit.set(2, "Apple");
		
		System.out.println(fruit.toString());
		
		//testing remove
		fruit.remove(1);
		fruit.remove(fruit.size()-1);
		
		System.out.println(fruit.toString() +"\n");
		
		
		//loop through each item in the arraylist and output
		//each string in lowercase
		
		//using for each, simpler for string output 
		//but not for line numbers
		for (String s : fruit) {
			System.out.println(s.toUpperCase());
		}
		
		System.out.println("\n");
		
		//using for-i, slightly more code for string output 
		//but simpler for line numbers as have access to index
		for (int i = 0; i < fruit.size(); i++) {
			System.out.println((i+1) + " : " + fruit.get(i).toUpperCase());
		}
		
		System.out.println("\n");
		
		//using forEach method to output each string in lowercase
		fruit.forEach(s -> System.out.println(s.toLowerCase()));

		
	}

}
