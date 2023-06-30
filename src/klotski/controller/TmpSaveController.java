package klotski.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import klotski.model.Board;
import klotski.model.Piece;
/**
 * Class responsible for creating the temporary file used by the UndoController.
 */
public class TmpSaveController {
    Board board;
    Piece[] pieces;
    String FolderName = "cache_undo";
    File folder = new File(FolderName);
/**
     * Constructor for the TmpSaveController class.
     * 
     * @param b 
     */
    public TmpSaveController(Board b) {
        this.board = b;
        pieces = board.getPieces();
    }
    /**
     * Save the current configuration to a temporary file.
     */
    public void tmpSave() {
        try {
           //create the folder if it doesn't exist 
            if (!folder.exists()) 
                folder.mkdir();
            File file = new File("cache_undo/tmpSave.txt");
            boolean append = file.exists(); 

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, append));
            // print the current configuration on the tmp file

            writer.write(Integer.toString(board.getMoves()));
            writer.newLine();

            for (int i = 0; i < 10; i++) {
                int[] pezzi = pieces[i].getDims();
                writer.write(Integer.toString(pezzi[0]) + " ");

                writer.write(Integer.toString(pezzi[1]) + " ");

                writer.write(Integer.toString(pezzi[2]) + " ");

                writer.write(Integer.toString(pezzi[3]) + " ");
                writer.newLine();
            }

            writer.close();
            file.deleteOnExit();
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

}
