//////////////////////////
/** Package Declaration */
//////////////////////////
package v1;

//////////////
/** Imports */
//////////////
import static v1.Helper.*;
import java.util.ArrayList;

/////////////////////////////////////////////////////
/** Class Definition (a blueprint for objects)
 * defines the data and methods stored by an object*/
/////////////////////////////////////////////////////
public class Player {
	
	private static final int healthCap = 1000;

	/////////////////////////
	/** Instance Variables */
	/////////////////////////
	private String name;
	private int maxHealth;
	private int health;
	private boolean isAlive;
	private int damage;
	private int defense;
	private ArrayList<Item> bag = new ArrayList<>();
	

	//////////////////////////////////////////////////////////
	/** Constructors (special methods for building objects) */
	//////////////////////////////////////////////////////////

	/** Zero parameter constructor */
	public Player() {
		name = "Joe";
		maxHealth = 100;
		health = maxHealth;
		damage = 10;
		defense = 5;
		isAlive = true;
	}

	/** Overloaded parameterized constructor */
	public Player(String name) {
		this.name = name;
		maxHealth = 100;
		health = maxHealth;
		damage = 10;
		defense = 5;
		isAlive = true;
	}

	/** Overloaded parameterized constructor */
	public Player(String name, int health, int damage, int defense) {
		this.name = name;
		this.maxHealth = health;
		this.health = this.maxHealth;
		this.damage = damage;
		this.defense = defense;
		this.isAlive = true;
	}

	//////////////////////////////////////////
	/** Player Methods (what a player does) */
	//////////////////////////////////////////

	/** this player does damage to an Enemy */
	public void fight(Enemy enemy) {
		enemy.takesDamage(this.damage);
	}

	/** this player attempts to flea*/
	public boolean run() {
		return Math.random() > 0.6;
	}
	
	/** opens the bag and displays contents */
	public void openBag() {
		if(bag.size() > 0) {
			typeln("Your throw your bag open to reveal its elements...");
			for(int i = 0; i < bag.size(); i++){
				typeln(i +") "+ bag.get(i));
			}
			typeln("Select an item.\n e) exit");
			String choice = input();
			if(choice.equals("e")) {
				return;
			}
			else {
				try {
					bag.get(Integer.valueOf(choice)).menu(this);
					this.openBag();
				}
				catch (Exception e) {
					typeln("That is not an item in your bag");
					this.openBag();
				}
			}
		}
		else {
			typeln("Your bag is empty.\n");
		}
	}

	/** this player takes damage */
	public void takesDamage(int damage) {
		typeln(this.name + " recieves " + damage + " point(s) of damage!");

		this.health -= damage;

		if (this.health <= 0) {
			typeln(this.name + " is defeated!");
			this.isAlive = false;
		}
	}
	
	/** adds item to bag if the bag is not full */
	public void addItem(Item item) {
		if(bag.size() < 11) {
			bag.add(item);
		}
		else {
			typeln("The bag is full.");
		}
	}
	
	

	///////////////////////////////////////////////////////////////////////////////
	/**Overridden Methods (inherited methods defined in a new way for this class)*/
	///////////////////////////////////////////////////////////////////////////////

	/** Overridden toString() method inherited from java.lang.Object class */
	public String toString() {
		return this.name;
	}

	/////////////////////////////////////////////////////////////////////////
	/** Accessor Methods (Getters) 
	 * Allow access outside of the class, and controls how data is returned*/
	/////////////////////////////////////////////////////////////////////////
	
	public static int getHealthCap() {
		return healthCap;
	}
	
	public int getMaxHealth() {
		return this.maxHealth;
	}
	public int getHealth() {
		return this.health;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getDefense() {
		return this.defense;
	}

	public boolean getIsAlive() {
		return this.isAlive;
	}

	/////////////////////////////////////////////////////////////////////////
	/** Mutator Methods (Setters) 
	 * Allow access outside of the class, and controls how data is changed.*/
	/////////////////////////////////////////////////////////////////////////

	public void setName(String name) {
		String result = "";
		for (char c : name.toCharArray()) {
			if (!Character.isDigit(c) && c != ' ') { // ' ' == 32
				result += c;
			}
		}
		this.name = result;
	}

	public void setHealth(int health) {
		if(health > this.maxHealth) {
			this.health = this.maxHealth;
		}
		else {
			this.health = health;
		}
		
	}
	
	public void setMaxHealth(int newMax) {
		if(newMax > healthCap) {
			typeln("You have reached the health cap");
			this.maxHealth = healthCap;
		}
		else {
			this.maxHealth = newMax;
		}
		
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}
//////////////////////////////
/** End of Class Definition */
//////////////////////////////
