package klotski.controller;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import java.io.*;

import klotski.model.Board;
import klotski.view.KlotskiApp;

/**
 * Controller class responsible for undoing the last move in the game.
 */
public class UndoMoveController {
    KlotskiApp app;
    Board b;
    String s = "cache_undo/tmpSave.txt";
    final Path p = Path.of(s);
    /**
     * Constructor for the UndoMoveController class.
     * 
     * @param app 
     * @param b  
     */
    public UndoMoveController(KlotskiApp app, Board b) {
        this.app = app;
        this.b = b;

    }

    /*  function that pulls the last move made from the file and then undoes it
     * the file format is the same as the save file format but it as all the moves
     * of the
     * game in order from first to last move made in the game
     */
    public void undoMove() {
        String filePath = s; // Path of the file
        try {
            File file = new File(filePath);
            List<String> lines = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(file));

            // Read all the lines and store them in the list
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // Check if there are enough lines to remove
            if (lines.size() > 11)
                RemoveLastLinesFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Charset charset = Charset.forName("UTF-8");
        try {
            // Read the last 11 lines from the file
            List<String> lines = Files.lines(p, charset)
                    .skip(Math.max(0, Files.lines(p, charset).count() - 11))
                    .collect(Collectors.toList());

            // Update the configurations of the pieces in the board
            b.setPieces(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        app.getPuzzleView().refresh();
        app.getMovesCounter().setText(Integer.toString(b.getMoves()));
    }
    /**
     * Remove the last lines from the file.
     */
    public void RemoveLastLinesFromFile() {

        String filePath = s; // Path of the file
        try {
            File file = new File(filePath);
            List<String> lines = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(file));

            // Read all the lines and store them in the list
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // Check if there are enough lines to remove
            if (lines.size() >= 11) {
                 // Remove the last 11 lines
                int startIndex = lines.size() - 11;
                int endIndex = lines.size();
                lines.subList(startIndex, endIndex).clear();

                // Overwrite the file with the updated content
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
                writer.close();
            } else {
                System.out.println("Il file non ha abbastanza righe da rimuovere.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
