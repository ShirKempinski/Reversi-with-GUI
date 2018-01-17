package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Color;
import reversiGame.Board;
import reversiGame.GameLogic;

public class SettingData {
	
	private static int boardSize;
	private static Color player1Color;
	private static Color player2Color;
	private static int firstPlayer;
		
	public static void readSettingsFromFile() {
        String fileName = "fileName.txt";
        BufferedReader br = null;
        FileReader fr = null;
        Map<String, String> settingsMap = new HashMap<String, String>();
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] parts = sCurrentLine.split(": ");
                settingsMap.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String order = settingsMap.get("start Player");
        String[] parts = order.split(" ");
        firstPlayer = Integer.parseInt(parts[1]);
        
        String colorPlayer1 = settingsMap.get("color player1");
        player1Color = Color.valueOf(colorPlayer1);

        String colorPlayer2 = settingsMap.get("color player2");
        player2Color = Color.valueOf(colorPlayer2);
        
        String size = settingsMap.get("board size");
        String[] sizeParts = size.split("x");
        boardSize = Integer.parseInt(parts[0]);
    }
	
	public static int getBoardSize() {
		return boardSize;
	}

	public static Color getPlayer1Color() {
		return player1Color;
	}
	
	public static Color getPlayer2Color() {
		return player2Color;
	}
	
	public static int getFirstPlayer() {
		return firstPlayer;
	}
}
