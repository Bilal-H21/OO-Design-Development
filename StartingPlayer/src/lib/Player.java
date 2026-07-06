package lib;

import lib.Name;
import lib.PairOfDice;

/** A Player has a name, a gamer-tag, and a pair of dice to roll for this game
 * This shows how a Player is a composition of Name and PairOfDice
 */

public class Player {
	//Fields
	private Name name;
	private PairOfDice pairofdice;
	private String gamertag;
	
	//Constructors
	/** Create a new instance of Player, using default name and values.
	 */
	public Player () {
		this.name = new Name();
		this.pairofdice = new PairOfDice();
		this.gamertag = new String();
	}
	
	/** Creates a new instance of Player, with the given values. 
     * @param name the name of the player
     * @param PairOfDice with the values shown on both die
     * @param Gamer-tag with the Name value of player
     * */
	public Player(Name name, String gamertag) {
		this.name = name;
        this.pairofdice = new PairOfDice();
        this.gamertag = gamertag;
	}
	public Player(Name name, PairOfDice pairofdice, String gamertag) {
		this.name = name;
        this.pairofdice = pairofdice;
        this.gamertag = gamertag;
	}
	
     //Methods
        public void setName(Name name) {
            this.name = name;
        }

        public void setPairOfDice(PairOfDice pairofdice) {
            this.pairofdice = pairofdice;
        }

        public void setgamertag(String gamertag) {
            this.gamertag = gamertag;
        }
        
        public Name getName() {
        	return name;
        }
        
        public PairOfDice getPairOfDice() {
        	return pairofdice;
        }
        
        public String getgamertag() {
        	return gamertag;
        }
        
        public void rollDice() {
        	pairofdice.roll();
        }
        
        public int getDiceScore( ) {
        	return pairofdice.getScore();
        }
        
        @Override
        public String toString() {
        	return "Player:[name=" + name + ", gamertag=" + gamertag + ", DiceScore="+ getDiceScore() + "]";
        }
	
	
	

	

}
