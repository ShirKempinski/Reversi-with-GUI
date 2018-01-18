package GUI;

import reversiGame.Square;

public class SquareListener {

	private ReversiController rc;
	
	
	/**
	 * function name: SquareListener
	 * input: ReversiController controller
	 * output: new object of SquareListener
	 * operation: constructor
	 */
	public SquareListener(ReversiController controller) {
		this.rc = controller;
	}
	
	
	/**
	 * function name: clickEvent
	 * input: Square s
	 * output: void
	 * operation: The function runs the game again after the player selects his or her move.
	 */
	public void clickEvent(Square s) {
		rc.playOneTurn(s);
	}
	
	/**
	 * function name: hoverEvent
	 * input: GUISquare s
	 * output: void
	 * operation: The function hover hevnt.
	 */
	public void hoverEvent(GUISquare s) {
		s.setHover();
	}
}
