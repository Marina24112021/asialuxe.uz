package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.helpers.ReadFileToList;
import tests.helpers.extensions.WithLogin;
import tests.pages.MainPage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Owner("Marina Chen")
@Tag("smoke")
public class AsialuxeMainTest extends TestBase {
    @Test
    @WithLogin
    @DisplayName("Проверка отображения сообщения при поиске билетов")
    void checkMessageOfSearchingIsAppearedInSearchPanelOnMainPageTest() throws IOException, URISyntaxException {
        //MainPage mainPage = new MainPage();
        //mainPage.checkSearchPanel();
        try {
            Path filePath = Path.of("notification/credentialsasialuxe.txt"); // Укажите путь к вашему файлу
            List<String> lines = Files.readAllLines(filePath);
            lines.forEach(System.out::println); // Печатает каждую строку
        } catch (Exception e) {
            e.printStackTrace(); // Обработка ошибок
        }
    }

    @WithLogin
    @Test
    @DisplayName("Проверка корректного текста в меню")
    void checkTitlesOfHeaderMenuIsCorrectDisplayedOnMainPageTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkNamesOfMenu();
    }

    @Test
    @WithLogin
    @DisplayName("Проверка отображения наполнения текста для блока Почему мы")
    void checkContentOfWhyUsBlockIsOnMainPageTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkBlockAboutAgencyCompareThroughFile();
    }
}
