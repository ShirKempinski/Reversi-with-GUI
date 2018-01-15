package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private  Button start;

    @FXML
    private Button settings;

    @FXML
    private Button close;

    @FXML
    private void startReversi() {
        StartGame startGame = new StartGame();
        Stage stage = (Stage) start.getScene().getWindow();
        try {
            startGame.start(stage);
        } catch (Exception e){

        }
    }

    @FXML
    protected void settingGame() {
        Settings settings = new Settings();
        Stage stage = (Stage) start.getScene().getWindow();
        try {
            settings.start(stage);
        } catch (Exception e){

        }
    }

}
