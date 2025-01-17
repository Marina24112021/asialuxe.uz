package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CustomToursPage {
    Faker faker = new Faker();
    SelenideElement buttonBook = $(".grow button[type='primary']");
    SelenideElement messageText = $$("div[data-headlessui-state='open']").last().lastChild().$("div");
    ElementsCollection dataField = $$("input[data-test='dp-input']"),
            listBox = $$(".block.truncate");
    SelenideElement fullName = $("input[placeholder='Полное имя']"),
            email = $("input[placeholder='Эл. адрес']"),
            phoneNum = $("div[aria-label='Country Code Selector']"),
            lastName = $("[placeholder='Фамилия']"),
            name = $("[placeholder='Имя']"),
            passportNum = $("[placeholder='Серия и № паспорта']"),
            checkboxCheck = $("input[type=checkbox]"),
            bookTour = $(byText("Забронировать")),
            successMessage = $("div.Vue-Toastification__toast-component-body");

    @Step("Открыть главную страницу")
    public CustomToursPage openTour(String path) {
        open(path);
        return this;
    }

    @Step("Нажать на кнопку Заказать тур")
    public CustomToursPage clickOnBookTour() {
        buttonBook.click();
        return this;
    }

    @Step("Текст сообщения о требовании авторизации корректный ")
    public void checkTexts(String expectedText) {
        messageText.shouldHave(Condition.exactText(expectedText));
    }

    public CustomToursPage setFullName() {
        fullName.setValue(faker.name().fullName());
        return this;
    }

    public CustomToursPage setEmail() {
        email.setValue(faker.internet().emailAddress());
        return this;
    }

    public CustomToursPage setPhoneNum() {
        phoneNum.sibling(0).setValue("");
        return this;
    }

    public CustomToursPage setLastName() {
        lastName.setValue(faker.name().lastName());
        return this;
    }

    public CustomToursPage setName() {
        name.setValue(faker.name().firstName());
        return this;
    }

    public CustomToursPage setBirthday() {
        dataField.first().setValue("11/11/1980");
        return this;
    }

    public CustomToursPage setGender() {
        listBox.first().parent().click();
        $(byText("Мужской")).click();
        return this;
    }

    public CustomToursPage setCitizenship() {
        listBox.last().parent().click();
        $(byText("UZB-Uzbekistan")).click();
        return this;
    }

    public CustomToursPage setPassportNum() {
        passportNum.setValue("AD"+faker.number().digits(7));
        return this;
    }

    public void setPassportExpiration() {
        dataField.last().setValue("11/11/2027");
    }
    public CustomToursPage closeCalender() {
        name.click();
        return this;
    }

    public CustomToursPage checkThePolicy() {
        checkboxCheck.click();
        return this;
    }

    public void runScriptToFrozenAlertMessage() {
        Selenide.executeJavaScript(
                "var toastProgressBar = document.querySelector('.Vue-Toastification__progress-bar');" +
                        "if (toastProgressBar) { toastProgressBar.remove(); }");
    }
    public CustomToursPage bookTour() {
        bookTour.click();
        return this;
    }

    public CustomToursPage getSuccessMessage() {
        successMessage.shouldHave(Condition.text("Ошибка валидации"));
        return this;
    }
}
