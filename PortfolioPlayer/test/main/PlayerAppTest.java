package main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import lib.Die;
import lib.Name;
import lib.PairOfDice;
import lib.Player;

public class PlayerAppTest {

	/* Please note - when we come to mark the solution to this unit test we will change the input
	 * data set for the players added to the list to ensure the solution works dynamically based
	 * upon any given data set and is not hardcoded in any way.
	 */
	@Test
	public void testExecute() {
		var players = new ArrayList<Player>();
		players.add(new Player("Jbloggs31", new Name("Joe", "Bloggs"), new PairOfDice()));
		players.add(new Player("Fjones20", new Name("Fred", "Jones"), new Die()));
		players.add(new Player("Nsing20", new Name("Nila", "Singh"), new PairOfDice(new Die(5), new Die(5))));
		players.add(new Player("Askye20", new Name("Anna", "Skye"), new Die()));

		String result = PlayerApp.execute(20, players);

		String expectedResult = "FRED, jones\nANNA, skye\n";

		assertEquals("The string returned should match the expected result (run 1)", expectedResult, result);


		/* Test with a second set of input data */
		var players2 = new ArrayList<Player>();
		players2.add(new Player("Dblunt20", new Name("David", "Blunt"), new PairOfDice()));
		players2.add(new Player("Tother20", new Name("Tim", "Jonas"), new Die(5)));
		players2.add(new Player("Rpatel20", new Name("Remi", "Patel"), new Die()));		
		players2.add(new Player("Tcastle20", new Name("Toby", "Castle"), new PairOfDice(new Die(5), new Die(5))));


		String result2 = PlayerApp.execute(20, players2);

		String expectedResult2 = "DAVID, blunt\nREMI, patel\nTOBY, castle\n";

		assertEquals("The string returned should match the expected result (run 2)", expectedResult2, result2);


		/* Test with a third set of input data */
		var players3 = new ArrayList<Player>();
		players3.add(new Player("Dblunt20", new Name("David", "Blunt"), new PairOfDice()));
		players3.add(new Player("Tjonas35", new Name("Tim", "Jonas"), new Die(5)));
		players3.add(new Player("Rpatel35", new Name("Remi", "Patel"), new Die()));		
		players3.add(new Player("Tcastle33", new Name("Toby", "Castle"), new PairOfDice(new Die(5), new Die(5))));


		String result3 = PlayerApp.execute(35, players3);

		String expectedResult3 = "TIM, jonas\nREMI, patel\n";

		assertEquals("The string returned should match the expected result (run 3)", expectedResult3, result3);
	}

}
