//Joseph LaMantia
// CSC 330
// Lab 3 Pokemon
// HealthPotion.java
public class HealthPotion implements Item {

	private int addedHP;
	private String itemName;
	private boolean itemUsed;
	
	/**
	 * Constructor that:
	 * sets int addedHP = 15
	 * sets String itemName = Health Potion
	 * sets boolean itemUsed = false
	 */
	public HealthPotion() {
		addedHP = 15;
		itemName = "Health Potion";
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
		int maxHP = p.getMaxHitPoints();
		int newHP = p.getHitPoints() + addedHP;
		p.setHitPoints(newHP);
		if (newHP > maxHP) {
			p.setHitPoints(maxHP);
		}
		itemUsed = true;
		System.out.println(p.getPokemonName() + " used an Health Potion!");
		System.out.println(p.getPokemonName() + " now has " + p.getHitPoints() + " HP.");
	}

	@Override
	public boolean itemUsed() {
		return itemUsed;
	}
}
