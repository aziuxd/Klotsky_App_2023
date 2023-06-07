
package klotski.controller;

import klotski.model.Board;
import klotski.model.Piece;

import klotski.view.KlotskiApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

public class NextBestMove {
	final KlotskiApp app;
	Board b;

	// conf 1
	String file1 = "NBM_DB/Conf1.txt";
	// conf 2
	String file2 = "NBM_DB/Conf2.txt";
	// conf 3
	String file3 = "NBM_DB/Conf3.txt";
	// conf 4
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

	public void NextMove() {
		int startLine = 1;
		int inizio_p = 1;
		Board temp = new Board();
		boolean foundMatch = false;
		String file = configuration(b.getConfig());
		while (!foundMatch) {
			try {

				List<String> lines = reading(file, startLine, inizio_p);
				// lista non valida
				if (lines.isEmpty()) {

					break;
				}

				temp.setPieces(lines);
				if (b.equals(temp)) {
					List<String> nuova = reading(file, startLine + 11, inizio_p);
					// controlla che pezzo sia in posizione giusta e lo muove altrimenti esce
					if (nuova.isEmpty()) {
						Piece red = b.getPieces()[0];
						if (red.getDims()[0] == 1 && red.getDims()[1] == 3) {
							b.selectPiece(red.getDims()[0], red.getDims()[1]);
							new MovePieceController(app, b).move(2);

							break;

						}
						// configurazione non trovata
						else {
							break;
						}

					}

					b.setPieces(nuova);
					b.setMove(b.getMoves());
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

	// legge il file e salva un array di pezzi in una lista
	public static List<String> reading(String filePath, int startLine, int lineNumber) throws IOException {
		List<String> lines = new ArrayList<>();
		int linea_curr = startLine;

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			// funziona fino ad un certo punto
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

	// funzione che sceglie il filepath in base alla configurazione della board
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
