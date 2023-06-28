package klotski.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

import static org.junit.Assert.*;

import org.junit.Test;

import klotski.model.Board;

public class TestSaveController {
    
    @Test
    public void testSaveController() {
        Board board = new Board();
        Path p = Paths.get("TestSaveController.txt");
        String time = "10:30";

        // Creazione dell'istanza del SaveController
        SaveController saveController = new SaveController(board, p, time);

        // Esecuzione del metodo save()
        boolean result = saveController.save();

        // Verifica del risultato
        assertTrue(result);

        // Opzionale: Verifica che il file sia stato effettivamente creato
        assertTrue(Files.exists(p));

        // Opzionale: Pulizia del file creato
        try {
            Files.deleteIfExists(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}