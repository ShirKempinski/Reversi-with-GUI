package application;

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
		System.out.println("Please enter your move, row col:");
		int x = -1, y = -1;
		Scanner scanIn = new Scanner(System.in);
		while (true) {
			x = scanIn.nextInt();
			y = scanIn.nextInt();
			Square playersChoice = new Square(x,y);
			int size = possibleMoves.size();
			for (int i = 0; i < size; i++) {
				if (possibleMoves.get(i).equals(playersChoice)) {
					scanIn.close();
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
		if (this.type == other.type) {
			return true;
		}
		return false;
	}

}
