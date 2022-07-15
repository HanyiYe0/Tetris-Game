import java.util.Scanner;
import java.util.Random;

public class Game {
	/*	
	 * How the game will work:
	 * 1. Display a clear screen ✔
	 * 2. Generate a random block and put it on the top of the screen. ✔
	 * 3. Constantly move it down until it hits something (the bottom of the screen / another block) ✔
	 * 4. Constantly check for user inputs for moving and rotating the block left and right. ✔
	 * 5. Check if a row can be cleared.
	 * 6. If it can clear it and move everything above down.
	 * 6. Repeat until a block cannot spawn anymore.
	 *
	 */
	
	/*
	 * Block id's: 1 = t-block, 2 = z-block, 3 = s-block, 4 = o-block, 5 = l-block, 6 = j-block, 7 = i-block.
	 * 
	 */
	
	static String[][] screen = {
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"|", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "|"},
			 {"-", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--", "-"},
			};
	
	private static int centreX = 0;
	private static int centreY = 5;
	private static int id = 4;
	private static String requirement = "|::::::::::::::::::::|";

	
	static void checkAndClear() {
		String read = "";
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[i].length; j++) {
				read = read + screen[i][j];
			}
			if (read.equals(requirement)) {
				for (int j = 1; j < 11; j++) {
					screen[i][j] = "  ";
				}
				/*
				 * for (int j = i; j > 0; j--) {
					
				}
				 */
				
			}
			read = "";
		}
		
	}
	
	static boolean checkDown(String[][] screen, int id) {
		boolean value = true;
		if (id == 1) {
			if (screen[centreX + 1][centreY - 1] != "  " || 
				screen[centreX + 1][centreY] != "  " || 
				screen[centreX + 1][centreY + 1] != "  ") {
				value = false;
			}
		}
		if (id == 2) {
			if (screen[centreX][centreY - 1] != "  " ||
				screen[centreX + 1][centreY] != "  " ||
				screen[centreX + 1][centreY + 1] != "  ") {
				value = false;
			}
		}
		if (id == 3) {
			if (screen[centreX][centreY + 1] != "  " ||
				screen[centreX + 1][centreY] != "  " ||
				screen[centreX + 1][centreY - 1] != "  ") {
				value = false;
			}
		}
		if (id == 4) {
			if (screen[centreX + 1][centreY] != "  " ||
				screen[centreX + 1][centreY + 1] != "  ") {
				value = false;
			}
		}
		if (id == 5) {
			if (screen[centreX + 2][centreY] != "  " ||
				screen[centreX + 2][centreY + 1] != "  ") {
				value = false;
			}
		}
		if (id == 6) {
			if (screen[centreX + 2][centreY] != "  " ||
				screen[centreX + 2][centreY - 1] != "  ") {
				value = false;
			}
		}
		if (id == 7) {
			if (screen[centreX + 3][centreY] != "  ") {
				value = false;
			}
		}
		return value;
	}
	
	static void resetXY() {
		centreX = 0;
		centreY = 5;
	}
	
	static void updateScreen() {
		centreX--;
		screen = spawnBlock(screen, id);
	}
	
	static String display(String[][] block) {
		String read = "";
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length; j++) {
				read = read + block[i][j];
			}
			read = read + "\n";
		}
		return read;
	}
	
	static boolean checkLeft(String[][] screen, int id) {
		boolean value = false;
		if (id == 1) {
			if (screen[centreX][centreY - 1] == "  " && 
				screen[centreX + 1][centreY - 2] == "  ") {
				value = true;
			}
		}
		if (id == 2) {
			if (screen[centreX][centreY - 2] == "  " &&
				screen[centreX + 1][centreY - 1] == "  ") {
				value = true;
			}
		}
		if (id == 3) {
			if (screen[centreX][centreY - 1] == "  " &&
				screen[centreX + 1][centreY - 2] == "  ") {
				value = true;
			}
		}
		if (id == 4) {
			if (screen[centreX][centreY - 1] == "  " &&
				screen[centreX + 1][centreY - 1] == "  ") {
				value = true;
			}
		}
		if (id == 5) {
			if (screen[centreX][centreY - 1] == "  " &&
				screen[centreX + 1][centreY - 1] == "  " &&
				screen[centreX + 2][centreY - 1] == "  ") {
				value = true;
			}
		}
		if (id == 6) {
			if (screen[centreX][centreY - 1] == "  " &&
				screen[centreX + 1][centreY - 1] == "  " &&
				screen[centreX + 2][centreY - 2] == "  ") {
				value = true;
			}
		}
		if (id == 7) {
			if (screen[centreX][centreY - 1] == "  " &&
				screen[centreX + 1][centreY - 1] == "  " &&
				screen[centreX + 2][centreY - 1] == "  " &&
				screen[centreX + 3][centreY - 1] == "  ") {
				value = true;
			}
		}
		return value;
	}
	
	static boolean checkRight(String[][] screen, int id) {
		boolean value = false;
		if (id == 1) {
			if (screen[centreX][centreY + 1] == "  " && 
				screen[centreX + 1][centreY + 2] == "  ") {
				value = true;
			}
		}
		if (id == 2) {
			if (screen[centreX][centreY + 1] == "  " &&
				screen[centreX + 1][centreY + 2] == "  ") {
				value = true;
			}
		}
		if (id == 3) {
			if (screen[centreX][centreY + 2] == "  " &&
				screen[centreX + 1][centreY + 1] == "  ") {
				value = true;
			}
		}
		if (id == 4) {
			if (screen[centreX][centreY + 2] == "  " &&
				screen[centreX + 1][centreY + 2] == "  ") {
				value = true;
			}
		}
		if (id == 5) {
			if (screen[centreX][centreY + 1] == "  " &&
				screen[centreX + 1][centreY + 1] == "  " &&
				screen[centreX + 2][centreY + 2] == "  ") {
				value = true;
			}
		}
		if (id == 6) {
			if (screen[centreX][centreY + 1] == "  " &&
				screen[centreX + 1][centreY + 1] == "  " &&
				screen[centreX + 2][centreY + 1] == "  ") {
				value = true;
			}
		}
		if (id == 7) {
			if (screen[centreX][centreY + 1] == "  " &&
				screen[centreX + 1][centreY + 1] == "  " &&
				screen[centreX + 2][centreY + 1] == "  " &&
				screen[centreX + 3][centreY + 1] == "  ") {
				value = true;
			}
		}
		return value;
	}

	static void removeTrail(String[][] screen, int id) {
		centreX--;
		if (id == 1) {
			screen[centreX][centreY] = "  ";
			screen[centreX + 1][centreY - 1] = "  ";
			screen[centreX + 1][centreY] = "  ";
			screen[centreX + 1][centreY + 1] = "  ";
		}		
		if (id == 2) {
				screen[centreX][centreY] = "  ";
				screen[centreX][centreY - 1] = "  ";
				screen[centreX + 1][centreY] = "  ";
				screen[centreX + 1][centreY + 1] = "  ";
		}
		if (id == 3) {
			screen[centreX][centreY + 1] = "  ";
			screen[centreX][centreY] = "  ";
			screen[centreX + 1][centreY] = "  ";
			screen[centreX + 1][centreY - 1] = "  ";
		}
		if (id == 4) {				
			screen[centreX][centreY + 1] = "  ";
			screen[centreX][centreY] = "  ";
			screen[centreX + 1][centreY] = "  ";
			screen[centreX + 1][centreY + 1] = "  ";
		}
		if (id == 5) {
				screen[centreX][centreY] = "  ";
				screen[centreX + 1][centreY] = "  ";
				screen[centreX + 2][centreY] = "  ";
				screen[centreX + 2][centreY + 1] = "  ";
		}
		if (id == 6) {
				screen[centreX][centreY] = "  ";
				screen[centreX + 1][centreY] = "  ";
				screen[centreX + 2][centreY] = "  ";
				screen[centreX + 2][centreY - 1] = "  ";
		}
		if (id == 7) {		
				screen[centreX][centreY] = "  ";
				screen[centreX + 1][centreY] = "  ";
				screen[centreX + 2][centreY] = "  ";
				screen[centreX + 3][centreY] = "  ";
		}
		centreX++;
	}
	
	static String[][] spawnBlock(String[][] screen, int id) {
		if (id == 1) {
			if (screen[centreX + 1][centreY] == "  ") {
				
				screen[centreX][centreY] = "::";
				screen[centreX + 1][centreY - 1] = "::";
				screen[centreX + 1][centreY] = "::";
				screen[centreX + 1][centreY + 1] = "::";
				
				}
			}
		if (id == 2) {
			if (screen[centreX + 1][centreY] == "  ") {
				
				screen[centreX][centreY] = "::";
				screen[centreX][centreY - 1] = "::";
				screen[centreX + 1][centreY] = "::";
				screen[centreX + 1][centreY + 1] = "::";
				
			}
		}
		if (id == 3) {
			if (screen[centreX + 1][centreY] == "  ") {
				
				screen[centreX][centreY] = "::";
				screen[centreX][centreY + 1] = "::";
				screen[centreX + 1][centreY] = "::";
				screen[centreX + 1][centreY - 1] = "::";
				
			}
		}
		if (id == 4) {
			if (screen[centreX + 1][centreY] == "  ") {
				
				screen[centreX][centreY + 1] = "::";
				screen[centreX][centreY] = "::";
				screen[centreX + 1][centreY] = "::";
				screen[centreX + 1][centreY + 1] = "::";
				
			}
		}
		if (id == 5) {
			if (screen[centreX + 2][centreY] == "  ") {
				
				screen[centreX][centreY] = "::";
				screen[centreX + 1][centreY] = "::";
				screen[centreX + 2][centreY] = "::";
				screen[centreX + 2][centreY + 1] = "::";
				
			}
		}
		if (id == 6) {
			if (screen[centreX + 2][centreY] == "  ") {
				
				screen[centreX][centreY] = "::";
				screen[centreX + 1][centreY] = "::";
				screen[centreX + 2][centreY] = "::";
				screen[centreX + 2][centreY - 1] = "::";
				
			}
		}
		if (id == 7) {
			if (screen[centreX + 3][centreY] == "  ") {
				
				screen[centreX][centreY] = "::";
				screen[centreX + 1][centreY] = "::";
				screen[centreX + 2][centreY] = "::";
				screen[centreX + 3][centreY] = "::";
				
			}
		}
		centreX++;
		return screen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		for (int j = 0; j < 6; j++) {
			//Displays the screen with the spawned block
			System.out.println(display(spawnBlock(screen, id)));	
			removeTrail(screen, id);
			//Continues to drop the block and look for user inputs until the block
			//reaches the bottom.
			while(checkDown(screen, id)) {
				String input = scanner.nextLine();
				if (input.equals("d") && checkRight(screen, id)) {
					removeTrail(screen, id);
					centreY++;
				}
				if (input.equals("a") && checkLeft(screen, id)) {
					removeTrail(screen, id);
					centreY--;
				}
				System.out.println(display(spawnBlock(screen, id)));	
				removeTrail(screen, id);
				//Updating the screen for the next block when the block touches the 
				//bottom.
				if (checkDown(screen, id) == false) {
					updateScreen();
				}
			}
			checkAndClear();
			System.out.println(display(screen));

			resetXY();
		}
	}
}
