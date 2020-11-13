//Joseph LaMantia
// CSC 330
// Lab 3 Pokemon
// HumanPlayer.java
import java.util.Scanner;
public class HumanPlayer extends Player{
	
	private Pokemon pokemon;
	private Item item;
	private boolean gameOver;
	private boolean validInput;
	
	/**
	 * Constructor that:
	 * creates Pokemon
	 * creates Item
	 * sets gameOver boolean value = false
	 * sets validInput boolean value = false
	 */
	public HumanPlayer() {
		pokemon = new PlayerTreecko("Treecko");
		item = new PowerPotion();
		gameOver = false;
		validInput = false;
	}
	
	@Override
	public Pokemon getPokemon() {
		return pokemon;
	}

	@Override
	public void run() {
		System.out.println("You grab your pokemon and run for the hills! Game over!");
		gameOver = true;
	}

	
	@Override
	public void faint() {
		System.out.println("Your " + pokemon.getPokemonName() + " has fainted... \nYou have fled in defeat.");
		gameOver = true;
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
		Scanner input = new Scanner(System.in);
		int userInput = 0;
		
		//menu
		if(item.itemUsed() == false) {	// if item has NOT been used...

			System.out.println("What would you like Treecko to do?");
			System.out.println("1. Attack");
			System.out.println("2. Use Item");
			System.out.println("3. Run");
			
			//user input
			do {	
				String newInput = input.next();
					try {	// check if input is an integer
						userInput = Integer.parseInt(newInput);
						validInput = true;
						if (userInput < 1 || userInput > 3) {	// check if input is a menu option
							System.out.println("error: Please enter one of the menu options!");
							validInput = false;
						}
					} catch (NumberFormatException e) {
						System.out.println("error: Please enter one of the menu options!");
						validInput = false;
					}
			} while (validInput == false);
			validInput = false; //reset value
			
			if(userInput == 1) {
				pokemon.attack(opponent.getPokemon());
			}
			if(userInput == 2) {
				item.use(getPokemon());
				pokemon.status(opponent.getPokemon());
			}
			if(userInput == 3) {
				run();
			}
		}
		else {	// if item HAS been used...
			System.out.println("What would you like Treecko to do?");
			System.out.println("1. Attack");
			System.out.println("2. Run");
			
			//user input
			do {	
				String newInput = input.next();
					try {	// check if input is an integer
						userInput = Integer.parseInt(newInput);
						validInput = true;
						if (userInput < 1 || userInput > 2) {	// check if input is a menu option
							System.out.println("error: Please enter one of the menu options!");
							validInput = false;
						}
					} catch (NumberFormatException e) {
						System.out.println("error: Please enter one of the menu options!");
						validInput = false;
					}
			} while (validInput == false);
			validInput = false; //reset value
			
			if(userInput == 1) {
				pokemon.attack(opponent.getPokemon());
			}
			if(userInput == 2) {
				run();
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
}
