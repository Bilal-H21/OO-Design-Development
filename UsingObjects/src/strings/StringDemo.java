package strings;

public class StringDemo {

	public static void main(String[] args) {
		
		//creates a String literal
		String myName = "Wayne Rooney";	
		//declares a variable of type char
		char c;
		
		//prints out the value of the String literal
		System.out.println(myName);
		
		//invokes the charAt method on the String literal object "myName" passing
		//the parameter value 3 and assigning the returned character to "c"
		c = myName.charAt(3);
		
		//concatenates the character to a String literal and prints it
		System.out.println("4th character is: " + c);

		//concatenates the int value returned by the length method
		//to another String literal and prints it.
		System.out.println("Length is: " + myName.length());		

		//invokes the endsWith method, passing the parameter value "ney"
		//and evaluates the boolean value returned
		if (myName.endsWith("ney") ) {
			System.out.println(myName + " ends with \"ney\" ");
		} else { 
			System.out.println(myName + " does not end with \"ney\" ");
		}

		//...TO COMPLETE...try more String methods listed in the API
		String name2 = myName.toUpperCase();
		System.out.println(myName);
		myName.equals(name2);
		
		public String myName; replace(n, l);
		
		public String myName; substring(4, 8);
		
		public int indexOf(myName,R);


	}

}
