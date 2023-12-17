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
public class Enemy {

	/////////////////////////
	/** Instance Variables */
	/////////////////////////
	private String name;
	private int health;
	private int damage;
	private boolean isAlive;

	//////////////////////////////////////////////////////////
	/** Constructors (special methods for building objects) */
	//////////////////////////////////////////////////////////
	
	/** Zero parameter constructor */
	public Enemy() {
		name = "slime";
		health = 10;
		damage = 2;
		isAlive = true;
	}

	/** Overloaded parameterized constructor */
	public Enemy(String name, int health, int damage) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.isAlive = true;
	}
	
	//////////////////////////////////////////
	/** Enemy Methods (what an enemy does) */
	//////////////////////////////////////////
	
	/** Prints out that the enemy has appeared*/
	public void appears() {
		typeln("Oh No! A " + this.name + " suddenly appears!");
	}
	
	/** this enemy does damage to a Player*/
	public void attack(Player player) {
		typeln("The " + this.name + " attacks" + " and does " + this.damage + " point(s) of damage.");
		player.takesDamage(this.damage);
	}
	
	/** this enemy takes damage */
	public void takesDamage(int damage) {
		typeln("The " + this.name + " recieves " + damage + " point(s) of damage!");

		this.health -= damage;

		if (this.health <= 0) {
			typeln("The " + this.name + " is defeated!");
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

	public boolean getIsAlive() {
		return isAlive;
	}

	/////////////////////////////////////////////////////////////////////////
	/** Mutator Methods (Setters) 
	 * Allow access outside of the class, and controls how data is changed.*/
	/////////////////////////////////////////////////////////////////////////
	
	public void setHealth(int health) {
		this.health = health;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
}
//////////////////////////////
/** End of Class Definition */
//////////////////////////////
