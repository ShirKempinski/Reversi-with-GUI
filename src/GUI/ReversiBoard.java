//package GUI;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.control.Cell;
//import javafx.scene.layout.GridPane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
//import reversiGame.Board;
//
//public class ReversiBoard extends GridPane {
//	private Board board;
//	private ArrayList<ArrayList<GUISquare>> squares;
//	private int boardSize;
//	private final int prefHeight = 400;
//	private final int prefWidth = 400;
//
//
//	public ReversiBoard(Board b) {
//		this.board = b;
//		this.boardSize = this.board.getSize();
//
//		int squareHeight = (int)this.getPrefHeight() / boardSize;
//		int squareWidth = (int)this.getPrefWidth() / boardSize;
//
//		for (int i = 0; i < boardSize; i++) {
//			ArrayList<GUISquare> list = new ArrayList<GUISquare>();
//			for (int j = 0; j < boardSize; j++) {
//				GUISquare s = new GUISquare(this.board.getSquare(i, j));
//				s.setFill(Color.rgb(200, 162, 200));
//				s.setStroke(Color.rgb(85, 31, 85));
//				s.setWidth(squareWidth);
//				s.setHeight(squareHeight);
//				//s.setOnMouseClicked();
//				list.add(s);
//			}
//			this.squares.add(list);
//		}
//
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUIBoard.fxml"));
//		fxmlLoader.setRoot(this);
//		fxmlLoader.setController(this);
//		try {
//			fxmlLoader.load();
//		} catch (IOException exception) {
//			throw new RuntimeException(exception);
//		}
//	}
//
//	public void draw() {
//		// clear all that was on screen
//		this.getChildren().clear();
//		int height = (int)this.getPrefHeight();
//		int width = (int)this.getPrefWidth();
//		int cellHeight = height / board.getSize();
//		int cellWidth = width / board.getSize();
//
//		// go over the squares
//		for (int i = 0; i <  board.getSize(); i++) {
//			for (int j = 0; j <  board.getSize(); j++) {
//					this.add(new Rectangle(cellWidth, cellHeight, Color.WHITE), j, i);
//			}
//		}
//
//
//		for (int i = 0; i <  board.getSize(); i++) {
//			for (int j = 0; j < board.getSize(); j++) {
//				if (board.getType(i, j) == 'X') {
//				//	player1.draw(cellWidth, cellHeight, i, j, this);
//				}
//			else if (board.getType(i, j) == 'O') {
//				//	player2.draw(cellWidth, cellHeight, i, j, this);
//				}
//			}
//		}
//	}
//
//	public int getBoardSize() {
//		return this.boardSize;
//	}
//}
