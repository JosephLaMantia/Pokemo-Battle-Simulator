//Joseph LaMantia
// CSC 330
// Lab 3 Pokemon
// ComputerPlayer.java
import java.util.Random;
public class ComputerPlayer extends Player{

	private Pokemon pokemon;
	private Item item;
	private boolean gameOver;
	
	/**
	 * Constructor that:
	 * creates Pokemon
	 * creates Item
	 * sets gameOver boolean value = false
	 */
	public ComputerPlayer() {
		pokemon = new ComputerMudkip("Mudkip");
		item = new HealthPotion();
		gameOver = false;
	}
	
	
	@Override
	public Pokemon getPokemon() {
		return pokemon;
	}

	@Override
	public void run() {
		gameOver = true;
		System.out.println("Your opponent runs for the hills! Game over!");
	}
	
	@Override
	public void faint() {
		gameOver = true;
		System.out.println("Your opponents " + pokemon.getPokemonName() + " has fainted... \nThey have fled in defeat.");
	}

	@Override
	public Item getItem() {
		return item;
	}
	
	/**
	 * Returns value for gameOver
	 * @return private boolean gameOver
	 */
	public boolean getGameOver() {
		return gameOver;
	}


	@Override
	public void act(Player opponent) {
		Random rand = new Random();
		int randomNumber;
		randomNumber = rand.nextInt(11);
		// uses attack based on random number generator
		if (item.itemUsed() == true) {	// if item HAS been used...
			if(randomNumber < 10) {
				pokemon.attack(opponent.getPokemon());
			}
			if(randomNumber == 10) {
				run();
			} 
		}
		if (item.itemUsed() == false) {	// if item has NOT been used...
			if (randomNumber < 6) {
				pokemon.attack(opponent.getPokemon());
			}
			if (randomNumber >= 6 && randomNumber < 10) {
				item.use(getPokemon());
				pokemon.status(opponent.getPokemon());
			} 
			if(randomNumber == 10) {
				run();
			} 
		} 

		// check if pokemon has fainted
		if(pokemon.checkForFaint() == true){
			gameOver = true;
			faint();
		}
		if(opponent.getPokemon().checkForFaint() == true) {
			gameOver = true;
			opponent.faint();
		}
	}

}
