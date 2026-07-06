package lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *  The Register clas stores a list of names which comprises of
 *  firstnames and lastnames.<P>
 *  
 *  This is representative of an aggregation of names<P>
 *  
 *  The Register Class implements the Iterator interface and therefore allows iteration
 *  (over the names) in the Register
 *  
 *  @author Bilal Hussen P2789063
 */

public class Register implements Iterable<Name> {

	//Fields
	/** A list to store names within the register
	 */
	private ArrayList<Name> Name;

	private int Capacity;


	//Default Constructors
	/** Create a new instance for the Register, using default names and values.<P>
	 *  The Register is set to the maximum capacity of 30
	 */
	public Register() {
		Name = new ArrayList<>();
		Capacity = 30;
	}

	//Custom Constructor
	/** Create a new instance for the Register, with given values <P>
	 * @param Capacity is the number of people/capacity in the room
	 */
	public Register(int Capacity) {
		this.Name = new ArrayList<>();
		this.Capacity = Capacity;
	}


	//Methods
	/**
	 * This Iterator method returns a Name which allows iteration over the list.
	 */
	public Iterator<Name> iterator() {
		return Name.iterator();

	}
	/**
	 * Sorts the Register into an natural/alphabetical order.
	 */
	public void sortRegister() {
		Collections.sort(Name);
	}

	/**
	 * Gets the current room capacity.
	 * @return the value of the current room capacity from the Capacity field
	 */
	public int getCapacity() {
		return Capacity;
	}


	/**
	 * Adds one name to the register if the capacity is less than 30
	 * @param The Name object "e" is added to the register
	 */
	public void addName(Name e) {
		if (Name.size() < Capacity) {
			Name.add(e);
		}
	}


	/**
	 * Adds multiple names to the register if the capaciity is less than 330
	 * @param NamesToAdd is the liat of Name objects that is to be added to the register
	 * @return True if all the names are added to the register successfully <P>
	 *         False if there is insufficient capacity, and the names do not get added to the register
	 */
	public  boolean addNames(ArrayList<Name> NamesToAdd) {
		if (Name.size()+ NamesToAdd.size() <= Capacity) {
			this.Name.addAll(NamesToAdd);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Removes a name from the register depending on it's posistion/place in the list
	 * @param pos is the index of the Name object to delete
	 * @return the Name object which is removed
	 */
	public Name removeName(int pos) {
		return Name.remove(pos);
	}

	/**
	 * Locates and retrieves a name from the register depending on it's position/place in the list
	 * @param pos is the index of the Name object to locate and retreive
	 * @return the Name object at the specified postion
	 */
	public Name getName(int pos) {
		return Name.get(pos);
	}

	/**
	 * Finds the size of the register by returning the number of names that are currently within the register
	 * @return the number of names in the register
	 */
	public int registerSize() {
		return Name.size();
	}

	/**
	 * Clears all the names from the register
	 * registerSize will be 0 after this 
	 */
	public void clearRegister() {
		Name.clear();
	}

	/**
	 * Determines whether the register is empty or not
	 * @return True if the register is empty (contains no names)<P>
	 *         False if register is not empty (still contains names)
	 */
	public boolean isRegisterEmpty() {
		return Name.isEmpty();
	}

	/**
	 * Locates and retrieves a name from the register dependingg on index specified
	 * @param index refers to the 'index of the Name object' which is being retrieved
	 * @return the Name object at the specified index
	 */
	public Name getNameAt(int index) {
			return Name.get(index);
		
	}

	/**
	 * Searches for a name within the register by the Family Name (lastname)
	 * @param familyName the Family Name/lastname to look for in the register
	 * @return True if a Family Name is found <P>
	 *         False if Family Name not found
	 */
	public boolean searchRegisterByFamilyName(String familyName) {
		boolean exists = false;
		for (Name e : Name) {
			if (e.getFamilyName().equalsIgnoreCase(familyName)) {
				exists = true;
			}
		}

		return exists;
	}

	/**
	 * Counts the number of Firstnames end with a specific character, in the register
	 * @param c is the specified character to check for at the end of each Firstname
	 * @return the number of Firstnames that end with the specified character
	 */
	public int countFirstNameOccurrences(char c) {
		int count = 0;

		for (Name e : Name) {
			if (e.getFirstName().endsWith(String.valueOf(c))) {
				count++;
			}
		}

		return count;
	}

	/**
	 * Returns a string representation of the Register which includes: <P>
	 * -The capacity, <P>
	 * -The number of names, <P>
	 * -The list of names
	 * @return a string representation of the Register
	 */
	@Override
	public String toString() {
		return "Register:[RoomCapacity=" + Capacity + ", Number of Names=" + Name.size() + ", Names in Register="+ Name + "]";

	}







}
