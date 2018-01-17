package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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
        Stage stage = (Stage) startButton.getScene().getWindow();
        SettingData.readSettingsFromFile();
        ReversiController rc = new ReversiController();
        
        try {
            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("StartGame.fxml"));
            Scene scene = new Scene(root, 600, 450);
            scene.getStylesheets().add(getClass().getResource("StartGame.css").toExternalForm());
            stage.setTitle("Reversi");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
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
