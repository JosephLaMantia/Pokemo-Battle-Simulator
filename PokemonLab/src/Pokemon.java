//Joseph LaMantia
// CSC 330
// Lab 3 Pokemon
// Pokemon.java

import java.util.*;
public abstract class Pokemon {

	//member variables
	private int hitPoints;
	private int maxHitPoints;
	private int powerPoints;
	private int maxPowerPoints;
	private String pokemonName;
	private ArrayList<String> attacks = new ArrayList<String>();
	private String pokemonType;

	/**
	 * Abstract method that allows this Pokemon to attack the Pokemon entered into its parameter
	 * @param other Pokemon instance variable
	 */
	public abstract void attack(Pokemon other);
	
	/**
	 * Abstract method that allows Pokemon to speak, printing whatever they say
	 */
	public abstract void speak();
	
	/**
	 * Constructor: creates Pokemon and assigns name to it
	 * @param pokemonName String that names this Pokemon
	 */
	public Pokemon(String pokemonName){
		this.pokemonName = pokemonName;
	}
	
	// setters
	/**
	 * Sets this Pokemons hit points
	 * @param hp Int that represents hit points
	 */
	public void setHitPoints(int hp) {
		hitPoints = hp;
	}
	
	/**
	 * Sets this Pokemons maximum hit points
	 * @param mhp Int that represents maximum hit points
	 */
	public void setMaxHitPoints(int mhp) {
		maxHitPoints = mhp;
	}
	
	/**
	 * Sets this Pokemons power points
	 * @param pp Int that represents power points
	 */
	public void setPowerPoints(int pp) {
		powerPoints = pp;
	}
	
	/**
	 * Sets this Pokemons maximum power points
	 * @param mpp Int that represents maximum power points
	 */
	public void setMaxPowerPoints(int mpp) {
		maxPowerPoints = mpp;
	}

	/**
	 * Sets this Pokemons attacks 
	 * @param a1 String that represents 1st attack
	 * @param a2 String that represents 2nd attack
	 * @param a3 String that represents 3rd attack
	 * @param a4 String that represents 4th attack
	 */
	public void setAttacks(String a1, String a2, String a3, String a4) {
		attacks.add(a1);
		attacks.add(a2);
		attacks.add(a3);
		attacks.add(a4);
	}
	
	/**
	 * Sets this Pokemons type
	 * @param pt String that represents pokemon type
	 */
	public void setPokemonType(String pt) {
		pokemonType = pt;
	}
	
	// getters
	/**
	 * Returns this Pokemons hit points
	 * @return private int hitPoints
	 */
	public int getHitPoints() {
		return hitPoints;
	}
	
	/**
	 * Returns this Pokemons maximum hit points
	 * @return private int maximum hit points
	 */
	public int getMaxHitPoints() {
		return maxHitPoints;
	}
	
	/**
	 * Returns this Pokemons power points
	 * @return private int powerPoints
	 */
	public int getPowerPoints() {
		return powerPoints;
	}
	
	/**
	 * Returns this Pokemons maximum power points
	 * @return private int maxPowerPoints
	 */
	public int getMaxPowerPoints() {
		return maxPowerPoints;
	}
	
	/**
	 * Returns this Pokemons name
	 * @return private String pokemonName
	 */
	public String getPokemonName() {
		return pokemonName;
	}
	
	/**
	 * Returns this Pokemons type
	 * @return private String pokemonType
	 */
	public String getPokemonType() {
		return pokemonType;
	}
	
	/**
	 * Returns true or false based on whether Pokemon has reached 0 hit points or not
	 * @return true if hitPoints = 0, false otherwise
	 */
	public boolean checkForFaint() {
		if(getHitPoints() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Prints current hit points and power points of Pokemon and the Pokemon entered into its parameter
	 * @param other Pokemon instance variable
	 */
	public void status(Pokemon other) {
		if(getHitPoints() <= 0) setHitPoints(0);
		if(other.getHitPoints() <= 0) other.setHitPoints(0);
		System.out.println(getPokemonName() + " has " + getHitPoints() + " HP, and " + getPowerPoints() + " PP!");
		System.out.println(other.getPokemonName() + " has " + other.getHitPoints() + " HP, and " + other.getPowerPoints() + " PP!\n");
	}

	
	
	
	
}