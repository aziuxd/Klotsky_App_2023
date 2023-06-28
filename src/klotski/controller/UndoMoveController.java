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

//hei questo è un commento mio perchè lo ho fatto io JACOPO pollo fritto
public class UndoMoveController {
    KlotskiApp app;
    Board b;
    String s = "cache_undo/tmpSave.txt";
    final Path p = Path.of(s);

    public UndoMoveController(KlotskiApp app, Board b) {
        this.app = app;
        this.b = b;

    }

    // function that pulls the last move made from the file and then undoes it
    // the file format is the same as the save file format but it as all the moves
    // of the
    // game in order from first to last move made in the game
    public void undoMove() {
        String filePath = s; // Path of the file
        try {
            File file = new File(filePath);
            List<String> lines = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(file));

            // Leggi tutte le righe e memorizzale nella lista
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // Verifica se ci sono abbastanza righe da rimuovere
            if (lines.size() > 11)
                RemoveLastLinesFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Charset charset = Charset.forName("UTF-8");
        try {
            // Leggi le ultime 11 righe dal file
            List<String> lines = Files.lines(p, charset)
                    .skip(Math.max(0, Files.lines(p, charset).count() - 11))
                    .collect(Collectors.toList());

            // Aggiorna le configurazioni delle piece nel board
            b.setPieces(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        app.getPuzzleView().refresh();
        app.getMovesCounter().setText(Integer.toString(b.getMoves()));
    }

    public void RemoveLastLinesFromFile() {

        String filePath = s; // Path of the file
        try {
            File file = new File(filePath);
            List<String> lines = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(file));

            // Leggi tutte le righe e memorizzale nella lista
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // Verifica se ci sono abbastanza righe da rimuovere
            if (lines.size() >= 11) {
                // Rimuovi le ultime 11 righe
                int startIndex = lines.size() - 11;
                int endIndex = lines.size();
                lines.subList(startIndex, endIndex).clear();

                // Sovrascrivi il file con il nuovo contenuto
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
