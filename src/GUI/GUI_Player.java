package GUI;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import reversiGame.Player;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class GUI_Player {

    private Player player;
    private GridPane grid;
    private Color color;

    public GUI_Player(Player p, GridPane grid, Color color){
    this.color = color;
    this.player = p;
    this.grid = grid;

    }
    public void draw(int cellWidth, int cellHeight) {

//        new Circle( 5 , 6 , 7.5,(this.color));
//        //setColor(this.color);
//        surface.fillCircle((int) this.getX(), (int) this.getY(), r);
//        grid.getChildren().remove(iv);
//        grid.add(iv, col, row);
    }
}
