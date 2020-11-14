/**
 * A Pokemon battle simulator.
 * Currently text based, with a menu system controlled by number keys.
 * Only one player pokemon available currently: Treecko.
 * Only one npc pokemon available currently: Mudkip.
 * Items currently available: Power Potion and Mana Potion.
 * Attack lists for Pokemon are selected from their early-learned attacks in the pokemon games,
 * specifically choosing attacks of different types.
 * Using type-based modifiers for attacks and their items, the player (user) battles their npc opponent until one of them faints or runs away.
 * Npc actions are randomly generated, more likely to attack than use their item or run away from battle.
 * 
 * Originally created for a lab assignment in College of Staten Island course:
 * CSC-330: Object-oriented Programming
 * but I have decided to expand upon the assignment and turn it into a personal side project.
 *   
 * @author Joseph LaMantia
 *
 */


public class PokemonRunner {
	public static void main(String[] args) {
		
		//create players
		HumanPlayer player = new HumanPlayer();
		ComputerPlayer npc = new ComputerPlayer();
		
		welcome(player, npc);	// Welcome message, introducing the user, announcing their pokemon, item, and their npc opponent.
		
		System.out.println("You go first!\n");	// Battle begins with Players turn
		
		battle(player, npc);	
	}
	
	/**
	 * Introduces user to the program, explaining the controls and battle details.
	 * Welcomes the user.
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
	 * Uses the Player.act method in a turn-based order, beginning with the player, and checking whether or not the game has ended with each turn.
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

