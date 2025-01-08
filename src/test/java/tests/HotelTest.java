package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.helpers.extensions.WithLogin;
import tests.pages.HotelsPage;


public class HotelTest extends TestBase {
    @Test
    @Tag("smoke")
    @WithLogin
    @DisplayName("Проверка по корректному отображению заголовка")
    void checkStaticHeaderPageOfHotelTest() {
        HotelsPage hotelsPage = new HotelsPage();
        hotelsPage.checkStaticInfoTitlesOfHotel();
    }

    @Test
    @Tag("smoke")
    @WithLogin
    @DisplayName("Проверка по отображению заголовок о детализации отеля")
    void checkStaticHeaderIsDisplayedOnDetailPageOfHotelTest() {
        HotelsPage hotelsPage = new HotelsPage();
        hotelsPage.checkInfoTitlesOnDetailPage();
    }
}
