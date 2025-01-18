package tests.mobile;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.MainScreen;

@Tag("emulation")
@Tag("browserstack")

public class MobileTest extends TestBaseMobile {
    final MainScreen main = new MainScreen();

    @Test
    @Description("Проверка статичных заголовок на основной странице")
    void checkTitleOnMainPage() {
        main.checkTextOnMainPage()
                .checkStaticTextProposal()
                .checkTitleHotel()
                .checkTitleAvia()
                .checkTitleTour()
                .checkTitleCatalog();
    }

}
