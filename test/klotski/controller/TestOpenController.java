package klotski.controller;

import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;


import java.util.ArrayList;
import java.util.List;

import klotski.model.Board;
import klotski.view.KlotskiApp;
import static org.junit.Assert.*;



public class TestOpenController {
   
    
    @Test
    public void TestOpen() {
         
        Board board = new Board();
         KlotskiApp app = new KlotskiApp(board);
         Path filePath = Path.of("TestOpenController.txt");
        OpenController openController = new OpenController(app, board, filePath);
        
        List<String> lines = new ArrayList<>();
         lines.add("01:12");
         lines.add("14");
         lines.add("0 0 2 2");
         lines.add("1 3 1 2");
         lines.add("3 2 1 2");
         lines.add("0 3 1 2");
         lines.add("0 2 1 1");
         lines.add("2 0 1 1");
         lines.add("3 0 1 2");
         lines.add("2 2 1 1");
         lines.add("2 1 1 1");
         lines.add("2 4 2 1");

        Charset charset = Charset.forName("UTF-8");
        try{
        // Write the lines to the test file
        Files.write(filePath, lines, charset);

        boolean result = openController.open();
        assertTrue(result);
        
       
        

        // Delete the test file
        Files.delete(filePath);
        } catch (Exception e){
            System.out.println(e.getMessage());

        } 
    }
}
