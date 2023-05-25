package klotski.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFilesInFolder {

    String folderPath;

    public DeleteFilesInFolder() {

        folderPath = "cache_undo";
    }

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
