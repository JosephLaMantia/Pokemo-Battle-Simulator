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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*while (battleEnd == false) {
			userInput = 0;
			if (battleEnd == false) {
				//Player turn
				while (userInput != 1) {
					System.out.println("What will " + treecko.getPokemonName() + " do?");
					System.out.println("1. Attack\n2. Use Item");
					userInput = input.nextInt();
					if (userInput == 1) treecko.attack(mudkip);
					if (userInput == 2) {
						System.out.println("Are you sure you want to use your Elixir?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						userInput = input.nextInt();
						if (userInput == 1) player.use(treecko);
						if (userInput == 2) System.out.println("What will " + treecko.getPokemonName() + " do?");
						if (treecko.getHitPoints() == 0) battleEnd = true;
						if (mudkip.getHitPoints() == 0) battleEnd = true;
					} 
				}
				if (battleEnd == false) {
					//Computer turn
					if (npcUsedItem = false) {
						randomNumber = rand.nextInt(1);
						if (randomNumber == 0)
							mudkip.attack(treecko);
						if (randomNumber == 1) {
							npc.use(mudkip);
							npcUsedItem = true;
						}
					} else	mudkip.attack(treecko);
				}
				if (treecko.getHitPoints() == 0) battleEnd = true;
				if (mudkip.getHitPoints() == 0) battleEnd = true;
			}
			if (treecko.getHitPoints() == 0) player.run();
			if (mudkip.getHitPoints() == 0) npc.run();
		}*/
		

			
		
		
	}
}


// create item class that implements item