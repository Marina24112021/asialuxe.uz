package tests.web;

import helpers.extensions.WithLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HotelsPage;


public class HotelTest extends TestBase {
    HotelsPage hotelsPage = new HotelsPage();

    @Test
    @Tag("smoke")
    // @WithLogin
    @DisplayName("Проверка по корректному отображению заголовка")
    void checkStaticHeaderPageOfHotelTest() {

        hotelsPage.checkStaticInfoTitlesOfHotel();
    }

    @Test
    @Tag("smoke")
    @WithLogin
    @DisplayName("Проверка по отображению заголовок о детализации отеля")
    void checkStaticHeaderIsDisplayedOnDetailPageOfHotelTest() {

        hotelsPage.checkInfoTitlesOnDetailPage();
    }


}
