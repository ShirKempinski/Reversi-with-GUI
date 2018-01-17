package GUI;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import reversiGame.Square;

public class GUISquare extends BorderPane {
	private Square square;
	private GridPane grid;
	private SquareListener listener;
	private int boardSize;
	private int edgeSize;

	public GUISquare(ReversiBoard gc, Square s, SquareListener listener, int boardSize, int edgeSize) {
		this.square = s;
		this.grid = gc;
		this.listener = listener;
		this.boardSize = boardSize;
	}

	public void draw() {
		// draw the rectangle
		Rectangle rectangle = new Rectangle(this.edgeSize, this.edgeSize);
		rectangle.setFill(Color.rgb(255, 255, 204));
		rectangle.setStroke(Color.rgb(85, 31, 85));
		this.grid.add(this, this.square.getY(), this.square.getX());

		// if there's a disk on this square, draw it
		if (!this.square.isEmpty()) {
			Circle c = new Circle();
			c.setCenterX(rectangle.getX() + this.edgeSize / 2);
			c.setCenterY(rectangle.getY() + this.edgeSize / 2);
			c.setRadius(this.grid.getPrefHeight() / (this.boardSize * 2) - 4);
			if (this.square.getType() == 'X') {
				c.setFill(SettingData.getPlayer1Color());
				c.setStroke(Color.WHITE);
			} else {
				c.setFill(SettingData.getPlayer2Color());
				c.setStroke(Color.BLACK);
			}
			this.grid.add(c, this.square.getY(), this.square.getX());
		}
		// set the listener
		this.setOnMouseClicked(event -> {this.listener.clickEvent(this.square);});
	}

	public boolean isEmpty() {
		return this.square.isEmpty();
	}

	/**
	 * function name: getI
	 * input: void
	 * output: the square's x value
	 * operation: return the square's x value
	 */
	public int getI() {
		return this.square.getX();
	}

	/**
	 * function name: getJ
	 * input: void
	 * output: the square's y value
	 * operation: return the square's y value
	 */
	public int getJ() {
		return this.square.getY();
	}

	/**
	 * function name: equals
	 * input: Square
	 * output: boolean
	 * operation: checks if the given square is equal to this square
	 */
	public boolean equals(GUISquare other) {
		if (other.getI() == this.square.getX() && other.getJ() == this.square.getY()) {
			return true;
		}
		return false;
	}

	/**
	 * function name: setType
	 * input: char
	 * output: void
	 * operation: set the square's type
	 */
	public void setType(char t) {
		this.square.setType(t);
	}

	/**
	 * function name: getType
	 * input: void
	 * output: char
	 * operation: returns the square's type
	 */
	public char getType() {
		return this.square.getType();
	}
}
