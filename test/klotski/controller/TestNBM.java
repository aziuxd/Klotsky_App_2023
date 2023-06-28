package klotski.controller;
 
import static org.junit.Assert.*;

import org.junit.Test;

import klotski.model.Board;
import klotski.model.Piece;
import klotski.view.KlotskiApp;
import static org.junit.Assert.*;

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
    Board c =new Board();
	c.setConfig(1);
    
    assertTrue(c.equals(b));

}
}