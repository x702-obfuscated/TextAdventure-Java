//////////////////////////
/** Package Declaration */
//////////////////////////
package v1;

//////////////
/** Imports */
//////////////
import static v1.Helper.*;
import java.util.HashMap;


/////////////////////////////////////////////////////
/** Class Definition (a blueprint for objects)
* defines the data and methods stored by an object*/
/////////////////////////////////////////////////////
public class Item {

	
	/////////////////////////////	
	/** Static Class Variables */
	/////////////////////////////
	private static HashMap<String,Item> completeItemMap = new HashMap<>();
	
	/////////////////////////
	/** Instance Variables */
	/////////////////////////
	private String description;
	private String name;
	
	//////////////////////////////////////////////////////////
	/** Constructors (special methods for building objects) */
	//////////////////////////////////////////////////////////
	
	/** Parameterized constructor */
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
		
		completeItemMap.put(name, this);
	}
	
	/** Copy constructor */
	public Item(Item other) {
		this.setName(other.name);
		this.description = other.description;
	}
	///////////////////////////
	/** Static Class Methods */
	///////////////////////////
	
	/** Static method to return the complete map of all items */
	public static HashMap<String, Item> getItemMap(){
		return completeItemMap;
	}
	
	////////////////////////////////////////
	/** Item Methods (what an item does) */
	////////////////////////////////////////
	
	/** Use this item, should be overridden in child classes */
	public void use(Player player) {
		typeln("You realise you are not sure how to use it so you put it back in the bag.");
	}
	
	public void menu(Player player) {
		typeln("What would you like to do?\n1) use\n e) exit");
		String choice = input();
		if(choice.equals("1")) {
			this.use(player);
		}
		else if(choice.equals("e")) {
			return;
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
	/** Mutator Methods (Setters) 
	 * Allow access outside of the class, and controls how data is changed.*/
	/////////////////////////////////////////////////////////////////////////

	public void setName(String name) {
		completeItemMap.remove(this.name);
		this.name = name;
		completeItemMap.put(this.name, this);
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
//////////////////////////////
/** End of Class Definition */
//////////////////////////////
