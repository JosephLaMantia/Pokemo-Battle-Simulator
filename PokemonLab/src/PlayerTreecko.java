//Joseph LaMantia
// CSC 330
// Lab 3 Pokemon
// PlayerTreecko.java
import java.util.Scanner;
public class PlayerTreecko extends Pokemon {

	private Scanner input = new Scanner(System.in);
	private boolean validInput;
	
	/**
	 * Constructor that:
	 * calls super to name pokemon
	 * sets hit points and max hit points = 50
	 * sets power points and max power points = 20
	 * sets pokemons attacks
	 * sets pokemons type
	 * sets boolean validInput = false
	 * @param pokemonName String that names this Pokemon
	 */
	public PlayerTreecko(String pokemonName) {
		super(pokemonName);
		setHitPoints(50);
		setMaxHitPoints(50);
		setPowerPoints(20);
		setMaxPowerPoints(20);
		setAttacks("Pound", "Leafage", "Mega Drain", "Quick Attack");
		setPokemonType("Grass");
		validInput = false;
	}
	
	/**
	 * Normal type attack with base damage = 15
	 * Power point requirement = 5
	 * Prints effects
	 * @param other Pokemon instance variable
	 */
	public void pound(Pokemon other) {	// normal-type attack (no modifiers)
		int damage = 15;
		int powerNeeded = 5;
		
		if(getPowerPoints() >= powerNeeded)	{	// check if pokemon has enough powerPoints
			System.out.println(getPokemonName() + " used Pound!");
			setPowerPoints(getPowerPoints() - powerNeeded);
			other.setHitPoints(other.getHitPoints() - damage);
			System.out.println(other.getPokemonName() + " took " + damage + " damage!");
			status(other);
		}
		else System.out.println("Not enough PP!");
	}
	
	/**
	 * Normal type attack with base damage = 8
	 * Power point requirement = 0
	 * Prints effects
	 * @param other Pokemon instance variable
	 */
	public void quickAttack(Pokemon other) {	// normal-type attack (no modifiers)
		int damage = 8;
		int powerNeeded = 0;
		
		if(getPowerPoints() >= powerNeeded)	{	// check if pokemon has enough powerPoints
			System.out.println(getPokemonName() + " used Quick Attack!");
			other.setHitPoints(other.getHitPoints() - damage);
			System.out.println(other.getPokemonName() + " took " + damage + " damage!");
			status(other);
		}
		else System.out.println("Not enough PP!");
	}
	
	/**
	 * Grass type attack with base damage = 10
	 * Power point requirement = 0
	 * uses grassModifier to determine attacks effectiveness
	 * Prints effects
	 * @param other Pokemon instance variable
	 */
	public void leafage(Pokemon other) {	// grass-type attack
		int damage = 10;
		int powerNeeded = 0;
		
		if(getPowerPoints() >= powerNeeded)	{	// check if pokemon has enough powerPoints
			System.out.println(getPokemonName() + " used Leafage!");
			damage = grassModifier(damage, other);	// run grass type modifier
			other.setHitPoints(other.getHitPoints() - damage);
			System.out.println(other.getPokemonName() + " took " + damage + " damage!");
			status(other);
		}
		else System.out.println("Not enough PP!");
	}
	
	/**
	 * Grass type attack with base damage = 20
	 * Power point requirement = 15
	 * uses grassModifier to determine attacks effectiveness
	 * Prints effects
	 * @param other Pokemon instance variable
	 */
	public void megaDrain(Pokemon other) {	// grass-type attack
		int damage = 20;
		int powerNeeded = 15;

		if(getPowerPoints() >= powerNeeded)	{	// check if pokemon has enough powerPoints
			System.out.println(getPokemonName() + " used Mega Drain!");
			damage = grassModifier(damage, other);	// run grass type modifier
			other.setHitPoints(other.getHitPoints() - damage);
			setPowerPoints(getPowerPoints() - powerNeeded);
			System.out.println(other.getPokemonName() + " took " + damage + " damage!");
			
			setHitPoints(getHitPoints() + damage / 2);	// mega drain heals for half of damage dealt
			if(getHitPoints() > getMaxHitPoints()) {	// check if over maximum HP
				setHitPoints(getMaxHitPoints());
			}	
			
			System.out.println(getPokemonName() + " stole " + damage/2 + " HP!");	
			status(other);
		}
		else System.out.println("Not enough PP!\n");
	}

	
	/**
	 * Returns Int that represents damage after grass type modifiers have been applied.
	 * Super effective vs. Ground, Rock, Water
	 * Not very effective vs. Bug, Fire, Flying, Grass, Poison
	 * No effect vs. N/A
	 * @param dmg Int representing attacks damage
	 * @param other Pokemon instance variable
	 * @return dmg Int after modifiers applied
	 */
	public int grassModifier(int dmg, Pokemon other) {	// calculates damage based on opponents type
		if(other.getPokemonType() == "Ground" 
				|| other.getPokemonType() == "Rock" 
				|| other.getPokemonType() == "Water" ) {
			dmg = dmg * 2;
			System.out.println("Super effective!");
			System.out.println("");
		}
		if(other.getPokemonType() == "Bug" 
				|| other.getPokemonType() == "Fire" 
				|| other.getPokemonType() == "Flying" 
				|| other.getPokemonType() == "Grass" 
				|| other.getPokemonType() == "Poison" ) {
			dmg = dmg / 2;
			System.out.println("Not very effective!");
		}
		
		return dmg;
	}
	

	@Override
	public void attack(Pokemon other) {
		
		System.out.println("Which attack will " + getPokemonName() + " use?");
		System.out.println("1. Pound (5PP)");
		System.out.println("2. Quick Attack");
		System.out.println("3. Leafage");
		System.out.println("4. Mega Drain (15PP)");
		
		//user input
		int userInput = 0;
		do {	
			String newInput = input.next();
				try {	// check if input is an integer
					userInput = Integer.parseInt(newInput);
					validInput = true;
					if (userInput < 1 || userInput > 4) {	// check if input is a menu option
						System.out.println("error: Please enter one of the menu options!");
						validInput = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("error: Please enter one of the menu options!");
					validInput = false;
				}
		} while (validInput == false);
		validInput = false; //reset value
		
		System.out.println("");
		
		if(userInput == 1) pound(other);
		if(userInput == 2) quickAttack(other);
		if(userInput == 3) leafage(other);
		if(userInput == 4) megaDrain(other);
	}

	@Override
	public void speak() {
		
		System.out.println("\"Tree! Tree!\"");
		
	}

}