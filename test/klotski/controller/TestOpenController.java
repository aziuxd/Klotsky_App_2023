package klotski.controller;

import org.junit.Test;
import java.nio.file.Path;

import java.nio.file.Paths;
import klotski.model.Board;
import klotski.view.KlotskiApp;
import static org.junit.Assert.*;


public class TestOpenController {
    String pathFile = "TestOpenCotroller.txt";
    Path path=  Paths.get(pathFile);
    @Test 
    public void TestOpen() {
        Board b = new Board();
	    KlotskiApp app = new KlotskiApp(b);
        
        NextBestMove best = new NextBestMove(app, b);
        best.NextMove();
        SaveController save = new SaveController(b, path, pathFile);
        save.save();
        ResetPuzzleController reset = new ResetPuzzleController(app, b);
        reset.reset();
        
        OpenController testCont = new OpenController(app, b, path);
        
        assertTrue(testCont.open());
    }
}
