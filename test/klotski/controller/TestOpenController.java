package klotski.controller;

import org.junit.Test;

import java.nio.file.Path;

import java.nio.file.Paths;
import klotski.model.Board;
import klotski.view.KlotskiApp;
import static org.junit.Assert.*;

public class TestOpenController {
    String pathFile = "C:/Users/decar/Desktop/Klotsky_App_2023-main/TestOpenCotroller";
    Path path=  Paths.get(pathFile);
    @Test 
    public void TestOpen() {
    Board b = new Board();
	KlotskiApp app = new KlotskiApp(b);
    OpenController Test =new OpenController(app, b, path);
    assertTrue(Test.open());
    }
}
