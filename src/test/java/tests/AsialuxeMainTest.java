package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.helpers.extensions.WithLogin;
import tests.pages.MainPage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Owner("Marina Chen")
@Tag("smoke")
public class AsialuxeMainTest extends TestBase {
    @Test
    @WithLogin
    @DisplayName("Проверка отображения сообщения при поиске билетов")
    void checkMessageOfSearchingIsAppearedInSearchPanelOnMainPageTest(){
        //MainPage mainPage = new MainPage();
        //mainPage.checkSearchPanel();
        List<String> liness = null;
        try {
            Path filePath = Path.of("secretdata/credentialsasialuxe"); // Укажите путь к вашему файлу
            liness = Files.readAllLines(filePath);
            liness.forEach(System.out::println); // Печатает каждую строку
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
