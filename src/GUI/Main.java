package GUI;
	
import javafx.application.Application;
import javafx.stage.Stage;
import reversiGame.Game;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Reversi");
			Label l = new Label("click start!");
			Button startButton = new Button("start");
			startButton.setOnAction(event-> {
				l.setText("Button clicked!");
			});
			VBox root = new VBox();
			root.getChildren().add(startButton);
			root.getChildren().add(l);
			primaryStage.setScene(new Scene(root,300,250));
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
