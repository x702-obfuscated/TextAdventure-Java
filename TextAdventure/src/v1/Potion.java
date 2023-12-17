package v1;

import static v1.Helper.*;

public class Potion extends Item {
	private int min;
	private int max;
	public Potion() {
		super("potion", "This potion restores health for 10-30 points.");
		min = 10;
		max = 30;
	}
	
	public Potion(int min, int max, String name, String description) {
		super(name, description);
		this.min = min;
		this.max = max;
	}
	
	
	
	public void use(Player player) {
		int before = player.getHealth();
		player.setHealth(player.getHealth() + randInt(min,max));
		int after = player.getHealth();
		int difference = after - before;
		typeln("The " + this + "restores " + difference + " health.");
	}
	
	
	
	
	
	
}
