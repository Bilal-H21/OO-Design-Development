package lib;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RegisterTest {

	/* The Register object is declared as a field so it is in scope throughout this class */
	private Register r;

	/* This method will run and create a new Register object instance before every individual unit test */
	@Before
	public void initialiseRegister() {
		r = new Register();
	}


	/* -- START OF UNIT TESTS -- */

	@Test
	public void testDefaultConstructor() {
		assertEquals("Register should be empty", true, r.isRegisterEmpty());
		assertEquals("Register should be of size zero", 0, r.registerSize());
		assertEquals("Room capacity should be set to 30", 30, r.getCapacity());
	}

	@Test
	public void testCustomConstructor() {
		var r2 = new Register(10);
		assertEquals("Register should be empty", true, r2.isRegisterEmpty());
		assertEquals("Register should be of size zero", 0, r2.registerSize());
		assertEquals("Room capacity should be set to 10", 10, r2.getCapacity());

		r2 = new Register(15);
		assertEquals("Room capacity should be set to 15", 15, r2.getCapacity());
	}

	@Test
	public void testGetCapacity() {
		assertEquals("Room capacity should return 30", 30, r.getCapacity());

		var r2 = new Register(40);
		assertEquals("Room capacity should return 40", 40, r2.getCapacity());
	}

	@Test
	public void testAddName() {
		r.addName(new Name("Joe", "Bloggs"));
		var n = new Name("Fred", "Jones");
		r.addName(n);

		assertSame("Register's last element should be the newly added name object", n, r.getNameAt(r.registerSize()-1));
		assertEquals("Register's size should be two", 2, r.registerSize());
	}

	@Test
	public void testAddNameCapacity() {
		var r2 = new Register(3);
		r2.addName(new Name("Joe", "Bloggs"));
		var n = new Name("Fred", "Jones");
		r2.addName(n);

		assertSame("Register's last element should be the newly added name object", n, r2.getNameAt(r2.registerSize()-1));
		assertEquals("Register's size should be two", 2, r2.registerSize());

		r2.addName(new Name("Anna", "Bloggs"));

		assertEquals("Register's size should be three", 3, r2.registerSize());

		r2.addName(new Name("Beth", "Bloggs"));

		assertEquals("Register's size should still be three", 3, r2.registerSize());
	}

	@Test
	public void testAddNames() {
		var names = new ArrayList<Name>();
		var n = new Name("Peter", "Bloggs");
		var n2 = new Name("Tom", "Bloggs");
		var n3 = new Name("Anna", "Jones");
		names.add(n);
		names.add(n2);
		names.add(n3);

		r.addNames(names);

		assertSame("Register's first element should be the newly added name object", n, r.getNameAt(0));
		assertSame("Register's second element should be the newly added name object", n2, r.getNameAt(1));
		assertSame("Register's third element should be the newly added name object", n3, r.getNameAt(2));
		assertEquals("Register's size should be three", 3, r.registerSize());

		names.clear();
		var n4 = new Name("Joe", "Bloggs");
		names.add(n4);

		r.addNames(names);

		assertSame("Register's forth element should be the newly added name object", n4, r.getNameAt(3));
		assertEquals("Register's size should be four", 4, r.registerSize());
	}

	@Test
	public void testAddNamesCapacity() {
		var r2 = new Register(4);

		var names = new ArrayList<Name>();
		var n = new Name("Peter", "Bloggs");
		var n2 = new Name("Tom", "Bloggs");
		var n3 = new Name("Anna", "Jones");
		names.add(n);
		names.add(n2);
		names.add(n3);

		r2.addNames(names);

		assertSame("Register's third element should be the newly added name object", n3, r2.getNameAt(2));
		assertEquals("Register's size should be three", 3, r2.registerSize());

		r2 = new Register(4);

		var n4 = new Name("Joe", "Bloggs");
		r2.addName(n4);

		r2.addNames(names);

		assertEquals("Register's size should be four", 4, r2.registerSize());

		r2 = new Register(3);

		r2.addName(n4);
		r2.addNames(names);

		assertEquals("Register's size should be one", 1, r2.registerSize());	

		r2 = new Register(4);

		r2.addName(n4);
		r2.addName(new Name("Fred", "Bloggs"));
		r2.addNames(names);

		assertEquals("Register's size should be two", 2, r2.registerSize());
	}

	@Test
	public void testGetNameAt() {
		var n = new Name("Joe", "Bloggs");
		r.addName(n);
		var n1 = new Name("Fred", "Jones");
		r.addName(n1);

		assertSame("Register should retrieve the same object added at index 0", n, r.getNameAt(0));
		assertSame("Register should retrieve the same object added at index 1", n1, r.getNameAt(1));
	}

	@Test
	public void testRemoveName() {
		r.addName(new Name("Fred", "Jones"));
		var n = new Name("Joe", "Bloggs");
		r.addName(n);

		Name n1 = r.removeName(1);

		assertSame("Register should remove and return the same object that was added", n, n1);
		assertEquals("Register's size should now be one", 1, r.registerSize());
	}

	@Test
	public void testRegisterSize() {
		assertEquals("Register's size should be zero", 0, r.registerSize());

		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));
		r.addName(new Name("Tim", "Jones"));

		assertEquals("Register's size should be three", 3, r.registerSize());
	}

	@Test
	public void testClearRegister() {
		for (int i = 0; i < 10; i++) {
			r.addName(new Name());
		}

		int sizeBeforeClear = r.registerSize();

		assertTrue("Names should have been added to register - clear cannot therefore be tested", sizeBeforeClear > 0);


		r.clearRegister();

		assertEquals("Register's size should be zero after clear", 0, r.registerSize());
	}

	@Test
	public void testIsRegisterEmpty() {
		assertTrue("Register should initially be empty, i.e. return true", r.isRegisterEmpty());

		r.addName(new Name("Joe", "Bloggs"));

		assertFalse("Register should not be empty after a name is added, i.e. return false", r.isRegisterEmpty());
	}

	@Test
	public void testToString() {
		var n = new Name("Tom", "Bloggs");
		r.addName(n);

		String toStr = r.toString();

		assertTrue("The toString method should be in the standard convention format as taught",
				toStr.startsWith("Register:[") &&
				toStr.contains(String.valueOf(r.getCapacity())) &&
				toStr.contains(n.toString()) &&
				toStr.endsWith("]"));

		/* Further check to avoid the result of toString being hardcoded */
		var r2 = new Register(10);
		n = new Name("Joe", "Bloggs");
		r2.addName(n);
		var n1 = new Name("Fred", "Jones");
		r2.addName(n1);

		toStr = r2.toString();

		assertTrue("The toString method should be in the standard convention format as taught (2)",
				toStr.startsWith("Register:[") &&
				toStr.contains(String.valueOf(r2.getCapacity())) &&
				toStr.contains(n.toString()) &&
				toStr.contains(n1.toString()) &&
				toStr.endsWith("]"));
	}

	@Test
	public void testSearchRegisterByFamilyName() {
		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));

		assertTrue("First search should find Jones, i.e. return true", r.searchRegisterByFamilyName(new String("Jones")));
		
		
		r = new Register();
		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Fred", "Wayne"));

		assertFalse("Second search should not find Jones, i.e. return false", r.searchRegisterByFamilyName(new String("Jones")));
		
		
		r = new Register();
		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));

		assertTrue("Third search should find Bloggs, i.e. return true", r.searchRegisterByFamilyName(new String("Bloggs")));
		
		
		r = new Register();
		r.addName(new Name("Joe", "Woods"));
		r.addName(new Name("Fred", "Jones"));

		assertFalse("Fourth search should not find Bloggs, i.e. return false", r.searchRegisterByFamilyName(new String("Bloggs")));
		
		
		r = new Register();
		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));

		assertTrue("Fifth search should find BLOGGS, i.e. return true", r.searchRegisterByFamilyName(new String("BLOGGS")));
		
		
		r = new Register();
		r.addName(new Name("Joe", "Woods"));
		r.addName(new Name("Fred", "Jones"));

		assertFalse("Sixth search should not find BLOGGS, i.e. return false", r.searchRegisterByFamilyName(new String("BLOGGS")));
	}

	@Test
	public void testCountFirstNameOccurrences() {
		r.addName(new Name("Jon", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));

		assertEquals("First count should return 0", 0, r.countFirstNameOccurrences('e'));
		
		
		r = new Register();
		r.addName(new Name("Luke", "Bloggs"));
		r.addName(new Name("Jen", "Jones"));

		assertEquals("Second count should return 1", 1, r.countFirstNameOccurrences('e'));
		
		
		r = new Register();
		r.addName(new Name("Luke", "Bloggs"));
		r.addName(new Name("Joe", "Jones"));

		assertEquals("Third count should return 2", 2, r.countFirstNameOccurrences('e'));
		
		
		r = new Register();
		r.addName(new Name("Luke", "Bloggs"));
		r.addName(new Name("Joe", "Jones"));

		assertEquals("Fourth count should return 0", 0, r.countFirstNameOccurrences('n'));
		
		
		r = new Register();
		r.addName(new Name("Jon", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));

		assertEquals("Fifth count should return 1", 1, r.countFirstNameOccurrences('n'));
		
		
		r = new Register();
		r.addName(new Name("Jon", "Bloggs"));
		r.addName(new Name("Jen", "Jones"));

		assertEquals("Sixth count should return 2", 2, r.countFirstNameOccurrences('n'));
	}	

	@Test
	public void testIterator() {
		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Fred", "Bones"));

		//NOTE --- There is no assert or fail in this test because the for-each loop below will only work if the Register
		//         class implements Iterable correctly. Otherwise either a compilation error or runtime exception will occur.

		for (Name n : r) { }
	}

	@Test
	public void testSort() {
		var n1 = new Name("Ted", "Bloggs");
		var n2 = new Name("Fred", "Bones");
		var n3 = new Name("Joe", "Bloggs");

		r.addName(n1); r.addName(n2); r.addName(n3);
		r.sortRegister();

		assertTrue("Elements should have been sorted based on the compareTo method of Name", r.getNameAt(0) == n3 && r.getNameAt(1) == n1 && r.getNameAt(2) == n2);
	}


	/* -- GENERAL TESTS TO ENSURE CORRECT USE OF FIELDS AND METHODS -- */

	@Test
	public void testFieldModifiers() {
		Field[] fields = Register.class.getDeclaredFields();

		assertTrue("Modifiers cannot be assessed if no fields exist", fields.length > 0);

		assertTrue("All fields must be private", Arrays.stream(fields).allMatch(f -> (Modifier.PRIVATE & f.getModifiers()) != 0));

		assertTrue("No fields should be static", Arrays.stream(fields).allMatch(f -> (Modifier.STATIC & f.getModifiers()) == 0));
	}

	@Test
	public void testFieldNumber() {
		Field[] fields = Register.class.getDeclaredFields();

		assertEquals("The Register class should have two fields", 2, fields.length);
	}

	@Test
	public void testFieldTypes() {
		Field[] fields = Register.class.getDeclaredFields();

		boolean correct = true;

		if (fields[0].getType().isAssignableFrom(int.class)) {
			correct = ArrayList.class.isAssignableFrom(fields[1].getType()) &&
					Name.class.isAssignableFrom((Class<?>)((ParameterizedType) fields[1].getGenericType()).getActualTypeArguments()[0]);
		} else {
			correct = fields[1].getType().isAssignableFrom(int.class);
			if (correct) {
				correct = ArrayList.class.isAssignableFrom(fields[0].getType()) &&
						Name.class.isAssignableFrom((Class<?>)((ParameterizedType) fields[0].getGenericType()).getActualTypeArguments()[0]);
			}
		}

		assertTrue("The Register class should only have fields of type ArrayList<Name> and int", correct);
	}

}
