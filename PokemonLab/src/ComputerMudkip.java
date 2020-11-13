//Joseph LaMantia
// CSC 330
// Lab 3 Pokemon
// ComputerMudkip.java
import java.util.Random;
public class ComputerMudkip extends Pokemon {
	private Random rand = new Random();

	/**
	 * Constructor that:
	 * calls super to name pokemon
	 * sets hit points and max hit points = 50
	 * sets power points and max power points = 20
	 * sets pokemons attacks
	 * sets pokemons type
	 * @param pokemonName String that names this Pokemon
	 */
	public ComputerMudkip(String pokemonName) {
		super(pokemonName);
		setHitPoints(50);
		setMaxHitPoints(50);
		setPowerPoints(20);
		setMaxPowerPoints(20);
		setAttacks("Tackle", "Water Gun", "Hydro Pump", "Take Down");
		setPokemonType("Water");
	}
	
	/**
	 * Normal type attack with base damage = 15
	 * Power point requirement = 5
	 * Prints effects
	 * @param other Pokemon instance variable
	 */
	public void takeDown(Pokemon other) {	// normal-type attack (no modifiers)
		int damage = 15;
		int powerNeeded = 5;
		
		if(getPowerPoints() >= powerNeeded)	{	// check if pokemon has enough powerPoints
			System.out.println(getPokemonName() + " used Take Down!");
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
	public void tackle(Pokemon other) {	// normal-type attack (no modifiers)
		int damage = 8;
		int powerNeeded = 0;
		
		if(getPowerPoints() >= powerNeeded)	{	// check if pokemon has enough powerPoints
			System.out.println(getPokemonName() + " used Tackle!");
			other.setHitPoints(other.getHitPoints() - damage);
			System.out.println(other.getPokemonName() + " took " + damage + " damage!");
			status(other);
		}
		else System.out.println("Not enough PP!");
	}
	
	/**
	 * Water type attack with base damage = 10
	 * Power point requirement = 0
	 * uses waterModifier to determine attacks effectiveness
	 * Prints effects
	 * @param other Pokemon instance variable
	 */
	public void waterGun(Pokemon other) {	// water-type attack
		int damage = 10;
		int powerNeeded = 0;
		
		if(getPowerPoints() >= powerNeeded)	{	// check if pokemon has enough powerPoints
			System.out.println(getPokemonName() + " used Water Gun!");
			damage = waterModifier(damage, other);	// run water type modifier
			other.setHitPoints(other.getHitPoints() - damage);
			System.out.println(other.getPokemonName() + " took " + damage + " damage!");
			status(other);
		}
		else System.out.println("Not enough PP!");
	}
	
	/**
	 * Water type attack with base damage = 20
	 * Power point requirement = 15
	 * uses waterModifier to determine attacks effectiveness
	 * Prints effects
	 * @param other Pokemon instance variable
	 */
	public void hydroPump(Pokemon other) {	// water-type attack
		int damage = 20;
		int powerNeeded = 15;

		if(getPowerPoints() >= powerNeeded)	{	// check if pokemon has enough powerPoints
			System.out.println(getPokemonName() + " used Hydro Pump!");
			damage = waterModifier(damage, other);	// run water type modifier
			setPowerPoints(getPowerPoints() - powerNeeded);
			other.setHitPoints(other.getHitPoints() - damage);
			System.out.println(other.getPokemonName() + " took " + damage + " damage!");
			status(other);
		}
		else System.out.println("Not enough PP!\n");
	}

	
	/**
	 * Returns Int that represents damage after water type modifiers have been applied.
	 * Super effective vs. Fire, ground, rock
	 * Not very effective vs. Grass, Ice, Flying
	 * No effect vs. N/A
	 * @param dmg Int representing attacks damage
	 * @param other Pokemon instance variable
	 * @return dmg Int after modifiers applied
	 */
	public int waterModifier(int dmg, Pokemon other) {	// calculates damage based on opponents type
		if(other.getPokemonType() == "Fire" 
				|| other.getPokemonType() == "Ground" 
				|| other.getPokemonType() == "Rock" ) {
			dmg = dmg * 2;
			System.out.println("Super effective!\n");
		}
		if(other.getPokemonType() == "Grass" 
				|| other.getPokemonType() == "Ice" 
				|| other.getPokemonType() == "Flying" ) {
			dmg = dmg / 2;
			System.out.println("Not very effective!");
		}
		
		return dmg;
	}


	@Override
	public void attack(Pokemon other) {
		if(getPowerPoints() >= 15) {
			int randomNumber = rand.nextInt(4);
			if (randomNumber == 0) {
				tackle(other);
			}
			if (randomNumber == 1) {
				takeDown(other);
			}
			if (randomNumber == 2) {
				waterGun(other);
			}
			if (randomNumber == 3) {
				hydroPump(other);
			}
			return;
		}
		if (getPowerPoints() < 15 && getPowerPoints() >= 5) {
			int randomNumber = rand.nextInt(3);
			if (randomNumber == 0) {
				tackle(other);
			}
			if (randomNumber == 1) {
				takeDown(other);
			}
			if (randomNumber == 2) {
				waterGun(other);
			}
			return;
		}
		if (getPowerPoints() < 5) {
			int randomNumber = rand.nextInt(2);
			if (randomNumber == 0) {
				tackle(other);
			}
			if (randomNumber == 1) {
				waterGun(other);
			}
			return;
		}
	}

	@Override
	public void speak() {
		System.out.println("\"Mudkip-kip!\"");

	}

}
