package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private  Button startButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button closeButton;

    @FXML
    private void startReversi() {
        StartGame startGame = new StartGame();
        Stage stage = (Stage) startButton.getScene().getWindow();
        try {
            startGame.start(stage);
        } catch (Exception e){

        }
    }

    @FXML
    protected void settingGame() {
        Settings settings = new Settings();
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        try {
            settings.start(stage);
        } catch (Exception e){

        }
    }

}
