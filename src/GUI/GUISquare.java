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
	private boolean entered;
	private int edgeSize;

	public GUISquare(ReversiBoard gc, Square s, SquareListener listener) {
		this.square = s;
		this.grid = gc;
		this.listener = listener;
		this.entered = false;
	}

	public void draw(int edgeSize) {
		this.edgeSize = edgeSize;
		// draw the rectangle
		Rectangle rectangle = new Rectangle(edgeSize, edgeSize);
		if ((this.square.getX() + this.square.getY()) % 2 == 0) {
			if (this.entered) {
				rectangle.setFill(Color.rgb(247, 204, 157));
			} else {
				rectangle.setFill(Color.rgb(255, 255, 204));
				this.entered = false;
			}
		} else {
			if (this.entered) {
				rectangle.setFill(Color.rgb(170, 100, 170));
			} else {
				rectangle.setFill(Color.rgb(200, 162, 200));
				this.entered = false;
			}
		}
		rectangle.setStroke(Color.rgb(85, 31, 85));
		this.setCenter(rectangle);
		this.grid.add(this, this.square.getY(), this.square.getX());

		// if there's a disk on this square, draw it
		if (!this.square.isEmpty()) {
			BorderPane borderPane = new BorderPane();
			Circle c = new Circle();
			c.setRadius(edgeSize / 2.0 - 4);
			if (this.square.getType() == 'X') {
				c.setFill(SettingData.getPlayer1Color());
				c.setStroke(Color.WHITE);
			} else {
				c.setFill(SettingData.getPlayer2Color());
				c.setStroke(Color.BLACK);
			}
			borderPane.setCenter(c);
			this.grid.add(borderPane, this.square.getY(), this.square.getX());
		}
		// set the listener
		this.setOnMouseClicked(event -> {this.listener.clickEvent(this.square);});
		this.setOnMouseEntered(event -> {this.listener.hoverEvent(this);});
		this.setOnMouseExited(event -> {this.listener.hoverEvent(this);});
	}

	public boolean isEmpty() {
		return this.square.isEmpty();
	}

	public void setHover() {
		this.entered = !this.entered;
		draw(this.edgeSize);
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

	public Square getSquare() {
		return this.square;
	}
}
