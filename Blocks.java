
/*
 * What will be in blocks class:
 * Variables: 
 * the block type
 * number of orientations
 * the looks in terms of a center x and center y
 * 
 * Functions:
 * move down, left, and right function
 * a function that checks if the block can perform that move.
 * rotate function
 * a function that checks if the block can be rotated.
 * 
 */
public abstract class Blocks {
	int y = 0;
	int x = 5;
	BlockType blockType;
	static Orientation orientation = Orientation.Down;	
	
	public void resetXY() {
		setX(5);
		setY(0);
	}
	
	public BlockType getBlockType() {
		return blockType;
	}

	public void setBlockType(BlockType blockType) {
		this.blockType = blockType;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public abstract void spawnBlock(String[][] screen, String fill);
	
	public void removeTrail() {
		spawnBlock(Screen.screen, "  ");
	}
	
	public void move(String direction) {
		switch (direction) {
			case "Down":
				removeTrail();
				y++;
				break;
				
			case "Left":
				removeTrail();
				x--;
				break;
				
			case "Right":
				removeTrail();
				x++;
				break;
		}
		spawnBlock(Screen.screen, "::");
	}
	
	public abstract boolean moveable(String direction); 
		
	public abstract void rotateClockwise();
	
	public abstract void rotateCounterClockwise();
	
	public abstract boolean rotatable(String rotateDirection);

}
