package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    Faker faker = new Faker();
    final LocalDate currentDate = LocalDate.now();
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    final SelenideElement button = $("#main_search").lastChild().lastChild();
    final SelenideElement input = $("input[placeholder='Дата вылета']");
    final SelenideElement fromInput = $("[placeholder='Откуда']");
    final SelenideElement toInput = $("[placeholder='Куда']");
    final SelenideElement mainSearch = $("#main_search");
    final ElementsCollection listWhereFrom = fromInput.parent().sibling(0).$$("ul li");
    final ElementsCollection listWhereTo = toInput.parent().sibling(0).$$("li");
    final ElementsCollection textsOfMenu = $$("main.container div div a div p");
    final SelenideElement sidebar = $("#sidebar");
    final SelenideElement logEmail = $("#logEmail");
    final SelenideElement logPass = $("#logPass");
    final SelenideElement logButton = $("[for='logPass']").parent().parent().lastChild().$("[type='button']");
    final SelenideElement logAlert = $("div[role='alert'] p");

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("/ru");
        return this;
    }

    @Step("Нажать на поле Откуда")
    public MainPage clickOnFieldWhere() {
        fromInput.shouldBe(visible).click();
        return this;
    }

    @Step("Заполнить поле Откуда")
    public MainPage fillInputWhereFrom() {
        fromInput.shouldBe(editable).setValue("Tashkent");
        return this;
    }

    @Step("Выбрать первое значение из выпадаюшего списка")
    public MainPage selectFirstValueWhereFrom() {
        listWhereFrom.first().click();
        return this;
    }

    @Step("Заполнить поле Куда")
    public MainPage fillInputWhereTo() {
        toInput.shouldBe(visible).setValue("Namangan");
        return this;
    }

    @Step("Выбрать первое значение из выпадаюшего списка")
    public MainPage selectFirstValueWhereTo() {
        listWhereTo.first().click();
        return this;
    }

    @Step("Удалить аттрибут")
    public MainPage removeAttr() {
        executeJavaScript("arguments[0].removeAttribute('readonly')", input);
        return this;
    }

    @Step("Заполнить поле Дата ")
    public MainPage fillInputDate() {
        input.setValue(currentDate.plusDays(2).format(formatter));
        return this;
    }

    @Step("Нажать на Поиск")
    public MainPage clickOnSearch() {
        button.click();
        return this;
    }

    @Step("Проверить что отображается сообщение о поиске билетов ")
    public void checkMessageOfSearching() {
        mainSearch.parent().sibling(0).shouldHave(text("Пожалуйста, подождите, мы находим для вас лучшие варианты..."));
    }

    public void checkTextInMenu(String... listMenuText) {
        for (int i = 0; i < listMenuText.length; i++) {
            textsOfMenu.get(i).shouldHave(text(listMenuText[i]));
        }
    }
    @Step("Нажать на Войти с главной страницы")
    public MainPage clickOnLoginToOpenLoginForm() {
        sidebar.click();
        return this;
    }

    @Step("Установить некорректный логин")
    public MainPage setLogin() {
        logEmail.setValue(faker.name().lastName());
        return this;
    }

    @Step("Установить некорректный пароль")
    public MainPage setPassword() {
        logPass.setValue(faker.phoneNumber().cellPhone());
        return this;
    }

    @Step("Нажать на кнопку Войти")
    public void clickOnLogin() {
        logButton.click();
    }

    @Step("Запустить скрипт по заморозке сообщения об ошибке")
    public void runScriptToFrozenAlertMessage() {
        Selenide.executeJavaScript(
                "var toastProgressBar = document.querySelector('.Vue-Toastification__progress-bar');" +
                        "if (toastProgressBar) { toastProgressBar.remove(); }");
    }

    @Step("Сообщение об ошибке корректно отображается ")
    public void checkAlertMessageIsAppeared() {
        logAlert.shouldHave(Condition.text("Логин или пароль не верный"));
    }
}
