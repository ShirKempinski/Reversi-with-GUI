package reversiGame;

import java.util.Scanner;

public class Game {

	private	GameLogic logic;
	private	Player X;
	private	Player O;
	
	/**
	 * function name: Game
	 * input: void
	 * output: new game object
	 * operation: constructor
	 */
	public Game() {
		this.X = new Player('X');
		this.O = new Player('O');
	}
	
	/**
	 * function name: initialize
	 * input: void
	 * output: void
	 * operation: initialize user's preferences to game
	 */
	public void initialize() {
		System.out.println("Welcome to Reversi!");
		int size = 0;
		Scanner scanIn = new Scanner(System.in);
		while (size < 4 || size > 20) {
			System.out.print("Please choose board size between 4 and 20: ");
			size = scanIn.nextInt();
		}
		this.logic = new GameLogic(new Board(size));
	}
	/**
	 * function name: play
	 * input: void
	 * output: void
	 * operation: activates the game loop
	 */
	public void play() {
		while (!this.logic.gameShouldStop(this.X, this.O)) {
			Player current;
			Player opponent;
			if (this.logic.whosTurn(this.X, this.O).equals(this.X)) {
				current = this.X;
				opponent = this.O;
			} else {
				current = this.O;
				opponent = this.X;
			}
			this.logic.playOneTurn(current, opponent);
		}
		this.logic.endGame();
	}

}
