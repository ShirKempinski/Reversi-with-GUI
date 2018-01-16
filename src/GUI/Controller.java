package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import reversiGame.Board;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private HBox root;
    private Board board;

@Override
public void initialize(URL location, ResourceBundle
        resources) {
        ReversiBoard reversiBoard = new ReversiBoard(board);
        reversiBoard.setPrefWidth(400);
        reversiBoard.setPrefHeight(400);
        root.getChildren().add(0, reversiBoard);
        reversiBoard.draw();
        }

}
