package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Reversi");
			StackPane root = new StackPane();
			Button startButton = new Button("start");
			startButton.setFont(new Font("David", 30));
			root.getChildren().add(startButton);
			primaryStage.setScene(new Scene(root,400,400));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		Game game = new Game();
		game.initialize();
		game.play();
	}
}
