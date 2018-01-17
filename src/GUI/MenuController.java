package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button startButton;

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReversiGame.fxml"));
            loader.setController(rc);
            HBox root = (HBox) loader.load();
            Scene scene = new Scene(root, 600, 450);
            scene.getStylesheets().add(getClass().getResource("ReversiGame.css").toExternalForm());
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
        	System.out.println(e.getMessage());
        }
    }
    
    @FXML
    public void closeReversi() {
    	Stage stage = (Stage) settingsButton.getScene().getWindow();
    	stage.close();
    }

}
