package sets;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SetUniqueWordsDemo {
	public static void main(String[] args) {

		Set<String> unique = new HashSet<String>();

		//if change to tree set then unique words are ordered
		//Set<String> unique = new TreeSet<String>();
		List<String> duplicate = new LinkedList<String>();

		var sc = new Scanner(System.in);
		System.out.println("Type in a sentence or 'quit'");

		String sentence = sc.nextLine();

		while (!sentence.equals("quit")) {
			for (String word : sentence.split(" ")) {
				if (!unique.add(word)) { 
					duplicate.add(word);
				}
			}

		System.out.println("There were " + unique.size() + " unique words in your sentence:");

			for (String word : unique) {
				System.out.println(word);
			}

		System.out.println("\nThere were " + duplicate.size() + " duplicate words in your sentence:");
		
			for (String word : duplicate) {
				System.out.println(word);
			}

			unique.clear();
			duplicate.clear();

			System.out.println("Type in another sentence or 'quit'");
			sentence = sc.nextLine();
			
		}

		sc.close();

	}

}

