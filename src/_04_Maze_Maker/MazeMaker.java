package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start
		int rW = new Random().nextInt(w);
		int rH = new Random().nextInt(h);

		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(maze.cells[rW][rH]);

		
		
		int randoW = new Random().nextInt(w);
		int randoH = new Random().nextInt(h);
				
		boolean tb = new Random().nextBoolean();
		boolean tb2 = new Random().nextBoolean();
		
		if(tb == true) {
			maze.getCell(randoW, 0).setNorthWall(false);
		} else {
			maze.getCell(randoW, h-1).setSouthWall(false);
		}
		
		if(tb2 == true) {
		maze.getCell(0, randoH).setWestWall(false);	
		} else {
			maze.getCell(w-1, randoH).setEastWall(false);
		}
		
		
		
		
		
		
		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. mark cell as visited
		currentCell.setBeenVisited(true);
		// B. check for unvisited neighbors using the cell
		ArrayList<Cell> unvisits = getUnvisitedNeighbors(currentCell);
		if (unvisits.size() > 0) {
			int rand = new Random().nextInt(unvisits.size());

			uncheckedCells.push(unvisits.get(rand));
			removeWalls(currentCell, unvisits.get(rand));

			currentCell = unvisits.get(rand);

			unvisits.get(rand).setBeenVisited(true);
			selectNextPath(currentCell);
		} else if (uncheckedCells.isEmpty() == false) {
			currentCell = uncheckedCells.pop();
			selectNextPath(currentCell);
		}
		// C. if has unvisited neighbors,

		// C1. select one at random.

		// C2. push it to the stack

		// C3. remove the wall between the two cells

		// C4. make the new cell the current cell and mark it as visited

		// C5. call the selectNextPath method with the current cell

		// D. if all neighbors are visited

		// D1. if the stack is not empty

		// D1a. pop a cell from the stack

		// D1b. make that the current cell

		// D1c. call the selectNextPath method with the current cell

	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		System.out.println("was called");
		
		if (c1.getX() == c2.getX() && c1.getY() - c2.getY() == 1) {
			c1.setNorthWall(false);
			c2.setSouthWall(false);

		} else if (c1.getX() == c2.getX() && c2.getY() - c1.getY() == 1) {
			c1.setSouthWall(false);
			c2.setNorthWall(false);
		}

		if (c1.getY() == c2.getY() && c1.getX() - c2.getX() == 1) {
			c1.setWestWall(false);
			c2.setEastWall(false);

		} else if (c1.getY() == c2.getY() && c2.getX() - c1.getX() == 1) {
			c1.setEastWall(false);
			c2.setWestWall(false);
		}

	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {

		ArrayList<Cell> unvisitedes = new ArrayList<Cell>();

		if (c.getX() != maze.getWidth() - 1 && maze.cells[c.getX() + 1][c.getY()].hasBeenVisited() == false) {
			unvisitedes.add(maze.cells[c.getX() + 1][c.getY()]);
		}

		if (c.getX() != 0 && c.getX() != 0 && maze.cells[c.getX() - 1][c.getY()].hasBeenVisited() == false) {
			unvisitedes.add(maze.cells[c.getX() - 1][c.getY()]);
		}

		if (c.getY() != maze.getHeight() - 1 && maze.cells[c.getX()][c.getY() + 1].hasBeenVisited() == false) {
			unvisitedes.add(maze.cells[c.getX()][c.getY() + 1]);
		}

		if (c.getY() != 0 && maze.cells[c.getX()][c.getY() - 1].hasBeenVisited() == false) {
			unvisitedes.add(maze.cells[c.getX()][c.getY() - 1]);
		}

		return unvisitedes;
	}
}
