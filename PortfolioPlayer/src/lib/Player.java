package lib;

/** A Player has a name, a gamer-tag, and a Rollable object <P>
 * This shows how a Player is a composition of Name and PairOfDice <P>
 * The Player Class implements the Comparable interface to allow comparison between players'
 * based on the name, gamertag and Rollable object
 * 
 * @author Bilal Hussen P2789063
 */

public class Player implements Comparable<Player>{
	//Fields
	private String gamertag;
	private Name name;
	private Rollable rollable;

	//Constructors
	/** Create a new instance of Player, using default name and values (for gamertag and dice)
	 */
	public Player () {
		this.gamertag = new String();
		this.name = new Name();
		this.rollable = new PairOfDice();

	}

	/** Creates a new instance of Player, with the given values. 
	 * @param name is the name of the player
	 * @param PairOfDice with the values shown on both die
	 * @param Gamer-tag with the Name value of player
	 * */
	public Player(String gamertag,Name name) {
		this.gamertag = gamertag;
		this.name = name;
		this.rollable = new PairOfDice();
	}

	/**
	 * Creates a new instance of Player, within given values
	 * @param gamertag is the gamertag for the player
	 * @param name is the name of the player
	 * @param rollable is the dice object used to roll/generate scores (when rolled)
	 */
	public Player(String gamertag,Name name, Rollable rollable) {
		this.gamertag = gamertag;
		this.name = name;
		this.rollable = rollable;

	}

	//Methods

	/**
	 * Sets the Player's name
	 * @param name is the Player's new name
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * Gets the Player's name
	 * @return the Player's name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Sets the Player's fullname by splitting the firstname and lastname. <P>
	 * The first letter of the firstname and lastname is capitalised.
	 * @param fullName is the Player's fullname which consists of the firstname and lastname.
	 *  In the format "Firstname Lastname"
	 */
	public void setPlayerFullName (String fullName) {
		String [] Break = fullName.split(" ");

		if(Break.length == 2) {
			this.name.setFirstName(Break[0].substring(0, 1).toUpperCase()
					+ Break[0].substring(1).toLowerCase());
			this.name.setFamilyName(Break[1].substring(0, 1).toUpperCase()
					+ Break[1].substring(1).toLowerCase());
		}

	}

	/**
	 * Generates a gamertag for the Player by reversing their fullname and adding a number. <P>
	 * This is created by merging their lastname and firstname in reverse order,
	 * together with a number from between 1 and 100
	 * @param num is the randomised number whihc is added to the gamertag (between 1 and 100)
	 */
	public void generateGamertag (int num) {
		if (num >= 1 && num <= 100) { 

			String fullName = name.getFamilyName().toLowerCase() + name.getFirstName().toLowerCase();;
			String reverse = "";
			for (int i = fullName.length() - 1; i >= 0; i--) {
				reverse += fullName.charAt(i);
			}

			this.gamertag = reverse + num;
		}
	}

	/**
	 * Set the Player's gamertag
	 * @param gamertag is the new gametag for the player
	 */
	public void setGamertag(String gamertag) {
		this.gamertag = gamertag;
	} 

	/**
	 * Compares the player with another player based on name then gamertag,
	 * to see if they are identical
	 * @return a negative number (less than), zero (equal to), or positive number (greater than) the other player
	 */ 
	public int compareTo(Player other) {
		int Players = this.name.compareTo(other.name);

		if (Players != 0) {
			return Players;
		}
		return this.gamertag.compareTo(other.gamertag);


	}

	/**
	 * Retrieves the rollable (dice) object corresponding to the player
	 * @return the rollable object which represents the player's dice to determine scoring
	 */
	public Rollable getRollable() {
		return rollable;
	}

	/**
	 * Gets the Player's gamertag
	 * @return the gamertag of the Player
	 */
	public String getGamertag() {
		return gamertag;
	}


	/**
	 * Rolls the dice of the player
	 */
	public void rollDice() {
		rollable.roll();
	}

	/**
	 * Gets the Player's dice score at that current time
	 * @return the total score of the dice rolled by the player
	 */
	public int getDiceScore( ) {
		return rollable.getScore();
	}

	/**
	 * Returns a string representation which includes:
	 * Name <P>
	 * Gamertag <P>
	 * Dice
	 * @return a string representation of the above
	 */
	@Override
	public String toString() {
		return "Player:[name=" + name + ", gamertag=" + gamertag + ", DiceScore="+ rollable + "]";
	}






}
