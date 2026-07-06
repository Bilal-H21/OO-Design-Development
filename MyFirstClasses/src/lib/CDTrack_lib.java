package lib;

public class CDTrack_lib {

	//Fields
	private String title;
	private String artist;
	private int duration;


	//Constructors
	public CDTrack_lib() {
		title = "";
		artist = "";
		duration = 0;
	}

	public CDTrack_lib(String title, String artist, int duration) {
		this.title = title;
		this.artist = artist;
		if (duration < 0) {
			this.duration = 0;
		} else {
			this.duration = duration;
		}
	}

	
	//Methods
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		if (duration >= 0) {
			this.duration = duration;
		}
	}
	
	@Override
	public String toString() {
		return "CDTrack:[title=" + title + ", artist=" + artist + ", duration =" + duration + "]";
	}

}
