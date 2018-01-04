import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * CS 111
 * Project 1
 * @author Kaleb Hamrick
 *
 */

public class Maze {	
	private static int [][] mazeArray = new int [15][15];
	
	
	@SuppressWarnings("resource")
	public static void main (String [] args){
		
		try {
				
		System.out.print("Input the full file location along with its extension i.e (.txt): ");
		Scanner input = new Scanner(System.in);
		File textFile = new File(input.nextLine());
		input = new Scanner(textFile);
		
		
		MazeOperations.fillMaze(mazeArray, input);
		MazeOperations.printMze(mazeArray);
		System.out.println();//used in order to place a space between the mazes for better readability 
		System.out.println(MazeOperations.traverseMaze(mazeArray, 0, 0));
		System.out.println();//used in order to place a space between the mazes for better readability 
		MazeOperations.printMze(mazeArray);
		
		input.close();
	
		} catch (FileNotFoundException e) {
			System.out.println("Incorrect file or file location, try again");
		}
	}
}
	