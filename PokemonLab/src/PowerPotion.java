//Joseph LaMantia
// CSC 330
// Lab 3 Pokemon
// PowerPotion.java
public class PowerPotion implements Item {
	
	private int addedPP;
	private String itemName;
	private boolean itemUsed;
	
	/**
	 * Constructor that:
	 * sets addedPP = 15
	 * sets itemName = "Power Potion"
	 * sets itemUsed = false
	 */
	public PowerPotion() {
		addedPP = 15;
		itemName = "Power Potion";
		itemUsed = false;
	}
	
	/**
	 * Returns name of Item
	 * @return private String itemName
	 */
	public String getItemName() {
		return itemName;
	}

	@Override
	public void use(Pokemon p) {
		int maxPP = p.getMaxPowerPoints();
		int newPP = p.getPowerPoints() + addedPP;
		p.setPowerPoints(newPP);
		if (newPP > maxPP) {
			p.setPowerPoints(maxPP);
		}
		itemUsed = true;
		
		System.out.println(p.getPokemonName() + " used a Power Potion!");
		System.out.println(p.getPokemonName() + " now has " + p.getPowerPoints() + " PP.");
	}

	@Override
	public boolean itemUsed() {
		return itemUsed;
	}
	
}
