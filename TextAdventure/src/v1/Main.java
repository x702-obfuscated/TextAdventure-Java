//////////////////////////
/** Package Declaration */
//////////////////////////
package v1;

//////////////
/** Imports */
//////////////
import static v1.Helper.*;
import java.util.HashMap;
import java.util.ArrayList;

///////////////////////
/** Class Definition */
///////////////////////
public class Main {
	
	private static HashMap<String,Item> itemMap = Item.getItemMap();
	private static ArrayList<Enemy> enemyList = Enemy.getEnemyList();
	
	///////////////////////////////////////////////////////////
	/** Main Method (code to run when this file is executed) */
	///////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		typeln("Mr. Merritt Presents...\n    A Java Text Adventure!\n"
				+ "Enter your name brave adventurer!: ");
		
		String playerName = cleanInput(input());
		Player player1 = new Player(playerName); //Declare and initialize player1 of type/class Player

		typeln("\nWelcome " + player1
				+ ", to the land of Programia!\nHere our lives are simple, every day we are attacked by numerous monsters until we die.\n"
				+ "When Progamia runs again we awaken to a new land, and a new cycle of deadly monster foes!\n"
				+ "And Your Adventure Begins!!!\n\n");
		
		createItems();
		createEnemies();
		
		gameLoop(player1);
		
	}
	////////////////////////////
	/** Game Specific Methods */
	////////////////////////////
	
	/** Defines the main game loop and functionality 
	 * Outer while loop controls the continuation of the game.
	 * Inner while loop controls the enemy encounter */
	public static void gameLoop(Player player) {
		
		while (player.getIsAlive()) {
			if(enemyList.size() < 1) {
				gameWon();
				return;
			}
			
			displayMenu(player);
			fightLoop(player);
			
		}
		
	}
	
	/** fight loop */
	public static void fightLoop(Player player) {
		
		Enemy enemy = selectRandomEnemy(enemyList);
		
		enemy.appears();

		while (enemy.getIsAlive() && player.getIsAlive()) {
			
			if (!player.getIsAlive()) {
				gameOver();
				return; 
			}
			
			displayStatus(player, enemy);
			
			typeln("What would you like to do?\n 1) run  2) fight 3) bag q) quit");
			String choice = input();

			if (choice.equals("1")) {
				if (player.run()) {
					typeln("You got away this time...\n");
					return;
				} 
				else {
					typeln("Your path is blocked by the " + enemy + "\n");
				}
			} 
			else if (choice.equals("2")) {
				player.fight(enemy);
				if (!enemy.getIsAlive()) {
					Enemy.getEnemyList().remove(enemy);
					enemy.dropItem(player);
					return;
				}
			}
			else if (choice.equals("3")) {
				player.openBag();
			}
			else if (choice.equals("q")) {
				quit();
			}
			else {
				typeln("You can't do that right now!\n");
			
			}
			
			enemy.attack(player);
		}
	}
	
	/** displays in game menu */
	public static void displayMenu(Player player) {
		typeln("The onslaught of enemies briefly subsides...\n"
				+ "What would you like to do?\n"
				+ "1) open bag\n"
				+ "c) continue\n"
				+ "q) quit");
		String choice = input();
		if(choice.equals("1")) {
			player.openBag();
		}
		else if(choice.equals("c")) {
			return;
		}
		else if(choice.equals("q")) {
			System.exit(0);
		}
		else {
			typeln("You can't do that right now");
			displayMenu(player);
		}	
	}
	
	/** displays stats during fight loop */
	public static void displayStatus(Player player, Enemy enemy) {
		String status = "|Current Stats | " + player + " hp: " + player.getHealth() + " | " + enemy + " hp: " + enemy.getHealth() + " |";
		String border = "";
		for(int i = 0; i < status.length(); i++) {
			border += "-";
		}
		typeln(border + "\n" + status + "\n" + border);	
	}
	
	/** populates an list full of enemies to fight */
	public static void createEnemies() {
		new Enemy();
		new Enemy("Slime Duo", 20, 4,itemMap.get("potion"));
		new Enemy("Slime Trio", 30, 6,itemMap.get("potion"));
		new Enemy("Super Slime", 40, 8, itemMap.get("super potion"));
		new Enemy("King Slime", 50, 10, itemMap.get("max potion"));
	}
	
	/** generates the complete list of items */
	public static void createItems() {
		new Item("test", "just a test");
		new Potion();
		new Potion(30,50,"strong potion", "This potion restores health for 30-50 points.");
		new Potion(-1,-1,"max potion", "This potion completely restores health.");
	}
	
	/** randomly selects and enemy to fight from a list */
	public static Enemy selectRandomEnemy(ArrayList<Enemy> enemyList) {
		int randomIndex = (int) (Math.random() * enemyList.size());
		return (enemyList.get(randomIndex));
	}
	
	/** defines what occurs when the game ends */
	public static void gameOver() {
		typeln("GAME OVER");
		restart();
	}
	
	/** defines what occurs when the game is won */
	public static void gameWon() {
		typeln("YOU WIN");
		restart();
	}
	
	/** prompts the user to restart the game */
	public static void restart() {
		typeln("RESTART? (y/n) ");
		if(input().equals("y")) {
			main(null);
		}
		else {
			quit();
		}
	}
	
	/** quits the game */
	public static void quit() {
		System.exit(0);
		
	}

}
