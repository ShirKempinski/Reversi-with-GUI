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
	private Text message;
	
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

	/**
	 * function name: ReversiController
	 * input: void
	 * output: void
	 * operation: constructor
	 */
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
	
	/**
	 * function name:initialize
	 * input: void
	 * output: URL location, ResourceBundle resources
	 * operation: The function edits the screen of the settings window
	 */
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
		message.setText("");
		
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
	
	/**
	 * function name:playOneTurn
	 * input: void
	 * output: Square move
	 * operation: The function play One Turn.    
	 */
	public void playOneTurn(Square move) {
		// validate the move
		if (isValidMove(move)) {
			message.setText("");
			this.logic.turnDisks(currentPlayer, opponentPlayer, move);
			updatePlayers();
		// if the move is illegal
		} else {
			message.setText("Illegal Move!");
		}
		// if the game is over
		if (this.logic.gameShouldStop(currentPlayer, opponentPlayer)) {
			int score1 = this.board.getScore(this.player1.getType());
			int score2 = this.board.getScore(this.player2.getType());
			if (score1 > score2) {
				message.setText("Game Over\n" + "Player 1 win");
			} else if (score2 > score1) {
				message.setText("Game Over\n" + "Player 2 win");
			} else {
				message.setText("Game Over\n" + "I'ts a Tie");
			}
			
		// if this player has no possible moves
		} else if (this.logic.getPossibleMoves(this.currentPlayer, this.opponentPlayer).isEmpty()) {
			message.setText("No possible moves.\nThe turn passes back\nto the other player.");
			updatePlayers();
		}
		
		// draw the board
		this.reversiBoard.draw();		
	}
	
	
	/**
	 * function name: isValidMove
	 * input: Square move
	 * output:  boolean
	 * operation: The function returns true or false if the move the player has played is valid.
	 */
	public boolean isValidMove(Square move) {
		return this.logic.isPossibleMove(move.getX(), move.getY(), this.currentPlayer, this.opponentPlayer);
	}
	
	
	/**
	 * function name: updatePlayers
	 * input: void
	 * output:  void
	 * operation: The function updates the scores of the players and the player whose turn is to play.
	 */
	public void updatePlayers() {
		// update the turns
		Player tmp = this.currentPlayer;
		this.currentPlayer = this.opponentPlayer;
		this.opponentPlayer = tmp;
				
		// update the scores
		int score = this.board.getScore(this.player1.getType());
        this.scores1Value.setText(""+score);
        score = this.board.getScore(this.player2.getType());
        this.scores2Value.setText(""+score);
		currentValue.setText(currentPlayer.toString());
	}
	
	/**
	 * function name: backToMain
	 * input: void
	 * output:  void
	 * operation: The function back To Menu
	 */
   	 public void backToMain() {
        	Menu menu = new Menu();
        	try {
            	menu.start((Stage) backToMain.getScene().getWindow());
       		 } catch (Exception e) {
        	    e.printStackTrace();
        	}
    	}
}
