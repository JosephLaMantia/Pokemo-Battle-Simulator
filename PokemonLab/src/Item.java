//Joseph LaMantia
// CSC 330
// Lab 3 Pokemon
// Player.java
public interface Item {

	/**
	 * Allows Item to be used on a Pokemon
	 * @param p Pokemon instance variable
	 */
	public void use (Pokemon p);
	
	/**
	 * Checks if Item has been used 
	 * @return true if Item has been used, false otherwise
	 */
	public boolean itemUsed();
}
