package GUI;

import javafx.scene.layout.GridPane;

import reversiGame.Board;

public class ReversiBoard extends GridPane {
	private Board board;
	private int boardSize;
	private GUISquare[][] squares;
	private SquareListener listener;


	public ReversiBoard(Board b, SquareListener l) {
		this.board = b;
		this.boardSize = this.board.getSize();
		this.listener = l;

		int squareEdge = (int) this.getHeight() / this.boardSize;
		this.squares = new GUISquare[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				this.squares[i][j] = new GUISquare(this, this.board.getSquare(i, j), this.listener);
//				s.setFill(Color.rgb(200, 162, 200));
			}
		}
	}

	public void draw() {
		// clear all that was on screen
		this.getChildren().clear();
		int squareSize = (int) this.getPrefHeight() / this.boardSize;
		// go over the squares
		for (int i = 0; i <  this.boardSize; i++) {
			for (int j = 0; j <  this.boardSize; j++) {
					this.squares[i][j].draw(squareSize);
			}
		}
	}
}
