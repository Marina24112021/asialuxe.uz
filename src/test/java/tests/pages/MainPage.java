package tests.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tests.helpers.ReadFileToList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    ElementsCollection elements = $$("div .grid.grid-cols-2.md\\:grid-cols-none.md\\:flex.gap-4.items-center.w-full.my-6 a");
    SelenideElement titleBlock = $(".line-block-text.text-center.mb-5");
    ElementsCollection collectionNamesOfAdvantageousOfAgency = $$(".gap-\\[37px\\].grid.md\\:grid-cols-2.lg\\:grid-cols-2.xl\\:grid-cols-4.grid-cols-1");
    SelenideElement button = $(".md\\:w-\\[20\\%\\].md\\:block");
    SelenideElement input = $("input[placeholder='Дата вылета']");
    SelenideElement fromInput = $("[placeholder='Откуда']"),
                    toInput = $("[placeholder='Куда']"),
    mainSearch = $("#main_search");

    public void checkNamesOfMenu() {
        step("Открыть главную страницу", () -> open("/ru"));
        List<String> actualListOfTitles = elements.texts();
        List<String> expectedListOfTitles = Arrays.asList("Авиа", "Отели", "Туры", "Чартеры", "Трансферы");
        Collections.sort(actualListOfTitles);
        Collections.sort(expectedListOfTitles);
        assertEquals(actualListOfTitles, expectedListOfTitles);
    }

    public void checkSearchPanel(){
        step("Открыть главную страницу", () -> open("/ru"));
        fromInput.shouldBe(visible).click();
        step("Заполнить поле Откуда", () -> fromInput.shouldBe(editable).setValue("Tashkent"));
        fromInput.parent().sibling(0).$$("ul li").first().click();
        step("Заполнить поле Куда", () -> toInput.shouldBe(visible).setValue("Namangan"));
        step("Выбрать первое значение из выпадаюшего списка",()->toInput.parent().sibling(0).$$("li").first().click());
        step("Удалить аттрибут",()->executeJavaScript("arguments[0].removeAttribute('readonly')", input));
        step("Заполнить поле Дата ", () ->input.setValue(currentDate.plusDays(2).format(formatter)));
        step("Нажать на Поиск",()->button.click());
        step("Проверить что отображается сообщение о поиске билетов ", () ->
        mainSearch.parent().sibling(0).shouldHave(text("Пожалуйста, подождите, мы находим для вас лучшие варианты...")));
    }
    public void checkBlockAboutAgencyCompareThroughFile() throws Exception {
        step("Открыть главную страницу", () -> open("/ru"));
        step("Проверить что отображается нужный заголовок", () -> titleBlock.shouldHave(text("Почему мы")));
        List<String> expectedTextAboutAgency = step("Открыть файл чтобы получить текст", () ->
                ReadFileToList.readFile("blockAboutAgency"));
        step("Проверить что тексты совпадают", () ->
                collectionNamesOfAdvantageousOfAgency.shouldHave(CollectionCondition.texts(expectedTextAboutAgency)));
    }
}
