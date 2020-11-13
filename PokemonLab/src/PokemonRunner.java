public class PokemonRunner {

	//Joseph LaMantia
	// CSC 330
	// Lab 3 Pokemon
	// PokemonRunner.java
	public static void main(String[] args) {
		
		//create players
		HumanPlayer player = new HumanPlayer();
		ComputerPlayer npc = new ComputerPlayer();
		
		welcome(player, npc);	// Welcome message, introducing the user, announcing their pokemon, item, and their npc opponent.
		
		System.out.println("You go first!\n");	// Battle begins with Players turn
		
		battle(player, npc);	
	}
	
	/**
	 * Introduces user to the program, explaining the controls.
	 * Informs player (user) what item and pokemon they have been equipped with.
	 * Uses the players pokemons .speak() method
	 * Informs player what pokemon their npc opponent has been equipped with. (Does not reveal which item.)
	 * Uses the npc pokemons .speak() method
	 * Announces the battle is starting
	 * @param human Player instance variable
	 * @param computer Player instance variable
	 */
	private static void welcome(Player human, Player computer) {
		System.out.println("Hi! Welcome to the Pokemon battle simulator. Make sure to use your number keys to control the action!\n");
		System.out.println("You have been equipped with one Power Potion.\nYour new pokemon, " + human.getPokemon().getPokemonName() + " would like to say hello!");
		human.getPokemon().speak();
		System.out.println("");
		System.out.println("You will be battling your opponents pokemon, " + computer.getPokemon().getPokemonName() + "!");
		computer.getPokemon().speak();
		System.out.println("\n Let the battle begin! \n ... \n");
		
		human.getPokemon().status(computer.getPokemon());
	}
	
	/**
	 * Uses the Player.act method in a turn-based order, checking whether or not the game has ended with each turn.
	 * @param player Player instance variable
	 * @param npc Player instance variable
	 */
	private static void battle(HumanPlayer player, ComputerPlayer npc) {
		while(player.getGameOver() == false && npc.getGameOver() == false) {
			if(player.getGameOver() == false && npc.getGameOver() == false) {
				player.act(npc);
			}
			if(player.getGameOver() == false && npc.getGameOver() == false) {
				npc.act(player);
			}
		}	
	}
}

