//Joseph LaMantia
// CSC 330
// Lab 3 Pokemon
// Player.java
public abstract class Player{

	
	//methods
	/**
	 * Abstract method that returns this objects Pokemon
	 * @return private Pokemon instance variable
	 */
	public abstract Pokemon getPokemon();
	
	/**
	 * Abstract method that returns this objects Item
	 * @return private Item instance variable
	 */
	public abstract Item getItem();
	/**
	 * Abstract method that prints out a message when the Player runs away
	 */
	public abstract void run();
	/**
	 * Abstract method that prints out a message when the Player's Pokemon has fainted
	 */
	public abstract void faint();
	
	/**
	 * Abstract method that allows the player to take action
	 * @param opponent Player instance variable
	 */
	public abstract void act(Player opponent);
}
