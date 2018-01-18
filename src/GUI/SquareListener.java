package GUI;

import reversiGame.Square;

public class SquareListener {

	private ReversiController rc;
	
	public SquareListener(ReversiController controller) {
		this.rc = controller;
	}
	
	public void clickEvent(Square s) {
		rc.playOneTurn(s);
	}
	
	public void hoverEvent(GUISquare s) {
		s.setHover();
	}
}
