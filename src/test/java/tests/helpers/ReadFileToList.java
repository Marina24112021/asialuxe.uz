package tests.helpers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadFileToList {
    public static List<String> readFile(String nameOfFile) throws IOException, URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(ReadFileToList.class.getClassLoader().getResource("data/" + nameOfFile)).toURI());
        String content = Files.readString(path);
        List<String> container = new ArrayList<>();
        container.add(content);
        return container;

    }
    public static List<String> readSecretFiles(String pathToFile) {
        List<String> linesArr = null;
        try {
            Path pathFile = Path.of("src/test/resources/data/"+pathToFile);
            linesArr = Files.readAllLines(pathFile);
        } catch (Exception e){
            e.printStackTrace(); // Обработка ошибок
        }
        return linesArr;
    }
}
