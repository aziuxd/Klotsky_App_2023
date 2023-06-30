package klotski.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Controller class responsible for deleting all the files in a folder.
 */
public class DeleteFilesInFolder {

    String folderPath;
    //Basic constructor of the class sets the folder path to "cache_undo".
    public DeleteFilesInFolder() {

        folderPath = "cache_undo";
    }
    // A method that delete the file in the specific folder
    public void DeleteFiles() {
        try

        {
            Path directory = Paths.get(folderPath);
            Files.walk(directory)
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            Files.delete(file);

                        } catch (Exception e) {
                            System.out.println("Error deleting file: " + file);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
