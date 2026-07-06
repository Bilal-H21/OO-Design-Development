package maps;

import java.util.Map.Entry;
import java.util.Scanner;


public class WordCounterDemo {
	public static void main(String[] args) {
		var wc = new WordCounter();
		var sc = new Scanner(System.in);

		String word = "";

		while (!word.equals("quit")) {
			System.out.println("Type in a word or 'quit'");
			word = sc.next();
			wc.processWord(word);
			System.out.println("Word: " + word + " - Count: " + wc.getWordCount(word));

		}

		sc.close();
		System.out.println("Finished... Overview of map:");

		//iterate through each entry of the word counter
		for (Entry<String,Counter> entry : wc) {
			System.out.println(entry.getKey() + " -- " + entry.getValue());
		}

		System.out.println("\n");
		//same using forEach method
		wc.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		System.out.println("\n");
		//using the Map's forEach method, where both key and value are directly accessible
		wc.forEach((k, v) -> System.out.println(k + " " + v));


	}

}

