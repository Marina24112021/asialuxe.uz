package tests.mobile;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.AboutCompanyScreen;

@Tag("emulation")
@Tag("browserstack")
public class AboutCompanyTest extends TestBaseMobile {
    final AboutCompanyScreen about = new AboutCompanyScreen();
    @Test
    @Description("Проверка статичного заголовка на странице О Компании")
    void checkListOfTitleInProfileTest() {
        about.clickOnProfile()
                .clickOnAboutCompany()
                .checkTitleOfAboutCompany()
                .checkTitleOfServices();
    }
}
