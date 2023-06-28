package klotski.controller;
 
import static org.junit.Assert.*;

import org.junit.Test;

import klotski.model.Board;
import klotski.model.Piece;
import klotski.view.KlotskiApp;import static org.junit.Assert.*;

import org.junit.Test;

import klotski.model.Board;
import klotski.view.KlotskiApp;
public class TestNBM {
@Test 
public void TestNextBestMove(){
    Board b = new Board();
	KlotskiApp app = new KlotskiApp(b);
    b.setConfig(1);
	NextBestMove testNBM = new NextBestMove(app, b);
	testNBM.NextMove();
    
    Piece[] test = new Piece[10];
		
			test[0] = new Piece(1, 0, 2, 2);
			test[1] = new Piece(1, 2, 1, 2);
			test[2] = new Piece(2, 2, 1, 2);
			test[3] = new Piece(0, 3, 1, 2);
			test[4] = new Piece(0, 0, 1, 1);
			test[5] = new Piece(3, 0, 1, 1);
			test[6] = new Piece(3, 2, 1, 2);
			test[7] = new Piece(0, 1, 1, 1);
			test[8] = new Piece(3, 1, 1, 1);
			test[9] = new Piece(1, 4, 2, 1);
    Board test1= new Board(test);
    assertFalse(test1.equals(b));

}
}