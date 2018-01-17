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
	private Player opponentPlayer;
	private Color color1;
	private Color color2;
	private GameLogic logic;

	
	public ReversiController() {
		this.player1 = new Player('X');
		this.player2 = new Player('O');
		if (SettingData.getFirstPlayer() == 1) {
			this.currentPlayer = this.player1;
			this.opponentPlayer = this.player2;
		} else {
			this.currentPlayer = this.player2;
			this.opponentPlayer = this.player1;
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
		scores1Value.setText("2");
		scoresPlayer2.setText("Player 2 scores:");
		scores2Value.setText("2");
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
		// validate the move
		if (!isValidMove(move)) {
			illeagalMove.setText("Illeagal Move!");
			this.reversiBoard.draw();
			return;
		}
		// make the move
		illeagalMove.setText("");
		this.logic.turnDisks(currentPlayer, opponentPlayer, move);
		updatePlayers();
		
		
		// if the game is over, alert
		if (this.logic.gameShouldStop(currentPlayer, opponentPlayer)) {
 		} else {
			this.reversiBoard.draw();
		}
	}
	
	public boolean isValidMove(Square move) {
		return this.logic.isPossibleMove(move.getX(), move.getY(), this.currentPlayer, this.opponentPlayer);
	}
	
	public void updatePlayers() {
		if (!(this.currentPlayer == this.logic.whosTurn(currentPlayer, opponentPlayer))) {
			Player tmp = this.currentPlayer;
			this.currentPlayer = this.opponentPlayer;
			this.opponentPlayer = tmp;
		}
		
		Integer score = new Integer(this.board.getScore(this.player1.getType()));
		this.scores1Value.setText(score.toString());
		score = new Integer(this.board.getScore(this.player2.getType()));
		this.scores2Value.setText(score.toString());
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
