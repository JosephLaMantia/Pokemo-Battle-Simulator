public class PokemonRunner {

	//Joseph LaMantia
	// CSC 330
	// Lab 3 Pokemon
	// PokemonRunner.java
	public static void main(String[] args) {
		
		//create players
		HumanPlayer player = new HumanPlayer();
		ComputerPlayer npc = new ComputerPlayer();
		
		//welcome
		System.out.println("Hi! Welcome to the Pokemon battle simulator. Make sure to use your number keys to control the action!\n");
		System.out.println("You have been equipped with one Power Potion.\nYour new pokemon, " + player.getPokemon().getPokemonName() + " would like to say hello!");
		player.getPokemon().speak();
		System.out.println("");
		System.out.println("You will be battling your opponents pokemon, " + npc.getPokemon().getPokemonName() + "!");
		npc.getPokemon().speak();
		System.out.println("\n Let the battle begin! \n ... \n");
		
		player.getPokemon().status(npc.getPokemon());;
		System.out.println("You go first!\n");
		
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