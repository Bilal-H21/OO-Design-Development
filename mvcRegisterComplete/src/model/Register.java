package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Register implements Iterable<Name>, Serializable {
	
	//Fields
	private List<Name> list;
	
	//Constructors
	public Register() {
		list = new ArrayList<Name>();
	}
	
	//Methods
	public void add(Name e) {
		list.add(e);
	}
	
	public void remove(int i) {
		list.remove(i);
	}
	
	public boolean remove(Name e) {
		return list.remove(e);
	}
	
	public Name get(int index) {
		return list.get(index);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isRegisterEmpty() {
		return list.isEmpty();
	}	
	
	public void clearRegister() {
		list.clear();
	}
	
	public boolean contains(Name n) {
		return list.contains(n);
	}
	
	@Override
	public String toString() {
		return "Register:[list=" + list + "]";
	}
	
	@Override
	public Iterator<Name> iterator() {
		return list.iterator();
	}
}
