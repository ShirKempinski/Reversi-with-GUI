package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import reversiGame.Board;

public class ReversiController implements Initializable {

	@FXML
	private	HBox root;
	private Board board;

	public ReversiController() {
		this.board = new Board(4);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		BoardController boardController	= new BoardController(this.board);
		boardController.setPrefWidth(400);
		boardController.setPrefHeight(400);
		this.root.getChildren().add(0, boardController);         
		boardController.draw();
		
		this.root.widthProperty().addListener((observable, oldValue, newValue) -> {           
			double boardNewWidth = newValue.doubleValue() -	120;
			boardController.setPrefWidth(boardNewWidth);          
			boardController.draw();
		});  
		this.root.heightProperty().addListener((observable, oldValue, newValue) -> {          
			boardController.setPrefHeight(newValue.doubleValue());          
			boardController.draw();
		});
	}

}
