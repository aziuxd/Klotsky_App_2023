package klotski.controller;

import klotski.model.Board;
import klotski.view.KlotskiApp;
/**
 * Controller class responsible for setting the chosen configuration.
 */
public class SetConfigController {
	KlotskiApp app;
	Board b;
     /**
     * Constructor for the SetConfigController class.
     * 
     * @param app The KlotskiApp instance.
     * @param b   The Board instance.
     */
	public SetConfigController(KlotskiApp app, Board b) {
		this.app = app;
		this.b = b;
	}
    /**
     * Sets the configuration number for the Board.
     * 
     * @param number The configuration number to set.
     */
	public void setConfig(int number) {
		b.setConfig(number);
		b.reset();
		app.getPuzzleView().refresh();
		app.getMovesCounter().setText(Integer.toString(b.getMoves()));
	}
}
