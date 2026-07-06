package controlstructures;


public class DaysOfWeekEnums {

	public enum Day {
	    MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY, SUNDAY 
	}
	
	public static void main(String[] args) {
		Day day = Day.MONDAY;

		switch (day) {
			case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("Weekday");
			case SATURDAY, SUNDAY -> System.out.println("Weekend");
			default -> System.out.println("Unknown day");
		}
		
	}

}
