//package GUI;
//
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
//import reversiGame.Square;
//
//public class GUISquare extends Rectangle {
//	private Square square;
//
//	public GUISquare(Square s) {
//		this.square = s;
//	}
//
//	public void draw(ReversiBoard bc) {
//		bc.add(this, this.square.getY(), this.square.getX());
//		if (!this.square.isEmpty()) {
//			Circle c = new Circle();
//			c.setCenterX(this.getX() + this.getWidth() / 2);
//			c.setCenterY(this.getY() + this.getHeight() / 2);
//			c.setRadius(bc.getPrefHeight() / (bc.getBoardSize() * 2) - 4);
//			if (this.square.getType() == 'X') {
//				c.setFill(Color.BLACK);
//				c.setStroke(Color.WHITE);
//			} else {
//				c.setFill(Color.WHITE);
//				c.setStroke(Color.BLACK);
//			}
//			bc.add(c, this.square.getY(), this.square.getX());
//		}
//	}
//
//	public boolean isEmpty() {
//		return this.square.isEmpty();
//	}
//
//	/**
//	 * function name: getI
//	 * input: void
//	 * output: the square's x value
//	 * operation: return the square's x value
//	 */
//	public int getI() {
//		return this.square.getX();
//	}
//
//	/**
//	 * function name: getJ
//	 * input: void
//	 * output: the square's y value
//	 * operation: return the square's y value
//	 */
//	public int getJ() {
//		return this.square.getY();
//	}
//
//	/**
//	 * function name: equals
//	 * input: Square
//	 * output: boolean
//	 * operation: checks if the given square is equal to this square
//	 */
//	public boolean equals(GUISquare other) {
//		if (other.getX() == this.square.getX() && other.getY() == this.square.getY()) {
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * function name: setType
//	 * input: char
//	 * output: void
//	 * operation: set the square's type
//	 */
//	public void setType(char t) {
//		this.square.setType(t);
//	}
//
//	/**
//	 * function name: getType
//	 * input: void
//	 * output: char
//	 * operation: returns the square's type
//	 */
//	public char getType() {
//		return this.square.getType();
//	}
//}
