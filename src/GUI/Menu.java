package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu extends Application {

    @Override
        public void start(Stage primaryStage) {
            try {
                GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Scene scene = new Scene(root,600,450);
                scene.getStylesheets().add(getClass().getResource("Menu.css").toExternalForm());
                primaryStage.setTitle("Reversi Game");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] args) {
            launch(args);
        }

    }
