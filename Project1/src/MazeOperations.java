import java.util.Scanner;

public class MazeOperations {

	public static void fillMaze(int[][] theMaze, Scanner inputFile) {
		while (inputFile.hasNext()) {
			for (int i = 0; i < theMaze.length; i++) {
				for (int j = 0; j < theMaze[i].length; j++) {
					theMaze[i][j] = inputFile.nextInt();

				}
			}
		}
	}

	public static void printMze(int[][] theMaze) {
		for (int i = 0; i < theMaze.length; i++) {
			for (int j = 0; j < theMaze[i].length; j++) {
				System.out.printf("%2d ", theMaze[i][j]);
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * @param theMaze must be a 2d int array with non negative numbers
	 * @param row must be a non negative int and is used for starting location of the maze
	 * @param col must be a non negative int and is used for starting location of the maze
	 * @return will return true if the maze is solvable or false if there is no solution
	 */
	public static boolean traverseMaze(int[][] theMaze, int row, int col) {

		// base case
		if (theMaze[14][14] == 7) {
			return true;
		}

		// used to mark a visited cell that is part of the solution
		else if (theMaze[row][col] == 1) {
			theMaze[row][col] = 7;

			// we go down
			if (row < theMaze[row].length - 1) {
				 traverseMaze(theMaze, row + 1, col);

			}

			// we go left
			if (col > 0) {
				 traverseMaze(theMaze, row, col - 1);

			}

			// we go up
			if (row > 0) {
				 traverseMaze(theMaze, row - 1, col);

			}

			// we go right
			if (col < theMaze.length - 1) {
				 traverseMaze(theMaze, row, col + 1);

			}

			// used to mark a visited cell not part of the solution
			if (traverseMaze(theMaze, row, col) == false) {
				theMaze[row][col] = 3;
			}

			else
				return true;

		}
		return false;
	}
}
