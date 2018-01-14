package GUI;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import reversiGame.Game;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("FXMLDemo.fxml"));
			Scene scene = new Scene(root,400,350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Reversi FXML, Welcome!");
			Label l = new Label("click start!");
			Button startButton = new Button("start");
			startButton.setOnAction(event-> {
				l.setText("Button clicked!");
			});
			root.getChildren().add(startButton);
			root.getChildren().add(l);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
//		Game game = new Game();
//		game.initialize();
//		game.play();
	}
}
