package songcomparator;

import java.util.Comparator;

/* An external top-level class version of the Comparator. 
Has the benefit of being accessible across multiple classes. */
public class SongDurationReverseComparator implements Comparator <Song> {

	@Override
	public int compare(Song s1, Song s2) {
		return Integer.compare(s2.getDuration(), s1.getDuration());
	}

}