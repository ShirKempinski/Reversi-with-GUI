package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Settings extends Application {

    /**
	 * function name: start
	 * input: Stage primaryStage
	 * output: void
	 * operation: The function starts to run a new game screen.
	 */
    public void start(Stage primaryStage) {
        try {
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(getClass().getResource("../fxml/Settings.fxml"));
        	SettingsController sc = new SettingsController();
        	loader.setController(sc);
        	GridPane root = (GridPane) loader.load();
//          GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("../fxml/Settings.fxml"));
            Scene scene = new Scene(root, 600, 450);
            scene.getStylesheets().add(getClass().getResource("../fxml/Settings.css").toExternalForm());
            primaryStage.setTitle("Settings Game");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * function name: main
	 * input: String[] args
	 * output: void
	 * operation: The function starts to run a settings screen.
	 */
    public static void main(String[] args) {
        launch(args);
    }
}
