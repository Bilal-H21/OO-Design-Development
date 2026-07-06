package main;

import lib.Module;
import lib.OrderLine;

public class ModuleDemo {

	public static void main(String[] args) {
		
		var m = new Module();
		var m1 = new Module("CTEC0000", null, 0);
		var m2 = new Module("CTEC0000", "",50);
		
		System.out.println("1: " + m. toString());
		System.out.println("2: " + m1. toString());
		System.out.println("3: " + m2. toString());
		System.out.println("");
		
		Module Module1 = new Module();
		m.setCode("CTEC2602");
		m.setName("OO Development");
		m.setExamWeight(50);
		m.setCwkWeight(50);
		
		m1.setCode("CTEC2602");
		m1.setName("OO Development");
		m1.setExamWeight(60);
		m1.setCwkWeight(40);
		
		m2.setCode("CTEC2901");
		m2.setName("Data Structures");
		m2.setExamWeight(70);
		m2.setCwkWeight(30);
		
		//show new state
		System.out.println("1: " + m.toString());
		System.out.println("2: " + m1.toString());
		System.out.println("3: " + m2.toString());
		System.out.println();
		
		//Print Module
				System.out.println("Module 1 Code: " + m.getCode() + "\t " + "Module Name: " + m.getName()+ "\t " + "Exam Weight: " + m.getExamWeight()+ "%"+ "\t " + "Coursework Weight: " + m.getCwkWeight() + "%");
				System.out.println("Module 1 Code: " + m1.getCode() + "\t " + "Module Name: " + m1.getName()+ "\t "+ "Exam Weight: " + m1.getExamWeight()+ "%" + "\t " + "Coursework Weight: " + m1.getCwkWeight() + "%");
				System.out.println("Module 1 Code: " + m2.getCode() + "\t " + "Module Name: " + m2.getName()+ "\t "+ "Exam Weight: " + m2.getExamWeight()+ "% "+ "\t " + "Coursework Weight: " + m2.getCwkWeight() + "%");
				System.out.println("");
				
				 // Change exam weight and print updated details
		        m1.setExamWeight(60);
		        System.out.println("\nUpdated Exam Weight: " + m.getExamWeight() + "%");
		        System.out.println("Updated Coursework Weight: " + m.getCwkWeight() + "%");
		    }
		 
		}
