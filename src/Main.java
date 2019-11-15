import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args)
    {
        moveFiles();
    }

    private static void moveFiles()
    {
        String BASE = "H:\\";
        int COUNT = 0;

        File folder = new File(BASE);
        File tempDir;
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                COUNT++;

                tempDir = new File(BASE + COUNT);
                tempDir.mkdir();
                try {
                    Path temp = Files.move
                            (Paths.get(BASE + file.getName()),
                                    Paths.get(BASE + COUNT + "\\" + file.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
