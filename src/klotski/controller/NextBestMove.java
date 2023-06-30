
package klotski.controller;

import klotski.model.Board;
import klotski.model.Piece;

import klotski.view.KlotskiApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
/**
 * Controller class responsible for managing the next best move operation.
 */
public class NextBestMove {
	final KlotskiApp app;
	Board b;

	// File that contains all the combinations for the first cofiguration
	String file1 = "NBM_DB/Conf1.txt";
	// File that contains all the combinations for the second cofiguration
	String file2 = "NBM_DB/Conf2.txt";
	// File that contains all the combinations for the third cofiguration
	String file3 = "NBM_DB/Conf3.txt";
	// File that contains all the combinations for the fourth cofiguration
	String file4 = "NBM_DB/Conf4.txt";

	// risoluzione configurazione 1
	/**
	 * Basic constructor
	 * 
	 * @param app the view application
	 * @param b   the model board
	 */
	public NextBestMove(KlotskiApp app, Board b) {
		this.app = app;
		this.b = b;
	}
    /*A method that executes the next best move. 
	This method checks the current configuration of the Board and searches for matches within the specified configuration files,
	once a match is found, it executes the corresponding move.
	
	*/
	public void NextMove() {
		int startLine = 1;
		int inizio_p = 1;
		Board temp = new Board();
		boolean foundMatch = false;
		String file = configuration(b.getConfig());
		while (!foundMatch) {
			try {

				List<String> lines = reading(file, startLine, inizio_p);
				
				if (lines.isEmpty()) {
                 //if we get  there is no configuration in the Database 
					break;
				}

				temp.setPieces(lines);
				if (b.equals(temp)) {
					List<String> nuova = reading(file, startLine + 11, inizio_p);
					//Checks if the red piece is in the  victory position 
					if (nuova.isEmpty()) {
						Piece red = b.getPieces()[0];
						//if we get there the red piece is in the victory position and move the piece down 
						if (red.getDims()[0] == 1 && red.getDims()[1] == 3) {
							b.selectPiece(red.getDims()[0], red.getDims()[1]);
							new MovePieceController(app, b).move(2);

							break;

						}
						// if we get here the red piece isn't in the victory position 
						else {
							break;
						}

					}
                    // the board configuration is found so we do the next move
					b.setPieces(nuova);
					app.getMovesCounter().setText(Integer.toString(b.getMoves()));
					app.getPuzzleView().refresh();
                    
		             foundMatch = true;
				} else {
                   
					startLine += 11;

				}
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}

		}

	}

	/**
	 * Static function that read a file from a starting line to a ending line 
	 * 
	 * @param filePath a string that represent the path of the file to be read 
	 * @param startLine an integer that indicates the starting line from wich to star reading the file 
	 * @param lineNumber an integer that indicates the number of lines that the function has to read 
	 * @return a list of string that contains the information of the lines that have been read 
	 */
	public static List<String> reading(String filePath, int startLine, int lineNumber) throws IOException {
		List<String> lines = new ArrayList<>();
		int linea_curr = startLine;

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			
			while (lineNumber < startLine && reader.readLine() != null) {
				lineNumber++;
			}

			while ((line = reader.readLine()) != null && linea_curr < startLine + 11) {
				if (linea_curr >= startLine) {
					lines.add(line);
				}
				linea_curr++;

			}
			reader.close();
		}

		return lines;
	}

	/**
	 * function that return the string of the filepath of the corresponding configuration 
	 * @param i an integer that represents the possible configuration 
	 * @return a string that represent the path of a file 
	 */
	public String configuration(int i) {
		String file = "";
		if (i == 1) {
			file = file1;
		}

		else if (i == 2) {
			file = file2;
			return file;

		} else if (i == 3) {
			file = file3;

		} else if (i == 4) {
			file = file4;
		}
		return file;
	}

}
