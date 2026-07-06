package maps;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class WordCounter implements Iterable<Map.Entry<String, Counter>> {
	//fields
	private Map<String, Counter> lookup;

	//constructors
	public WordCounter() {
		lookup = new TreeMap<String, Counter>();
	}

	//methods
	public void processWord(String word) {
		lookup.computeIfAbsent(word, v -> new Counter()).increment();
	}

	public int getWordCount(String word) {
		Counter c = lookup.getOrDefault(word, new Counter());
		return c.getCount();
	}

	@Override
	public String toString() {
		return "WordCounter[lookup=" + lookup + "]";
	}

	@Override
	public Iterator<Map.Entry<String, Counter>> iterator() {
		return lookup.entrySet().iterator();
	}

	//provides a method that delegates to the internal map's specialised forEach method
	public void forEach(BiConsumer<? super String, ? super Counter> action) {
		lookup.forEach(action);
	}

}

