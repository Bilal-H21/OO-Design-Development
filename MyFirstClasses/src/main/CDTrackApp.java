package main;

import lib.CDTrack_lib;

public class CDTrackApp {
	
	public static void main(String[] args) {
		
		CDTrack_lib track1 = new CDTrack_lib();
		track1.setTitle("Unknown Title");
		track1.setArtist("Anonymous");
		track1.setDuration(20);
		System.out.println("Title:" + track1.getTitle());
		System.out.println("Artist:" + track1.getArtist());
		System.out.println("Duration:" + track1.getDuration());
		
		
		
	}
}

