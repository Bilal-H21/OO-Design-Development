package scanner;

import java.util.Scanner;


public class SentenceProcessor {

	public static void main(String[] args)  {
		String sentence = "";
		int words, vowels, letters;
				
		Scanner in = new Scanner(System.in);
		
		System.out.println("Type in a sentence...\n");
		
		sentence = in.nextLine();
		
		while (!sentence.equals("exit")) {
		
			words = sentence.trim().split(" ").length;
			
			vowels = 0; 
			letters = 0;
			
			for (int i = 0; i < sentence.length(); i++) {
				char c = sentence.toLowerCase().charAt(i);
				
				if (c >= 'a' && c <= 'z')
				{
					letters++;
					
					switch(c) {
						case 'a', 'e', 'i', 'o', 'u' -> vowels++;
					}
				}
			}
			
			System.out.println("Sentence: " + sentence);
			System.out.println("Number of words in sentence? " + words);
			System.out.println("Number of vowels in sentence? " + vowels);
			System.out.println("Number of letters in sentence? " + letters);
			System.out.printf("Percentage of letters that are vowels? %.2f%%\n\n", ((vowels / (float) letters) * 100));
			
			
			System.out.println("\nNext sentence...(type exit to stop)\n");
			
			sentence = in.nextLine();
		} 
		
		System.out.println("Program terminating...");
		
		in.close();

	}

}
