//package GUI;
//
//import java.util.ArrayList;
//
//import javafx.scene.layout.GridPane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import reversiGame.Player;
//import reversiGame.Square;
//
//public class GUIPlayer {
//	private Player player;
//	private	GridPane grid;
//	private	int	row;
//	private	int	col;
//	private	Circle circle;
//
//	public GUIPlayer(Player p, GridPane	grid, int row, int col) {
//		this.player = p;
//		this.grid = grid;
//		this.row = row;
//		this.col = col;
//		this.circle = new Circle();
//		if (this.player.getType() == 'X') {
//			this.circle.setFill(Color.BLACK);
//			this.circle.setStroke(Color.WHITE);
//		} else {
//			this.circle.setFill(Color.WHITE);
//			this.circle.setStroke(Color.BLACK);
//		}
//	}
//
//
//	public void draw(int cellWidth, int cellHeight) {
//		this.circle.setFitWidth(cellWidth);
//		this.circle.setFitHeight(cellHeight);
//		this.grid.getChildren().remove(this.circle);
//		this.grid.add(this.circle, this.col, this.row);
//	}
//
//	/**
//	 * function name: chooseSquare
//	 * input: ArrayList<Square>
//	 * output: Square
//	 * operation: get a valid move from the user and returns it
//	 */
//	public Square chooseSquare(ArrayList<Square> possibleMoves) {
//		return this.player.chooseSquare(possibleMoves);
//	}
//
//	/**
//	 * function name: getType
//	 * input: void
//	 * output: char
//	 * operation: the player's type (X or O)
//	 */
//	public char getType() {
//		return this.player.getType();
//	}
//
//	/**
//	 * function name: equals
//	 * input: Player
//	 * output: boolean
//	 * operation: checks if the other player equals to this player.
//	 */
//	public boolean equals(Player other) {
//		return this.player.equals(other);
//	}
//}
