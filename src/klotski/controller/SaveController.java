package klotski.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import klotski.model.Board;
/**
 * Controller class responsible for creating the savefile.
 */
public class SaveController {
	final Board b;
	final Path p;
	final String time;

	/**
	 * Basic constructor
	 * 
	 * @param p the path of th file to save to
	 * @param b   the model board
	 * @param time  the time of the game
	 */
	public SaveController(Board b, Path p, String time) {
		this.b = b;
		this.p = p;
		this.time = time + "\n";
	}

	/**
	 * Saves the state of the board to a text file at the given path
	 * 
	 * @return true if successful save, false otherwise
	 */
	public boolean save() {
		// Convert the string to a byte array.
		String s = b.toString();
		byte data[] = s.getBytes();
		byte data2[] = time.getBytes();

		try (OutputStream out = new BufferedOutputStream(
				Files.newOutputStream(p))) {
			out.write(data2, 0, data2.length);

			out.write(data, 0, data.length);
			// out.flush();
			// out.write(data2, data.length, data2.length);
		} catch (IOException e) {
			System.err.println(e);
			return false;
		}
		return true;
	}
}
