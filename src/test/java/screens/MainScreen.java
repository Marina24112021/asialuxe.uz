package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainScreen {
    final SelenideElement titleHi = $x("//android.widget.TextView[@text=\"Привет, Путешественник\"]");
    final SelenideElement titleTop = $x("//android.widget.TextView[@text=\"Когда, если не сейчас ?\"]");
    final SelenideElement titleHotel = $x("//android.widget.TextView[@text=\"Отели\"]");
    final SelenideElement titleAvia = $x("//android.widget.TextView[@text=\"Авиа\"]");
    final SelenideElement titleTour = $x("//android.widget.TextView[@text=\"Туры\"]");
    final SelenideElement titleCatalog = $x("(//android.widget.TextView[@text=\"Каталог\"])[1]");

    public void checkStaticTitles() {
        assertEquals("Привет, Путешественник", step("Взять название страницы ", () -> titleHi.getText()));
        assertEquals("Когда, если не сейчас ?", step("Взять название страницы ", () -> titleTop.getText()));
        assertEquals("Отели", step("Взять название статьи ", () -> titleHotel.getText()));
        assertEquals("Авиа", step("Взять название страницы ", () -> titleAvia.getText()));
        assertEquals("Туры", step("Взять название страницы ", () -> titleTour.getText()));
        assertEquals("Каталог", step("Взять название страницы ", () -> titleCatalog.getText()));
    }
}
