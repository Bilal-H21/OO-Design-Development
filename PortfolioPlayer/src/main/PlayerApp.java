package main;

import java.util.ArrayList;

import lib.Player;

public class PlayerApp {
	public static String execute(int num, ArrayList<Player> players) {
		System.out.println("\033[1;4mPlayer App Initialised\033[0m" + "\n");
		String Output = ""; 

		for (Player player : players) {
			String gamertag = player.getGamertag(); // Get gamertag
			String Lastname = player.getName().getFamilyName().toLowerCase(); 
			
			System.out.println("Getting information of Player:" + player.getName().getFirstName() + " " + Lastname);
			System.out.println("Player Gamertag: " + gamertag);
			System.out.println("Player's Formatted Name:" + player.getName().getFirstName().toUpperCase() + ", " + Lastname + "\n"); 

			if (gamertag.toLowerCase().contains(Lastname.toLowerCase()) && gamertag.endsWith(String.valueOf(num))) {

				Output += player.getName().getFirstName().toUpperCase() + ", " + Lastname.toLowerCase() + "\n";
				


			}
		}

		 System.out.println("Final Output:\n" + Output);

		return Output; 
	}
}

