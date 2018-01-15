package GUI;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import reversiGame.Board;

public class BoardController extends GridPane {
	private Board board;
	private ArrayList<ArrayList<GUISquare>> squares;
	private int boardSize;

	public BoardController(Board b) {
		this.board = b;
		this.boardSize = this.board.getSize();
		
		int squareHeight = (int)this.getPrefHeight() / boardSize;
		int squareWidth = (int)this.getPrefWidth() / boardSize;
		
		for (int i = 0; i < boardSize; i++) {
			ArrayList<GUISquare> list = new ArrayList<GUISquare>();
			for (int j = 0; j < boardSize; j++) {
				GUISquare s = new GUISquare(this.board.getSquare(i, j));
				s.setFill(Color.rgb(200, 162, 200));
				s.setStroke(Color.rgb(85, 31, 85));
				s.setWidth(squareWidth);
				s.setHeight(squareHeight);
				//s.setOnMouseClicked();
				list.add(s);
			}
			this.squares.add(list);
		}
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUIBoard.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}
	
	public void draw() {
		// clear all that was on screen
		this.getChildren().clear();
		// go over the squares
		for (int i = 0; i < this.boardSize; i++) {
			for (int j = 0; j < this.boardSize; j++) {
				// add each square
				GUISquare s = this.squares.get(i).get(j);
				this.add(s, j, i);
				// if the square isn't empty, add it's content as a circle
				if (!s.isEmpty()) {
					Circle c = new Circle();
					c.setCenterX(s.getX() + s.getWidth() / 2);
					c.setCenterY(s.getY() + s.getHeight() / 2);
					c.setRadius(this.getPrefHeight() / (this.boardSize * 2) - 4);
					if (s.getType() == 'X') {
						c.setFill(Color.BLACK);
						c.setStroke(Color.WHITE);
					} else {
						c.setFill(Color.WHITE);
						c.setStroke(Color.BLACK);
					}
					this.add(c, j, i);
				}
			}
		}
	}
}