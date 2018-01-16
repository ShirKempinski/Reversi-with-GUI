package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import reversiGame.Board;
import reversiGame.Game;

public class ReversiController implements Initializable {

	@FXML
	private	HBox root;
	private Board board;

	public ReversiController() {
		this.board = new Board(4);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ReversiBoard reversiBoard = new ReversiBoard(this.board);
		reversiBoard.setPrefWidth(400);
		reversiBoard.setPrefHeight(400);
		this.root.getChildren().add(0, reversiBoard);
		reversiBoard.draw();
		
		this.root.widthProperty().addListener((observable, oldValue, newValue) -> {           
			double boardNewWidth = newValue.doubleValue() -	120;
			reversiBoard.setPrefWidth(boardNewWidth);
			reversiBoard.draw();
		});  
		this.root.heightProperty().addListener((observable, oldValue, newValue) -> {          
			reversiBoard.setPrefHeight(newValue.doubleValue());
			reversiBoard.draw();
		});
		
		Game game = new Game();
		game.initialize();
		game.play();

	}

}
