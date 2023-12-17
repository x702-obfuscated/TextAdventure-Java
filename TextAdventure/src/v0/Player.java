//////////////////////////
/** Package Declaration */
//////////////////////////
package v0;

//////////////
/** Imports */
//////////////
import static v0.Helper.*;

/////////////////////////////////////////////////////
/** Class Definition (a blueprint for objects)
 * defines the data and methods stored by an object*/
/////////////////////////////////////////////////////
public class Player {

	/////////////////////////
	/** Instance Variables */
	/////////////////////////
	private String name;
	private int health;
	private boolean isAlive;
	private int damage;
	private int defense;

	//////////////////////////////////////////////////////////
	/** Constructors (special methods for building objects) */
	//////////////////////////////////////////////////////////

	/** Zero parameter constructor */
	public Player() {
		name = "Joe";
		health = 100;
		damage = 10;
		defense = 5;
		isAlive = true;
	}

	/** Overloaded parameterized constructor */
	public Player(String name) {
		this.name = name;
		health = 100;
		damage = 10;
		defense = 5;
		isAlive = true;
	}

	/** Overloaded parameterized constructor */
	public Player(String name, int health, int damage, int defense) {
		this.name = name;
		this.health = health;
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
		return;
	}

	/** this player attempts to flea*/
	public boolean run() {
		return Math.random() > 0.6;
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
		this.health = health;
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
