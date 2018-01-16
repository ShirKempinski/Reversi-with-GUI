package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import reversiGame.Board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import reversiGame.Game;
import reversiGame.GameLogic;
import reversiGame.Player;

import java.io.IOException;

public class StartGameController implements Initializable {

    @FXML
    private Button endGame;
    @FXML
    private HBox root;
    private Board board;
    private Player player1;
    private Player player2;
    private GameLogic logic;
    private int boardSize;


    public void readSettingsFromFile() {

        String fileName = "fileName.txt";
        BufferedReader br = null;
        FileReader fr = null;
        Map<String, String> settingsMap = new HashMap<String, String>();
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] parts = sCurrentLine.split(": ");
                settingsMap.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String firstPlayer = settingsMap.get("start Player");
        String colorPlayer1 = settingsMap.get("color player1");
        String colorPlayer2 = settingsMap.get("color player2");
        String size = settingsMap.get("board size");
        String[] parts = size.split("x");
        boardSize = Integer.parseInt(parts[0]);
        this.board = new Board(boardSize);
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.logic = new GameLogic(this.board);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.readSettingsFromFile();
        ReversiBoard reversiBoard = new ReversiBoard(board);
        reversiBoard.setPrefWidth(400);
        reversiBoard.setPrefHeight(400);
        root.getChildren().add(0, reversiBoard);
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

        //play()
    }



    public void endGame() {
        Menu menu = new Menu();
        try {
            menu.start((Stage) this.endGame.getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}