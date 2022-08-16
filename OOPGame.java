import java.util.Random;
import java.util.Scanner;


public class OOPGame {
	
	/*
	 * How the game will work:
	 * 1. Display a clear screen
	 * 2. Generate a random block and put it on the top of the screen.
	 * 3. Constantly move it down until it hits something (the bottom of the screen / another block)
	 * 4. Constantly check for user inputs for moving and rotating the block left and right.
	 * 5. Repeat until a block cannot spawn anymore.
	 * 
	 */
	
	

	public static void main(String[] args) {
						
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		
		I_Block iBlock = new I_Block(Blocks.orientation);
		L_Block lBlock = new L_Block(Blocks.orientation);
		J_Block jBlock = new J_Block(Blocks.orientation);
		O_Block oBlock = new O_Block(Blocks.orientation);
		S_Block sBlock = new S_Block(Blocks.orientation);
		Z_Block zBlock = new Z_Block(Blocks.orientation);
		T_Block tBlock = new T_Block(Blocks.orientation);
		

		Blocks[] blocks = {iBlock, lBlock, jBlock, oBlock, sBlock, zBlock, tBlock};
		//Blocks block = blocks[rand.nextInt(blocks.length)];
		Blocks 	block = blocks[rand.nextInt(blocks.length)];
		String input;
		
		while (Screen.gameOver == false) {
			block = blocks[rand.nextInt(blocks.length)];
			block.spawnBlock(Screen.screen, "::");
			Screen.displayScreen();

			while (block.moveable("Down")) {
				block.move("Down");
				input = scanner.nextLine();
				if (input.equals("a") && block.moveable("Left")) {
					block.move("Left");
				}
				
				if (input.equals("d") && block.moveable("Right")) {
					block.move("Right");
				}
				System.out.println(block.orientation);
				if (input.equals("x") && block.rotatable("Right")) {
					block.rotateCounterClockwise();
					block.removeTrail();
					block.spawnBlock(Screen.screen, "  ");

				}
				
				if (input.equals("c") && block.rotatable("Left")) {
					block.rotateClockwise();
				}
				
				Screen.displayScreen();
				input = "";
			}
			block.resetXY();
			Screen.clearAndDrop();
			Screen.checkGameOver();
		}
		scanner.close();
		
	}
}
