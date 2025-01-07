package tests.helpers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFileToList {
    public static List<String> readFile(String nameOfFile) throws IOException, URISyntaxException {
        Path path = Path.of("src/test/resources/data/" + nameOfFile);
        String content = Files.readString(path);
        List<String> container = new ArrayList<>();
        container.add(content);
        container.forEach(System.out::println);
        return container;

    }
}
