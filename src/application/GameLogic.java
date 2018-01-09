package application;

import java.util.ArrayList;
import application.Board.Winner;

public class GameLogic {
	public enum GameOver {NoMoreMoves, FullBoard};

	private	Board board;
	private	int turns;

	/**
	 * function name: GameLogic
	 * input: board object
	 * output: new GameLogic object
	 * operation: constructor
	 */
	public GameLogic(Board board) {
		this.turns = 0;
		this.board = board;
	}

	/**
	 * function name: possibleMoves
	 * input: the players
	 * output: a vector of the possible moves (squares)
	 * operation: get all the current player's possible moves
	 */
	ArrayList<Square> possibleMoves(Player current, Player opponent){
		ArrayList<Square> moves = new ArrayList<Square>();
		int size = this.board.getSize();
		// go over the board
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// if the cell dosn't exist or is not empty, continue
				if (board.isOutOfBounderies(i,j) || board.getType(i,j) != ' ') {
					continue;
				}
				// if it's a valid move, push it in the vector
				if (isPossibleMove(i, j, current, opponent)) {
					moves.add(new Square(i+1, j+1));
				}
			}
		}
		return moves;
	}


	/**
	 * function name: isPossibleMove
	 * input: location and 2 players
	 * output: boolean
	 * operation: check the given location's each direction and returns true if any of them is valid
	 */
	public boolean isPossibleMove(int x, int y ,Player current, Player opponent) {
		// check upper left
		if (checkDirection(current, opponent, x-1, y-1, -1, -1, 0)) {
			return true;
		}
		// check upper mid
		if (checkDirection(current, opponent, x-1, y, -1, 0, 0)) {
			return true;
		}
		// check upper right
		if (checkDirection(current, opponent, x-1, y+1, -1, 1, 0)) {
			return true;
		}
		// check mid left
		if (checkDirection(current, opponent, x, y-1, 0, -1, 0)) {
			return true;
		}
		// check mid right
		if (checkDirection(current, opponent, x, y+1, 0, 1, 0)) {
			return true;
		}
		// check lower left
		if (checkDirection(current, opponent, x+1, y-1, 1, -1, 0)) {
			return true;
		}
		// check lower mid
		if (checkDirection(current, opponent, x+1, y, 1, 0, 0)) {
			return true;
		}
		// check mid right
		if (checkDirection(current, opponent, x+1, y+1, 1, 1, 0)) {
			return true;
		}
		return false;
	}


	/**
	 * function name: checkDirection
	 * input: 2 players, location, direction, counter of length
	 * output: boolean
	 * operation: recursive function that checks if a certain direction is valid.
	 */
	public boolean checkDirection(Player current, Player opponent, int x, int y, int dx, int dy, int length) {
		// if this cell is out of boundaries, or empty,
		// or it's our cell but we didn't pass any opponent's cells on the way
		if (this.board.isOutOfBounderies(x, y) || this.board.isEmpty(x, y)
				|| (this.board.getType(x, y) == current.getType() && length == 0)) {
			return false;
		}
		// if we've reached our own cell
		// (and there was an opponent's cell on our way)
		if (this.board.getType(x, y) == current.getType()) {
			return true;
		}
		// if this is an opponent's cell
		return checkDirection(current, opponent, x+dx, y+dy, dx, dy, length+1);
	}


	/**
	 * function name: flipInRightDirection
	 * input: 2 players, location and direction
	 * output: boolean
	 * operation: recursive function that flips the cells in a certain location, if valid.
	 */
	public boolean flipInRightDirection(Player current, Player opponent, int x, int y, int dx, int dy) {
		// if this cell is out of boundaries or empty
		if (this.board.isOutOfBounderies(x, y) || this.board.isEmpty(x, y)) {
			return false;
		}
		// if we've reached our own cell
		// (and there was an opponent's cell on our way)
		if (this.board.getType(x, y) == current.getType()) {
			return true;
		}
		// if this direction is good - it's the opponent's cell
		if (flipInRightDirection(current, opponent, x+dx, y+dy, dx, dy)) {
			// flip the disk
			this.board.setType(x, y, current.getType());
			return true;
		} else {
			return false;
		}
	}


	/**
	 * function name: turnDisks
	 * input: 2 players, move (Square)
	 * output: void
	 * operation: turns the disks in all the valid directions around the given move.
	 */
	public void turnDisks(Player current, Player opponent, Square move) {
		int x = move.getX()-1;
		int y = move.getY()-1;
		// check upper left
		if (flipInRightDirection(current, opponent, x-1, y-1, -1, -1)) {
			this.board.setType(x, y, current.getType());		
		}
		// check upper mid
		if (flipInRightDirection(current, opponent, x-1, y, -1, 0)) {
			this.board.setType(x, y, current.getType());
		}
		// check upper right
		if (flipInRightDirection(current, opponent, x-1, y+1, -1, 1)) {
			this.board.setType(x, y, current.getType());
		}
		// check mid left
		if (flipInRightDirection(current, opponent, x, y-1, 0, -1)) {
			this.board.setType(x, y, current.getType());
		}
		// check mid right
		if (flipInRightDirection(current, opponent, x, y+1, 0, 1)) {
			this.board.setType(x, y, current.getType());
		}
		// check lower left
		if (flipInRightDirection(current, opponent, x+1, y-1, 1, -1)) {
			this.board.setType(x, y, current.getType());
		}
		// check lower mid
		if (flipInRightDirection(current, opponent, x+1, y, 1, 0)) {
			this.board.setType(x, y, current.getType());
		}
		// check mid right
		if (flipInRightDirection(current, opponent, x+1, y+1, 1, 1)) {
			this.board.setType(x, y, current.getType());
		}
	}


	/**
	 * function name: printPossibleMoves
	 * input: ArrayLisy<Square>
	 * output: void
	 * operation: prints out the moves
	 */
	public void printPossibleMoves(ArrayList<Square> moves) {
		System.out.print("Your possible moves are: ");
		int size = moves.size();
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				System.out.print(",");
			}
			moves.get(i).print();
		}
		System.out.println();
	}

	/**
	 * function name: playOneTurn
	 * input: 2 players
	 * output: void
	 * operation: prints out the board, get the player's next move and operates it
	 */
	public void playOneTurn(Player current, Player opponent) {
		this.board.print();
		System.out.print(current.getType() + ": It's youre move. ");
		// check if there are possible moves
		ArrayList<Square> moves = possibleMoves(current, opponent);
		if (moves.isEmpty()) {
			System.out.println("No possible moves. Play passes back to the other player.");
			this.turns++;
			return;
		}
		// print the moves to the current player
		printPossibleMoves(moves);
		// get the player's next move
		Square nextMove = current.chooseSquare(moves);
		// make the move
		turnDisks(current, opponent, nextMove);
		// update turn
		this.turns++;
	}


	/**
	 * function name: gameShouldStop
	 * input: 2 players
	 * output:boolean
	 * operation: check if the board is full or if both players can't make any more moves
	 */
	public boolean gameShouldStop(Player X, Player O) {
		if (possibleMoves(X,O).isEmpty() && possibleMoves(O,X).isEmpty()) {
			System.out.println("No more possible moves for both players.");
			return true;
		}
		if (this.board.isboardfull()) {
			return true;
		}
		return false;
	}


	/**
	 * function name: whosTurn
	 * input: 2 players
	 * output: Player
	 * operation: returns the player who's turn it is
	 */
	public Player whosTurn(Player X, Player O) {
		if (turns % 2 == 0) {
			return X;
		}
		return O;
	}

	/**
	 * function name: gameStopped
	 * input: 2 players
	 * output: GameOver
	 * operation: returns the reason for the end of the game.
	 */
	public GameOver gameStopped(Player X, Player O) {
		if (this.board.isboardfull()) {
			return GameOver.FullBoard;
		} return GameOver.NoMoreMoves;
	}

	/**
	 * function name: endGame
	 * input: void
	 * output: void
	 * operation: prints out the game result
	 */
	public void endGame() {
		System.out.print("Game is over.");
		Winner result = this.board.whoWin();
		if (result == Winner.O) {
			System.out.println(" O wins.");
		} else if (result == Winner.X) {
			System.out.println(" X wins.");
		} else {
			System.out.println(" No one wins - it's a tie.");
		}
	}
}
