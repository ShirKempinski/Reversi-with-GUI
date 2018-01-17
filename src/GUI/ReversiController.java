package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import reversiGame.Board;
import reversiGame.GameLogic;
import reversiGame.Player;
import reversiGame.Square;

public class ReversiController implements Initializable {
	@FXML
	private HBox root;
	
	@FXML
	private Text scoresPlayer1;
	
	@FXML
	private Text scores1Value;
	
	@FXML
	private Text scoresPlayer2;
	
	@FXML
	private Text scores2Value;
	
	@FXML
	private Text current;
	
	@FXML
	private Text currentValue;
	
	@FXML
	private Text illeagalMove;
	
	@FXML
	private Button backToMain;
	
	private ReversiBoard reversiBoard;
	private Board board;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Color color1;
	private Color color2;
	private GameLogic logic;

	
	public ReversiController() {
		this.player1 = new Player('X');
		this.player2 = new Player('O');
		if (SettingData.getFirstPlayer() == 1) {
			this.currentPlayer = this.player1;
		} else {
			this.currentPlayer = this.player2;
		}
		this.color1 = SettingData.getPlayer1Color();
		this.color2 = SettingData.getPlayer2Color();
		this.board = new Board(SettingData.getBoardSize());
		this.logic = new GameLogic(this.board);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// initialize fxml privates
		reversiBoard = new ReversiBoard(this.board, new SquareListener(this));
		scoresPlayer1.setText("Player 1 scores:");
		scores1Value.setText("0");
		scoresPlayer2.setText("Player 2 scores:");
		scores2Value.setText("0");
		current.setText("Current player:");
		currentValue.setText(currentPlayer.toString());
		illeagalMove.setText("");
		
		// initialize the reversiBoard
		this.reversiBoard.setPrefWidth(400);
		this.reversiBoard.setPrefHeight(400);
		this.root.getChildren().add(0, reversiBoard);
		this.reversiBoard.draw();

		// handle Windows resize
		this.root.widthProperty().addListener((observable, oldValue, newValue) -> {
			double boardNewWidth = newValue.doubleValue() -	120;
			reversiBoard.setPrefWidth(boardNewWidth);
			reversiBoard.draw();
		});
		this.root.heightProperty().addListener((observable, oldValue, newValue) -> {
			reversiBoard.setPrefHeight(newValue.doubleValue());
			reversiBoard.draw();
		});
	}
	
	public void playOneTurn(Square move) {
		System.out.println("play " + move.getX() + "," + move.getY());
	}
	
    public void backToMain() {
        Menu menu = new Menu();
        try {
            menu.start((Stage) backToMain.getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
