package tests.mobile;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.PromotionArchive;

@Tag("emulation")
@Tag("browserstack")
public class PromotionArchiveTest extends TestBaseMobile{
    final PromotionArchive prom = new PromotionArchive();

    @Test
    @Description("Проверка адреса филиала на странице Офисы продаж")
    void checkTitleOfPromotionArchiveTest() {
        prom.clickOnProfile()
                .clickOnArchive()
                .checkTitleOfArchive()
                .checkTitleOfServices();
    }
}
