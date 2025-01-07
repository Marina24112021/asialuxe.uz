package tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class HotelsPage {
    ElementsCollection elements = $$("div .grid.grid-cols-2.md\\:grid-cols-none.md\\:flex.gap-4.items-center.w-full.my-6 a");
    SelenideElement elementHotel = $(".content-title.my-3.h5.w-\\[50\\%\\].md\\:w-full.transition-200.dark\\:text-white-100");
    ElementsCollection swiperWrapper = $$(".swiper-wrapper");
    SelenideElement facilities = $("#facilities"),
            location = $("h3.mb-2.card-title.transition-200.dark\\:\\!text-white-100"),
            policy = $(".card-title.mb-3.transition-200.dark\\:\\!text-white-100"),
            checkInOut = $("div[data-v-152fdae9].flex.items-center.gap-2"),
            instruction = $("div[data-v-152fdae9].flex.items-start.gap-3.transition-200.dark\\:\\!text-white-100");

    public void checkStaticInfoTitlesOfHotel() {
        step("Открыть главную страницу",()->open("/ru"));
        step("Кликнуть на Отели в меню",()->elements.filterBy(text("Отели")).first().click());
        step("Проверить что нужный текст найден",()->elementHotel.shouldHave(text("Эксклюзивные отели Asialuxe")));
    }
    public void checkInfoTitlesOnDetailPage(){
        step("Открыть главную страницу",()->open("/ru"));
        step("Кликнуть Отели в меню",()->elements.filterBy(text("Отели")).first().click());
        step("Кликнуть по 1му отелю в нижней карусели",()->swiperWrapper.get(0).click());
        step("Закрыть предыдущую вкладку",()->switchTo().window(getWebDriver().getWindowHandle()).close());
        step("Поменять индекс вкладки на основную(0)",()->switchTo().window(0));
        step("Проверить что отобразилась нужная детализация отеля ",()->facilities.shouldHave(text("Главные удобства отеля")));
        step("Проверить что отобразилость поле - Информация ",()->facilities.parent().sibling(0).shouldHave(text("Информация")));
        step("Проверить что отобразилость поле - Расположение ",()->location.shouldHave(text("Расположение")));
        step("Проверить что отобразилость поле - Политика ",()->policy.shouldHave(text("Политика")));
        step("Проверить что отобразилость поле - Информация ",()->checkInOut.shouldHave(text("Заезд в:")));
        step("Проверить что отобразилость поле - Заезд в: ",()->checkInOut.sibling(0).shouldHave(text("Выезд в:")));
        step("Проверить что отобразилость поле - Инструкция по заезду: ",()->instruction.shouldHave(text("Инструкция по заезду:")));
        step("Проверить что отобразилость поле - Специальная инструкция по заезду: ",()->instruction.sibling(1).shouldHave(text("Специальная инструкция по заезду:")));
    }
}
