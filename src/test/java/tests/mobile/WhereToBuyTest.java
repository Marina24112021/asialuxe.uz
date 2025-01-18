package tests.mobile;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.WhereToBuyScreen;

@Tag("emulation")
@Tag("browserstack")
public class WhereToBuyTest extends TestBaseMobile {
    WhereToBuyScreen user = new WhereToBuyScreen();

    @Test
    @Description("Проверка адреса филиала на странице Офисы продаж")
    void checkAddressesOfSalesAgenciesTest() {
        user.clickOnProfile()
                .clickOnWhereToBuy()
                .checkTitleOfAbout()
                .checkTitleOfExpArticle();
    }
}
