//////////////////////////
/** Package Declaration */
//////////////////////////
package v0;

//////////////
/** Imports */
//////////////
import static v0.Helper.*;
import java.util.ArrayList;

///////////////////////
/** Class Definition */
///////////////////////
public class Main {
	
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

		gameLoop(player1);
		
		typeln("RESTART? (y/n) ");
		if(input().equals("y")) {
			main(null);
		}
		
	}
	////////////////////////////
	/** Game Specific Methods */
	////////////////////////////
	
	/** Defines the main game loop and functionality 
	 * Outer while loop controls the continuation of the game.
	 * Inner while loop controls the enemy encounter */
	public static void gameLoop(Player player) {
		
		while (player.getIsAlive()) {
			ArrayList<Enemy> enemyList = createEnemyList();
			Enemy enemy = selectRandomEnemy(enemyList);
			enemy.appears();

			while (enemy.getIsAlive() && player.getIsAlive()) {
				System.out.println("===================================================");
				System.out.println("|Current Stats | " + player + " hp: " + player.getHealth() + " | " + enemy + " hp: "
						+ enemy.getHealth() + " |");
				System.out.println("===================================================");
				
				typeln("What would you like to do?\n 1) run  2) fight q) quit");
				String choice = input();

				if (choice.equals("1")) {
					if (player.run()) {
						typeln("You got away this time...\n");
						break;
					} 
					else {
						typeln("Your path is blocked by the " + enemy + "\n");
					}
				} 
				else if (choice.equals("2")) {
					player.fight(enemy);
					if (!enemy.getIsAlive()) {
						break;
					}
				}
				else if (choice.equals("q")) {
					quit();
				}
				else {
					typeln("You can't do that right now!\n");
				
				}

				enemy.attack(player);

				if (!player.getIsAlive()) {
					gameOver();
					break;
				}
			}

		}
	}
	
	/** populates an list full of enemies to fight */
	public static ArrayList<Enemy> createEnemyList() {
		Enemy slime = new Enemy();
		Enemy slimeDuo = new Enemy("Slime Duo", 20, 4);
		Enemy slimeTrio = new Enemy("Slime Trio", 30, 6);
		Enemy superSlime = new Enemy("Super Slime", 40, 8);
		Enemy kingSlime = new Enemy("King Slime", 50, 10);

		ArrayList<Enemy> enemyList = new ArrayList<>();
		enemyList.add(slime);
		enemyList.add(slimeDuo);
		enemyList.add(slimeTrio);
		enemyList.add(superSlime);
		enemyList.add(kingSlime);

		return enemyList;
	}
	
	/** randomly selects and enemy to fight from a list */
	public static Enemy selectRandomEnemy(ArrayList<Enemy> enemyList) {
		int randomIndex = (int) (Math.random() * enemyList.size());
		return (enemyList.get(randomIndex));
	}
	
	/** defines what occurs when the game ends */
	public static void gameOver() {
		typeln("GAME OVER");
		return;
	}
	
	/** quits the game */
	public static void quit() {
		typeln("The light fades on the world as the loop finally comes to an end...");
		System.exit(0);
		
	}

}
