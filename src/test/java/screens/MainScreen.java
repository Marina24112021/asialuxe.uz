package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainScreen {
    SelenideElement titleTop = $x("//android.widget.TextView[@text=\"Когда, если не сейчас ?\"]");
    SelenideElement titleHotel = $x("//android.widget.TextView[@text=\"Отели\"]");
    SelenideElement titleAvia = $x("//android.widget.TextView[@text=\"Авиа\"]");
    SelenideElement titleTour = $x("//android.widget.TextView[@text=\"Туры\"]");
    SelenideElement titleCatalog = $x("(//android.widget.TextView[@text=\"Каталог\"])[1]");

    // SelenideElement titleHistory = $x("//android.widget.TextView[@text=\"Вы недавно смотрели\"]");
    public void checkStaticTitles() {
        assertEquals("Когда, если не сейчас ?", titleTop.getText());
        assertEquals("Отели", titleHotel.getText());
        assertEquals("Авиа", titleAvia.getText());
        assertEquals("Туры", titleTour.getText());
        assertEquals("Каталог", titleCatalog.getText());
        //  assertEquals("Вы недавно смотрели", titleHistory.getText());
    }
}
