package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFileToList {
    public static Properties readSecretFiles(String pathToFile) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(pathToFile));
        return properties;
    }
}
