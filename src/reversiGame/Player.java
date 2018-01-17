package reversiGame;

import java.util.ArrayList;
import java.util.Scanner;


public class Player {

	private	char type;

	/**
	 * function name: Player
	 * input: char
	 * output: new object of player
	 * operation: constructor
	 */
	public Player(char t) {
		this.type = t;
	}

	/**
	 * function name: chooseSquare
	 * input: vector<Square>
	 * output: Square
	 * operation: get a valid move from the user and returns it
	 */
	public Square chooseSquare(ArrayList<Square> possibleMoves) {
		System.out.println();
		System.out.print("Please enter your move, row col: ");
		int x, y;
		while (true) {
			Scanner scanIn = new Scanner(System.in);
			String move = scanIn.nextLine();
			x = Integer.parseInt(move.substring(0, 1));
			y = Integer.parseInt(move.substring(2));
			Square playersChoice = new Square(x,y);
			int size = possibleMoves.size();
			for (int i = 0; i < size; i++) {
				if (possibleMoves.get(i).equals(playersChoice)) {
					return playersChoice;
				}
			}
			System.out.println();
			System.out.println("Not a valid choice. Please enter your move row,col:");
		}
	}

	/**
	 * function name: getType
	 * input: void
	 * output: char
	 * operation: the player's type (X or O)
	 */
	public char getType() {
		return this.type;
	}

	/**
	 * function name: equals
	 * input: Player
	 * output: boolean
	 * operation: checks if the other player equals to this player.
	 */
	public boolean equals(Player other) {
		if (this.type == other.getType()) {
			return true;
		}
		return false;
	}
	
	/**
	 * function name: toString
	 * input: void
	 * output: String
	 * operation: returns a string that represent the player
	 */
	public String toString() {
		if (this.type == 'X') {
			return "Player 1";
		} else {
			return "Player 2";
		}
	}

}
